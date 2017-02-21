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

import java.util.Map;

/**
 * Interface that implements the Message pattern and represents an inbound or outbound message as
 * part of an {@link Producer}-{@link Consumer} exchange.
 * 
 * 这个接口实现了消息，代表了生产者生产的消息或者消费者收到的消息，作为消费者和生产者模型的一部分。
 * 
 */
public interface Message {
	/**
	 * 创建了毒药消息
	 * 可以看到毒药消息不要头或者身体，也不需要查看消息头和身体，如果调用了这些方法直接抛出出错；
	 */
	Message POISON_PILL = new Message() {
		
		@Override
		public void setBody(String body) {
			// TODO Auto-generated method stub
			throw poison();
		}
		
		@Override
		public Map<Headers, String> getHeaders() {
			// TODO Auto-generated method stub
			throw poison();
		}
		
		@Override
		public String getHeader(Headers header) {
			// TODO Auto-generated method stub
			throw poison();
		}
		
		@Override
		public String getBody() {
			// TODO Auto-generated method stub
			throw poison();
		}
		
		@Override
		public void addHeader(Headers header, String value) {
			throw poison();
			
		}
		
		private RuntimeException poison(){
			return new UnsupportedOperationException("Poison");
		}
	};
	
	/**
	 * 每个消息都要有消息头，消息头只有两种，所以使用了枚举
	 * @author zhangyang27
	 *
	 */
	public enum Headers{
		DATE,SENDER
	}
	/**
	 * 添加设置消息头的具体内容
	 * @param header
	 * @param value
	 */
	void addHeader(Headers header,String value);
	
	/**
	 * 获得消息头
	 * @param header
	 * @return
	 */
	String getHeader(Headers header);
	
	Map<Headers,String> getHeaders();
	
	/**
	 * 设置这个消息的消息体
	 * @param body
	 */
	void setBody(String body);

	String getBody();
}