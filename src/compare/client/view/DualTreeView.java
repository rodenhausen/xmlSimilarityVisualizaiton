package compare.client.view;

import com.google.gwt.user.client.ui.Widget;

import compare.client.view.TreeView.Presenter;

public interface DualTreeView {
	public interface Presenter {

		void onValueChangeA(Boolean selected);

		void onValueChangeB(Boolean selected);

	}

	void setPresenter(Presenter presenter);
	Widget asWidget();
	TreeView getTreeView();
}
