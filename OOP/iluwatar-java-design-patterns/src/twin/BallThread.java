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

package twin;
/**
 * This class is a UI thread for drawing the {@link BallItem}, and provide the method for suspend
 * and resume. It hold the reference of {@link BallItem} to delegate the draw task.
 * 
 * 这个类是为了画出球的UI线程，并且提供了suspend和resume方法。
 * 它保持一个BallItem的引用，为了委派画的任务。
 * 
 */

public class BallThread extends Thread{
	private BallItem twin;
	private volatile boolean isSuspended;
	private volatile boolean isRunning = true;
	
	public void setTwin(BallItem twin){
		this.twin = twin;
	}
	
	/**
	 * 运行线程
	 */
	public void run(){
		while(isRunning){
			if(!isSuspended){
				twin.draw();
				twin.move();
			}
			try{
				Thread.sleep(250);
			} catch (InterruptedException e){
				throw new RuntimeException(e);
			}
		}
	}
	
	public void suspendMe(){
		isSuspended = true;
		System.out.println("暂停球，球不动了...");
	}
	public void resumeMe(){
		isSuspended = false;
		System.out.println("恢复球，球又动了...");
	}
	
	public void stopMe(){
		isRunning = false;
		System.out.println("不要球了...球彻底消失了...");
		isSuspended = true; //源码中有这句，但是感觉有点多余。
		
	}

}
