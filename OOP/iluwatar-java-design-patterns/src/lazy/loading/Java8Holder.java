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

import java.util.function.Supplier;

/**
 * This lazy loader is thread safe and more efficient than {@link HolderThreadSafe}. It utilizes
 * Java 8 functional interface {@link Supplier} as {@link Heavy} factory.
 * 这个延迟加载是线程安全的，并且比HolderThreadSafe更加高效，这因为它整合了java 8 的函数式接口作为Heavy的创建工厂。
 *
 */
public class Java8Holder {
	/**
	 * 查阅了一下，下句代码段后半段应该只有在需要真正需要heavy的时候才会执行
	 * 并且会自动缓存第一次执行后生成的heavy
	 * 我自己可以试一下。
	 * 看一下执行顺序：
	 * 
Java8Holder被创建了...
调用了getHeavy之前...
createAndCacheHeavy被调用了
heavy开始创建...
heavy创建完毕...
HeavyFactory被创建了...
马上返回HeavyFactory创建的heavyInstance...
调用了getHeavy之后...
调用了getHeavy之前...
马上返回HeavyFactory创建的heavyInstance...
调用了getHeavy之后...

	 * 可以看到createAndCacheHeavy并不是在Java8Holder被创建时就执行了，
	 * 而是在调用getHeavy的时候才会执行创建heavy，然后还缓存了创建的对象
	 * 
	 * 而且也可以看到第二次调用getHeavy的时候没有调用createAndCacheHeavy。
	 *
	 */
	private Supplier<Heavy> heavy = ()->createAndCacheHeavy();

	public Java8Holder() {
		System.out.println("Java8Holder被创建了...");
	}
	public Heavy getHeavy(){
		System.out.println("调用了getHeavy之前...");
		Heavy tmp =  heavy.get();
		System.out.println("调用了getHeavy之后...");
		return tmp;
	}
	private synchronized Heavy createAndCacheHeavy() {
		System.out.println("createAndCacheHeavy被调用了");
		// TODO Auto-generated method stub
		class HeavyFactory implements Supplier<Heavy>{
			private final Heavy heavyInstance = new Heavy();
			public HeavyFactory() {
				System.out.println("HeavyFactory被创建了...");
			}
			@Override
			public Heavy get() {
				// TODO Auto-generated method stub
				System.out.println("马上返回HeavyFactory创建的heavyInstance...");
				return heavyInstance;
			}
		}
		if(!HeavyFactory.class.isInstance(heavy)){
			heavy = new HeavyFactory();
		}
		return heavy.get();
	}
}
