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

import poison.pill.Message.Headers;

/**
 * 负责接收消息和处理消息的类
 */
public class Consumer {

	private final MqSubscribePoint queue;
	private final String name;
	
	public Consumer(String name, MessageQueue queue) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.queue = queue;
	}

	public void consume() {
		// TODO Auto-generated method stub
		while(true){
			Message msg = null;
			try{
				msg = queue.take();
				if(Message.POISON_PILL.equals(msg)){
					System.out.println("消费者:"+this.name+"收到毒药，马上自杀...");
					break;
				}
			}catch(InterruptedException e){
				System.out.println("消费者读取消息时出错...");
			}
			String sender = msg.getHeader(Headers.SENDER);
			String body = msg.getBody();
			System.out.println("消费者处理由"+sender+"发送过来的消息："+body);
		}
		
	}

}
