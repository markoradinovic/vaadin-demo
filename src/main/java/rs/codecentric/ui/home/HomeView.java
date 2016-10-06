package rs.codecentric.ui.home;

import java.io.Serializable;
import java.util.List;

import rs.codecentric.ui.mvp.MvpView;

public interface HomeView extends MvpView {
	
	
	void initLayout();

	void displayFriends(List<String> readData);
	
	
	
	
	public interface EditFriendListener extends Serializable {
		public void editFriend(String friend);
	}

	void addEditFriendListener(EditFriendListener editFriendListener);

	void removeEditFriendListener(EditFriendListener editFriendListener);

}
