package rs.codecentric.ui.edit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

@SuppressWarnings("serial")
@ViewScope
@SpringComponent
public class EditViewImpl extends CssLayout implements EditView {

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

}
