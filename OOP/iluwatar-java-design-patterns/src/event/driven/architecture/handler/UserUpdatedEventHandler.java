package event.driven.architecture.handler;

import event.driven.architecture.event.UserUpdatedEvent;
import event.driven.architecture.framework.Handler;
/**
 * ����UserUpdatedEvent��Ϣ
 */
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {


	@Override
	public void onEvent(UserUpdatedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.getUser().getUsername()+"-�û���������...");
	}

}
