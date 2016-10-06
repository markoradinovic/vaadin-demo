package rs.codecentric.ui.edit;

import java.io.Serializable;
import java.lang.reflect.Method;

import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.util.ReflectTools;

@SuppressWarnings("serial")
public class EditForm extends FormLayout {
	
	/*
	 * DELETE ME
	 */
	FriendListener listener = new FriendListener() {
		
		@Override
		public void editFriend(FriendEvent event) {
			switch (event.getAction()) {
			case CREATE:
				
				break;

			default:
				break;
			}
			
		}
	};
	

	public enum FriendActions {
		CREATE, UPDATE, DELETE, SHOW, DISABLE;
	}

	public static class FriendEvent extends Component.Event {

		private final String friend;
		
		private final FriendActions action;

		public FriendEvent(Component source, String friend, FriendActions action) {
			super(source);
			this.friend = friend;
			this.action = action;
		}
		
		public FriendActions getAction() {
			return action;
		}

		public String getFriend() {
			return friend;
		}

	}

	public interface FriendListener extends Serializable {
		public static final Method METHOD = ReflectTools.findMethod(FriendListener.class, "editFriend",
				FriendEvent.class);

		public void editFriend(FriendEvent event);
	}

	public void addFriendListener(FriendListener listener) {
		addListener(FriendEvent.class, listener, FriendListener.METHOD);
	}

	public void removeFriendListener(FriendListener listener) {
		removeListener(FriendEvent.class, listener, FriendListener.METHOD);
	}

}
