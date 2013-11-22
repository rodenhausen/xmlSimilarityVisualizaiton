package compare.client.presenter;

import compare.client.view.TreeView;
import compare.shared.model.Node;

public class TreePresenter implements TreeView.Presenter {

	private TreeView view;

	public TreePresenter(TreeView view) {
		this.view = view;
		view.setPresenter(this);
	}
	
	public void setData(Node node) {
		view.setData(node);
	}
	
}
