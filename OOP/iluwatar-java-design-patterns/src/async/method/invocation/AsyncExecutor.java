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


/**
 * 
 * 异步执行的接口
 *
 */
public interface AsyncExecutor {

	/**
	   * Starts processing of an async task. Returns immediately with async result.
	   * <p>
	   * 开始一个进程执行异步的任务，并且立刻返回异步结果。
	   * @param task task to be executed asynchronously（需要被异步执行的任务）
	   * @return async result for the task（这个异步执行任务的结果）
	   */
	<T> AsyncResult<T> startProcess(Callable<T> back);
	
	/**
	   * Starts processing of an async task. Returns immediately with async result. Executes callback
	   * when the task is completed.
	   * 完成异步任务后会立刻执行回调函数
	   * 
	   * @param task task to be executed asynchronously
	   * @param callback callback to be executed on task completion（任务完成后立刻执行回调函数）
	   * @return async result for the task
	   */
	
	//file:///Users/baidu/Downloads/tutorial/extra/generics/literals.html
	<T> AsyncResult<T> startProcess(Callable<T> back,AsyncCallback<T> callback);
	
	/**
	   * Ends processing of an async task. Blocks the current thread if necessary and returns the
	   * evaluated value of the completed task.
	   * <p>
	   * 结束执行异步任务的进程并视图获得结果。如果异步任务没有完成，则阻塞现有进程，等待返回任务完成的值。
	   * 
	   * @param asyncResult async result of a task
	   * @return evaluated value of the completed task
	   * @throws ExecutionException if execution has failed, containing the root cause
	   * @throws InterruptedException if the execution is interrupted
	   */
	
	<T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException,InterruptedException;
}
