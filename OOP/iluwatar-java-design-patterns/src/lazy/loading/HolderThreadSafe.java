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
package lazy.loading;

/**
 * 
 * Same as HolderNaive but with added synchronization. This implementation is thread safe, but each
 * {@link #getHeavy()} call costs additional synchronization overhead.
 * <p>
 * 与HolderNaive相同，只是增加了同步锁，这个实现是线程安全的。但是getHeavy()这个请求增加了同步锁的负担。
 * 
 *
 */
public class HolderThreadSafe {
	private Heavy heavy;
	public HolderThreadSafe() {
		System.out.println("HolderThreadSafe对象创建完毕...");
	}
	/**
	 * 表示调用这个方法需要先拿到同步锁，没加这个关键字的方法还是可以随便访问的。
	 */
	public synchronized Heavy getHeavy(){
		if(this.heavy == null){
			this.heavy = new Heavy();
		}
		return this.heavy;
	}
}
