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
package event.driven.architecture.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles the routing of {@link Event} messages to associated handlers.
 * A {@link HashMap} is used to store the association between events and their respective handlers.
 * <p>
 * 将事件发送给响应的处理者，使用了一个HashMap来存储事件和与之对应的处理者。
 */
public class EventDispatcher {
	private Map<Class<? extends Event>,Handler<? extends Event>> handlers;
	public EventDispatcher(){
		handlers = new HashMap<>();
	}
	  /**
	   * Links an {@link Event} to a specific {@link Handler}.
	   *
	   * @param eventType The {@link Event} to be registered
	   * @param handler   The {@link Handler} that will be handling the {@link Event}
	   */
	public <E extends Event> void registerHandler(Class<E> eventType,Handler<E> handler){
		//上一句代码的第一个参数，应该是表示只接受Event类的Class对象，Class类是一个比较特别的类。
		// <E extends Event>  感觉像是一个缩写
		handlers.put(eventType,handler);
	}
	  /**
	   * Dispatches an {@link Event} depending on it's type.
	   *
	   * @param event The {@link Event} to be dispatched
	   */
	  @SuppressWarnings("unchecked")
	public <E extends Event> void dispatch(E event){
		Handler<E> handler = (Handler<E>)handlers.get(event.getClass());
		if(handler != null){
			handler.onEvent(event);
		}
	}
}
