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
 * Simple implementation of the lazy loading idiom. However, this is not thread safe.
 * 延迟加载的简单实现，但线程不安全。
 */

public class HolderNaive {

	private Heavy heavy;
	/**
	 * 可以看到这个HolderNaive并非单例，
	 * 那是否是单例首先需要考虑的是业务上是否需要单例
	 * 如果就是需要不同的几个对象，那么就需要创建几个holder。
	 */
	public HolderNaive() {
		// TODO Auto-generated constructor stub
		System.out.println("HolderNaive创建完毕...");
	}
	public Heavy getHeavy(){
		if(this.heavy == null){
			this.heavy = new Heavy();
		}
		return this.heavy;
	}
}
