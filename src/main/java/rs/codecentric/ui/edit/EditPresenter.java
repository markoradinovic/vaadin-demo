package rs.codecentric.ui.edit;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;

import rs.codecentric.ui.mvp.MvpPresenter;

@SuppressWarnings("serial")
@SpringView(name = "edit")
public class EditPresenter extends MvpPresenter<EditView> {

	@Autowired
	public EditPresenter(EditView view) {
		super(view);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
