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
package callback;

/**
*
* Callback pattern is more native for functional languages where functions are treated as
* first-class citizens. Prior to Java 8 callbacks can be simulated using simple (alike command)
* interfaces.
* 回调模式在函数式编程语言中是原生存在的，函数式编程中函数被当做第一类公民。
* 在Java 8 之前回调可以使用简单（相似 命令）接口来完成。
* 
* 第一类公民：
* 是支持其他实体所有操作的实体，实体是指各种各样的数据类型和值，比如对象、类、函数、字面量
* 等这些实体所具有的操作有：
* 可以作为变量或者数据结构存储
* 可以作为参数传递给方法/函数
* 可以作为返回值从函数/方法返回
* 可以在运行期创建
* 
* 大部分语言的基本类型的数值(int, float)等都是第一类对象；
* 但是数组不一定，比如C中的数组，作为函数参数时，传递的是第一个元素的地址，同时还丢失了数组长度信息。
* 对于大多数的动态语言，函数/方法都是第一类对象，比如Python，
* 但是Ruby不是，因为不能返回一个方法。
* 第一类函数对函数式编程语言来说是必须的。
*/
public class App {
	public static void main(String[] args) {
		Task task = new SimpleTask();
		Callback callback = new Callback() {
			@Override
			public void call() {
				System.out.println("执行回调函数");
			}
		};
		task.executeWith(callback);
	}

}
