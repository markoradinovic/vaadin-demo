package rs.codecentric.ui.home;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import rs.codecentric.service.DataService;

@SuppressWarnings("serial")
@SpringView(name="home")
public class HomeView extends CssLayout implements View {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DataService dataService;
	
	@PostConstruct
	public void postContruct() {
		LOG.info("Creating new MainView");
		setSizeFull();
	}

	@PreDestroy
	public void preDestroy() {
		LOG.info("Destroying MainView");
	}

	@Override
	public void enter(ViewChangeEvent event) {
		LOG.info("Entering View: " + event.getViewName());
		buildLayout();
	}
	
	private void buildLayout() {
		VerticalLayout layout = new VerticalLayout();
		layout.setWidth("100%");
		layout.setMargin(true);
		layout.setSpacing(true);
		addComponent(layout);
		
		Label caption = new Label(FontAwesome.HOME.getHtml() + " Welcome to my awesome App", ContentMode.HTML);
		caption.addStyleName(ValoTheme.LABEL_H1);
		layout.addComponent(caption);
		
		Label subCaption = new Label("These are my friends: ", ContentMode.HTML);
		subCaption.addStyleName(ValoTheme.LABEL_LIGHT);
		layout.addComponent(subCaption);
		
		dataService.readData().forEach( friend -> {
			final Button btnFriend = new Button(friend, event -> {
				Notification.show("Hello my friend: " + friend, Type.TRAY_NOTIFICATION);
			});
			layout.addComponent(btnFriend);
		});
	}
	

}
