package compare.client.view;

import com.google.gwt.user.client.ui.Widget;
import compare.shared.model.Node;

public interface TreeView {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);
	Widget asWidget();
	void setData(Node node);
	
}
