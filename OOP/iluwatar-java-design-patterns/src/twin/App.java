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
 * Twin pattern is a design pattern which provides a standard solution to simulate multiple
 * inheritance in java.
 * <p>
 * In this example, the essence of the Twin pattern is the {@link BallItem} class and
 * {@link BallThread} class represent the twin objects to coordinate with each other(via the twin
 * reference) like a single class inheriting from {@link GameItem} and {@link Thread}.
 * 
 * zhangyang27的翻译：
 * 双胞胎模式为java提供了标准的多重继承的解决方案。
 * 
 * 在本例中，使用了双胞胎模式的是BallItem类和BallThread类，
 * 它们代表一对双胞胎相互协作（通过相互引用对方）模拟得像一个同时继承了GameItem和Thread的类。
 * 
 * 这个例子还有一个特殊之处在于，实际情况中不需要继承Thread类，而是实现Runnable接口，一样能到效果。
 */

public class App {

	public static void main(String[] args) throws Exception {
		BallItem ballItem = new BallItem();
		BallThread ballThread = new BallThread();
		
		ballItem.setTwin(ballThread);
		ballThread.setTwin(ballItem);
		
		//既然要委派，为什么不委派的彻底一点呢？在ballItem里有一个调用ballThread的方法，这样就更像一个类又继承了Thread啊
		//难道是为了区分UI启动和逻辑处理？
		//ballThread.start();
		ballItem.start();
		
		waiting();
		
		ballItem.click();
		
		waiting();
		
		ballItem.click();
		
		waiting();
		
		//退出，这里执行stopMe之后小球就消失了。
		ballThread.stopMe();
		
	}
	//这个方法只是让主线程暂停一会。
	private static void waiting() throws Exception{
		Thread.sleep(750);
	}
}
