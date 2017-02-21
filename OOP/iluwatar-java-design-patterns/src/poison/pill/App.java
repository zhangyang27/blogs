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
package poison.pill;

import java.util.concurrent.ConcurrentHashMap;

/**
 * One of the possible approaches to terminate Producer-Consumer pattern is using the Poison Pill
 * idiom. If you use Poison Pill as the termination signal then Producer is responsible to notify
 * Consumer that the exchange is over and reject any further messages. The Consumer receiving Poison
 * Pill will stop reading messages from the queue. You must also ensure that the Poison Pill will be
 * the last message that will be read from the queue (if you have prioritized queue then this can be
 * tricky).
 * <p>
 * In simple cases the Poison Pill can be just a null-reference, but holding a unique separate
 * shared object-marker (with name "Poison" or "Poison Pill") is more clear and self describing.
 *  
 * --zhangyang27:翻译
 * 能够中止消费者和生产者模式的一种方式是使用毒药模式。
 * 如果你使用毒药作为中止信号，那么生产者就会负责通知消费者：交易结束，不要再接受任何新的消息。
 * 那么消费者收到毒药后就不再从读队列里的任何消息。
 * 所以你必须确保毒药是消费者从队列里读到的最后一条消息（如果使用了有优先级的队列，那么有时候很要达到这样的目的需要谨慎的设计）
 * 
 * 在最简单的情况下，毒药就是一个空引用，但是取一个独特的、通用的名字：Poison或者Poison Pill可以更清楚的表明意图。
 * --翻译结束
 */


public class App {
	public static void main(String[] args) {
		MessageQueue queue = new SimpleMessageQueue(10000);
   
		final Producer producer = new Producer("PRODUCER_1", queue);
		final Consumer consumer = new Consumer("CONSUMER_1",queue);
   
		new Thread(){
			public void run() {
				consumer.consume();
			};
		}.start();
		new Thread(){
			@Override
			public void run() {
				producer.send("hand shake");
				producer.send("some very important information");
				producer.send("bye!");
				producer.stop();
			}
		}.start();
	}
}
 