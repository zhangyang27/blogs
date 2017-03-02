/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package async.method.invocation;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implementation of async executor that creates a new thread for every task.
 * 为了每一个新任务建立一个新的线程来实现async executor。
 * @author zhangyang27
 *
 */
public class ThreadAsyncExecutor implements AsyncExecutor {
	 /** Index for thread naming **/
	private final AtomicInteger idx = new AtomicInteger();
	
	
	@Override
	public <T> AsyncResult<T> startProcess(Callable<T> task) {
		// TODO Auto-generated method stub
		return startProcess(task,null);
	}

	@Override
	public <T> AsyncResult<T> startProcess(Callable<T> task,
			AsyncCallback<T> callback) {
		// TODO Auto-generated method stub
		CompletableResult<T> result = new CompletableResult<>(callback);
		new Thread(()->{
			try{
				result.setValue(task.call());
			}catch(Exception ex){
				result.setException(ex);
			}
		},"executor - "+idx.incrementAndGet()).start();
		return result;
	}

	@Override
	public <T> T endProcess(AsyncResult<T> asyncResult)
			throws ExecutionException, InterruptedException {
		// TODO Auto-generated method stub
		if(!asyncResult.isCompleted()){
			asyncResult.await();
		}
		return asyncResult.getValue();
	}
	 /**
	   * Simple implementation of async result that allows completing it successfully with a value or exceptionally with an
	   * exception. A really simplified version from its real life cousins FutureTask and CompletableFuture.
	   * 
	   * 简单实现了 async result 的版本，这个版本使得异步执行任务能够以一个值作为成功执行的结果，或者抛出一个异常。
	   * 是现实生活中FutureTask和CompletableFuture的简单版本。
	   * 
	   * @see java.util.concurrent.FutureTask
	   * @see java.util.concurrent.CompletableFuture
	   */
	private static class CompletableResult<T> implements AsyncResult<T>{
		static final int RUNNING = 1;
		static final int FAILED = 2;
		static final int COMPLETED = 3;
		final Object lock;
		final Optional<AsyncCallback<T>> callback;
		/**
		 * 为啥多个线程需要共享这个state?
		 */
		volatile int state = RUNNING;
		T value;
		Exception exception;
		
		CompletableResult(AsyncCallback<T> callback) {
			// TODO Auto-generated constructor stub
			this.lock = new Object();
			this.callback = Optional.ofNullable(callback);
		}
		
		/**
		 * Sets the value from successful execution and executes callback if available. Notifies any thread waiting for
	     * completion.
	     * 当成功执行后设置此值，如果有回调函数，则执行回调函数。并通知所有等待该结果的进程。
	     * @param value
	     *          value of the evaluated task
		 * @return
		 */
		void setValue(T value){
			this.value = value;
			this.state = COMPLETED;
			//下面这句代码本质就是调用了this.callback.onComplete方法。但是注意AsyncCallback是个接口。
			//如果Optional实例有值，调用ifPresent()可以接受接口段或lambda表达式。
			this.callback.ifPresent(ac -> ac.onComplete(value,Optional.<Exception>empty()));
			synchronized (lock) {
				lock.notifyAll();
			}
		}
		/**
	     * Sets the exception from failed execution and executes callback if available. Notifies any thread waiting for
	     * completion.
	     * 如果执行失败了，就设置异常，然后执行回调函数，并通知别的等待该任务完成的线程。
	     * @param exception
	     *          exception of the failed task
	     */
		 void setException(Exception exception) {
			this.exception = exception;
			this.state = FAILED;
			//参考：http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
			this.callback.ifPresent(ac -> ac.onComplete(value,Optional.<Exception>empty()));
			synchronized (lock) {
				lock.notifyAll();
			}
		}
		@Override
		public boolean isCompleted() {
			// TODO Auto-generated method stub
			return state  > RUNNING;
		}

		@Override
		public T getValue() throws ExecutionException {
			// TODO Auto-generated method stub
			if(state == COMPLETED){
				return value;
			}else if( state == FAILED){
				throw new ExecutionException(exception);
			}else{
				throw new IllegalStateException("Execution not completed yet");
			}
		}
		/**
		 * 主要是主进程会调用这个方法，然后获得对lock锁进行等待。
		 * @throws InterruptedException
		 */
		@Override
		public void await() throws InterruptedException {
			// TODO Auto-generated method stub
			synchronized (lock) {
				if(!isCompleted()){
					lock.wait();
				}
			}
		}
		
	}
	

}
