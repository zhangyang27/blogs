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
 * Lazy loading idiom defers object creation until needed.
 * <p>
 * This example shows different implementations of the pattern with increasing sophistication.
 * <p>
 * Additional information and lazy loading flavours are described in
 * http://martinfowler.com/eaaCatalog/lazyLoad.html
 * <p>
 * 延迟加载推迟对象的初始化直到对象需要被用到时。
 * <p>
 * 本例有展示了几种该模式的实现方案，难度逐渐增加。
 * <p>
 * 额外知识请参考：http://martinfowler.com/eaaCatalog/lazyLoad.html
 */
public class App {
	public static void main(String[] args) {
		//最简单的方案，线程并不安全
		HolderNaive holderNaive = new HolderNaive();
		Heavy heavy = holderNaive.getHeavy();
		
		//线程安全了，但是负担也比好大
		HolderThreadSafe holderThreadSafe = new HolderThreadSafe();
		Heavy another = holderThreadSafe.getHeavy();
		
		//Java8新特性
		Java8Holder java8Holder = new Java8Holder();
		Heavy next = java8Holder.getHeavy();
		next = java8Holder.getHeavy();
	}
}
