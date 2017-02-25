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
package event.driven.architecture;
import event.driven.architecture.event.UserCreatedEvent;
import event.driven.architecture.event.UserUpdatedEvent;
import event.driven.architecture.framework.*;
import event.driven.architecture.handler.UserCreatedEventHandler;
import event.driven.architecture.handler.UserUpdatedEventHandler;
import event.driven.architecture.model.User;
/**
 * An event-driven architecture (EDA) is a framework that orchestrates behavior around the
 * production, detection and consumption of events as well as the responses they evoke. An event is
 * any identifiable occurrence that has significance for system hardware or software. <p/> The
 * example below uses an {@link EventDispatcher} to link/register {@link Event} objects to their
 * respective handlers once an {@link Event} is dispatched, it's respective handler is invoked and
 * the {@link Event} is handled accordingly.
 * <p>
 * 事件驱动架构是指精心策划：事件的发生、检测、消费和事件引发的反应。
 * 事件可以认为是任何一种可辨认的发生的事件，并且对系统的软硬件有着影响。
 * <p>
 * 这个例子中使用EventDispatcher来链接/注册 Event对象和与之对应的处理者（handler）。
 * 一旦事件被产生后，会由EventDispatcher的dispatcher方法调用消息的处理者，这样对应的处理者会被激发，进而事件就会被处理掉了。
 * 
 * 写完代码感觉和观察者模式好像哦，但是注意这个是架构，不是设计模式。
 */
public class App {
	/**
	   * Once the {@link EventDispatcher} is initialised, handlers related to specific events have to be
	   * made known to the dispatcher by registering them. In this case the {@link UserCreatedEvent} is
	   * bound to the UserCreatedEventHandler, whilst the {@link UserUpdatedEvent} is bound to the
	   * {@link UserUpdatedEventHandler}. The dispatcher can now be called to dispatch specific events.
	   * When a user is saved, the {@link UserCreatedEvent} can be dispatched.
	   * On the other hand, when a user is updated, {@link UserUpdatedEvent} can be dispatched.
	   *
	   * <p>
	   * 当EventDispatcher初始化后，与特殊事件相关的处理者（handler）必须向EventDispatcher注册。
	   * 本例中
	   * <p>
	   * UserCreatedEvent 与 UserCreatedEventHandler处理者绑定
	   * <p>
	   * UserUpdatedEvent 与 UserUpdatedEventHandler处理者绑定
	   * <p>
	   * 事件发送者(dispatcher)可以被请求发送不同的事件。比如存储了一个用户，那么可以发送UserCreatedEvent事件。又比如用户信息被更新了，那么可以发送UserUpdatedEvent事件。
	   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventDispatcher dispatcher = new EventDispatcher();
		dispatcher.registerHandler(UserCreatedEvent.class,new UserCreatedEventHandler());
		dispatcher.registerHandler(UserUpdatedEvent.class,new UserUpdatedEventHandler());
		
		User user = new User("zhangyang27");
		dispatcher.dispatch(new UserCreatedEvent(user));
		dispatcher.dispatch(new UserUpdatedEvent(user));
		
	}

}
