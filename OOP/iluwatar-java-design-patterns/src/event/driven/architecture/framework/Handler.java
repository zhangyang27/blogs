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

/**
 * This interface can be implemented to handle different types of messages.
 * Every handler is responsible for a single of type message
 * <p>
 * 这个接口可以被用于实现处理不同类的事件，
 * 每一个处理者都对应一种类型的事件消息
 */
public interface Handler<E extends Event> {

  /**
   * The onEvent method should implement and handle behavior related to the event.
   * This can be as simple as calling another service to handle the event on publishing the event on
   * a queue to be consumed by other sub systems.
   * @param event the {@link Event} object to be handled.
   * 
   * <p>
   * 这个onEvent方法需要被实现为处理事件的行为，
   * 也可以简单将事件塞进一个队列里，等待被别的子系统处理，这就相当于调用另一个服务来处理这个事件，
   */
  void onEvent(E event);
}