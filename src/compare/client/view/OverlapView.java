package compare.client.view;

import com.google.gwt.user.client.ui.Widget;

import compare.client.view.TreeView.Presenter;
import compare.shared.algo.Result;

public interface OverlapView {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);
	Widget asWidget();
	void setData(Result result);
	
}
