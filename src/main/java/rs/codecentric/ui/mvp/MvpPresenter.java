package rs.codecentric.ui.mvp;

import com.vaadin.navigator.View;

@SuppressWarnings("serial")
public abstract class MvpPresenter<T extends MvpView> implements View {
	
	final T view;
	
	public MvpPresenter(final T view) {
		this.view = view;
	}
	
	public T getView() {
		return view;
	}

}
