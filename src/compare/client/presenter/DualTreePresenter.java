package compare.client.presenter;

import compare.client.view.DualTreeView;
import compare.shared.model.Node;

public class DualTreePresenter implements DualTreeView.Presenter {

	private DualTreeView view;
	private TreePresenter treePresenter;
	private Node nodeB;
	private Node nodeA;

	public DualTreePresenter(DualTreeView view, Node nodeA, Node nodeB) {
		this.view = view;
		this.view.setPresenter(this);
		this.nodeA = nodeA;
		this.nodeB = nodeB;
		treePresenter = new TreePresenter(view.getTreeView());
		treePresenter.setData(nodeA);
	}
	
	public void setDataA(Node nodeA) {
		this.nodeA = nodeA;
	}
	
	public void setDataB(Node nodeB) {
		this.nodeB = nodeB;
	}

	@Override
	public void onValueChangeA(Boolean selected) {
		if(selected)
			treePresenter.setData(nodeA);
	}
	@Override
	public void onValueChangeB(Boolean selected) {
		if(selected)
			treePresenter.setData(nodeB);
	}
	
	
	
}
