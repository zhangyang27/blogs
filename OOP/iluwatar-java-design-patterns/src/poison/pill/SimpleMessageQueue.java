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


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Bounded blocking queue wrapper
 * 我的理解就是一个真正的Queue的实现类，
 * 并且这个Queue是阻塞的，
 * 所谓阻塞的请读读BlockingQueue的第一句：取消息的会阻塞，等到有消息才返回；存消息的时候如果没空位会阻塞，直到消息被放进去。
 * 
 */
public class SimpleMessageQueue implements MessageQueue {

	private final BlockingQueue<Message> queue;
	
	public SimpleMessageQueue(int capacity) {
		// TODO Auto-generated constructor stub
		queue = new ArrayBlockingQueue<Message>(capacity); //原文叫bound,叫capacity多清晰。
	}
	
	@Override
	public void put(Message msg) throws InterruptedException {
		// TODO Auto-generated method stub
		queue.put(msg);
	}

	@Override
	public Message take() throws InterruptedException {
		// TODO Auto-generated method stub
		return queue.take();
	}

}
