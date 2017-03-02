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

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import javax.swing.UIDefaults.LazyValue;

/**
 * This application demonstrates the async method invocation pattern. Key parts of the pattern are
 * <code>AsyncResult</code> which is an intermediate container for an asynchronously evaluated value,
 * <code>AsyncCallback</code> which can be provided to be executed on task completion and <code>AsyncExecutor</code>
 * that manages the execution of the async tasks.
 * <p>
 * The main method shows example flow of async invocations. The main thread starts multiple tasks with variable
 * durations and then continues its own work. When the main thread has done it's job it collects the results of the
 * async tasks. Two of the tasks are handled with callbacks, meaning the callbacks are executed immediately when the
 * tasks complete.
 * <p>
 * Noteworthy difference of thread usage between the async results and callbacks is that the async results are collected
 * in the main thread but the callbacks are executed within the worker threads. This should be noted when working with
 * thread pools.
 * <p>
 * Java provides its own implementations of async method invocation pattern. FutureTask, CompletableFuture and
 * ExecutorService are the real world implementations of this pattern. But due to the nature of parallel programming,
 * the implementations are not trivial. This example does not take all possible scenarios into account but rather
 * provides a simple version that helps to understand the pattern.
 * <p>
 * 本例子示例异步方法调用模式。其中关键的部分有三部分：
 * AsyncResult是存放异步任务的结果集的容器；
 * AsyncCallback是异步任务执行结束后执行函数（回调函数）
 * AsyncExecutor管理者异步任务的执行。
 * <p>
 * main方法展示了一系列异步任务的调用（激活）。main方法开启了多个异步任务，并为每个异步任务设置了不同的执行时长，然后继续自己的工作。
 * main进程完成自己的工作后，开始搜集异步任务的结果。
 * 其中有两个任务使用了回调函数，回调函数是指当异步任务执行完成后会立刻执行的函数。
 * <p>
 * 有一个关于线程的执行的重要区别是，收集异步任务结果的线程是main线程。而执行回调函数的线程是worker进程。当使用线程池时需要注意这一点。
 * <p>
 * Java内部提供了异步方法调用的实现：FutureTask, CompletableFuture and ExecutorService。但由于并发编程的本质，实现的难度不小。
 * 本例子没有将所有的情况都考虑到，只是提供了一个能够理解该模式的简单版本。
 *
 *
 * @see AsyncResult
 * @see AsyncCallback
 * @see AsyncExecutor
 *
 * @see java.util.concurrent.FutureTask
 * @see java.util.concurrent.CompletableFuture
 * @see java.util.concurrent.ExecutorService
 */
public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		 // construct a new executor that will run async tasks
		AsyncExecutor executor = new ThreadAsyncExecutor();
		
		//开启一系列异步任务，并且执行时间不一样，后面两个都具有回调函数。
		AsyncResult<Integer> asyncResult1 = executor.startProcess(lazyval(10,500));
		AsyncResult<String> asyncResult2 = executor.startProcess(lazyval("test",500));
		AsyncResult<Long> asyncResult3 = executor.startProcess(lazyval(50L,700));
		AsyncResult<Integer> asyncResult4 = executor.startProcess(lazyval(20,400),callback("Callback result 4"));
		AsyncResult<String> asyncResult5 = executor.startProcess(lazyval("call back",600),callback("Callback result 5"));
		
		//假设主线程在进行自己的事，而异步任务都在异步执行。
		Thread.sleep(350);
		System.out.println("主线程进程自己的活动...");
		
		Integer result1 = executor.endProcess(asyncResult1);
		String result2 = executor.endProcess(asyncResult2);
		Long result3 = executor.endProcess(asyncResult3);
		asyncResult4.await();
		asyncResult5.await();
		
		System.out.println("Result 1:"+result1);
		System.out.println("Result 2:"+result2);
		System.out.println("Result 3:"+result3);
	}	
	  
	/**
	   * Creates a callable that lazily evaluates to given value with artificial delay.
	   * 
	   * 创建一个需要被异步执行的任务，它执行的过程是:先人工延迟、再返回接受的值。
	   * @param value
	   *          value to evaluate
	   * @param delayMillis
	   *          artificial delay in milliseconds
	   * @return new callable for lazy evaluation
	   */
	private static <T> Callable<T> lazyval(T value,long delayMillis){
		return () -> {
			Thread.sleep(delayMillis);
			System.out.println("Task completed with: "+value);
			return value;
		};
	}
	/**
	   * Creates a simple callback that logs the complete status of the async result.
	   * 创建一个回调函数。它会打印异步任务的返回结果，代表着它会可以拿到异步任务的结果做另外的处理。
	   * @param name
	   *          callback name
	   * @return new async callback
	   * 返回一个call back的接口
	   */
	private static <T> AsyncCallback<T> callback(String name){
		//好像是返回一个匿名函数
		return (value,ex) -> {
			if(ex.isPresent()){
				System.out.println(name + "failed:"+ex.map(Exception::getMessage).orElse(""));
			}else{
				System.out.println("回调函数"+name+":"+value);
			}
		
		};
	}
}