package rs.codecentric.ui.home;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;

import rs.codecentric.service.FriendsService;
import rs.codecentric.ui.mvp.MvpPresenter;

@SuppressWarnings("serial")
@SpringView(name="home")
public class HomePresenter extends MvpPresenter<HomeView> {
	
	@Autowired
	private FriendsService friendsService;
	
	@Autowired
	public HomePresenter(HomeView view) {
		super(view);
	}
	
	@PostConstruct
	public void postContruct() {
		getView().addEditFriendListener(friend -> {
			friendsService.saveFriend(friend);
		});
	}

	@PreDestroy
	public void preDestroy() {
	}

	@Override
	public void enter(ViewChangeEvent event) {
		getView().initLayout();
		loadFriends();
	}
	
	private void loadFriends() {
		getView().displayFriends(friendsService.readFriends());
	}


}
