package rs.codecentric.ui.edit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
@UIScope
@SpringView(name = "edit")
public class EditView extends CssLayout implements View {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@PostConstruct
	public void postContruct() {
		LOG.info("Creating new EditView");
		setSizeFull();
		addComponent(new Label("Edit View"));
	}

	@PreDestroy
	public void preDestroy() {
		LOG.info("Destroying EditView");
	}

	@Override
	public void enter(ViewChangeEvent event) {
		LOG.info("Entering View: " + event.getViewName());
	}

}
