package event.driven.architecture.handler;

import event.driven.architecture.event.UserCreatedEvent;
import event.driven.architecture.framework.Handler;
/**
 * ����UserCreatedEvent��Ϣ
 */
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

	@Override
	public void onEvent(UserCreatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getUser().getUsername()+"-�û���������...");
	}

}
