package rs.codecentric.ui.login;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringUI(path="login")
@Theme("valo")
public class LoginUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setContent(root);
		
		FormLayout loginForm = new FormLayout();
		loginForm.setWidth("400px");
		root.addComponent(loginForm);
		root.setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);
		
		TextField username = new TextField("Username");
		username.setInputPrompt("Enter your username");
		username.setImmediate(true);
		username.setRequired(true);
		loginForm.addComponent(username);
		
		PasswordField password = new PasswordField("Password");
		password.setImmediate(true);
		password.setRequired(true);
		loginForm.addComponent(password);
		
		Button login = new Button("Login", event -> {
			Page.getCurrent().setLocation("/main");
			UI.getCurrent().getSession().setAttribute("IS_LOGGED_IN", true);
		});
		login.setIcon(FontAwesome.SIGN_IN);
		loginForm.addComponent(login);
		
	}

}
