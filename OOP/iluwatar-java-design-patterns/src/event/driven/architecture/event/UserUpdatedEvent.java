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
package event.driven.architecture.event;

import event.driven.architecture.model.*;


/**
 * The {@link UserUpdatedEvent} should should be dispatched whenever a user has been updated.
 * This class can be extended to contain details about the user has been updated. In this example,
 * the entire {@link User} object is passed on as data with the event.
 * <p>
 * 当对象更新时时这个事件应该被发送，这个类可以设计包含很多关于被创建的用户的细节。在本例中，整个user对象被作为一个数据随着这个事件被传送着。
 * 
 */
public class UserUpdatedEvent extends AbstractEvent {

  private User user;

  public UserUpdatedEvent(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}