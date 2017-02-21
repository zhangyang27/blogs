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

import java.util.Date;

import poison.pill.Message.Headers;

/**
 * Class responsible for producing unit of work that can be expressed as message and submitted to
 * queue
 * 负责生产工作单位，并以message表示，然后提交到队列中。
 */
public class Producer {
	/**
	 * 面向接口编程，这个queue就是消息将要被提交的queue
	 */
	private final MqPublishPoint queue;
	private final String name;
	private boolean isStopped;
	
	public Producer(String name,MqPublishPoint queue){
		this.name = name;
		this.queue = queue;
		this.isStopped = false;
	}
	/**
	 * 可以看到这个body是消息实体是外部传进来的
	 * send会负责打上一些标签
	 * @param body
	 */
	public void send(String body){
		if(isStopped){
			throw new IllegalStateException(String.format("生产者 %s 已经被中止了，所以不能再传递消息：[%s]", name,body));
		}
		//下面开始拼装消息
		Message msg = new SimpleMessage();
		msg.addHeader(Headers.DATE,new Date().toString());
		msg.addHeader(Headers.SENDER, name);
		msg.setBody(body);
		
		try{
			queue.put(msg);
		}catch(InterruptedException e){
			System.out.println("放消息进队列出错："+e);
		}
	}
	/**
	 * 通过发送毒药消息停止整个系统
	 */
	public void stop(){
		isStopped = true;
		try{
			queue.put(Message.POISON_PILL);
		}catch(InterruptedException e){
			System.out.println("放消息进队列出错："+e);
		}
	}
	
	
	
	
	
}
