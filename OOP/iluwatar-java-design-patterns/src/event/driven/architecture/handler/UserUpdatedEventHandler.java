package event.driven.architecture.handler;

import event.driven.architecture.event.UserUpdatedEvent;
import event.driven.architecture.framework.Handler;
/**
 * 处理UserUpdatedEvent消息
 */
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {


	@Override
	public void onEvent(UserUpdatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getUser().getUsername()+"-用户被更新了...");
	}

}
