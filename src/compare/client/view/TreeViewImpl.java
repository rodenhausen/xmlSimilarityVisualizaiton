package compare.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasTreeItems;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;

import compare.shared.model.AttributeNode;
import compare.shared.model.ElementNode;
import compare.shared.model.Node;
import compare.shared.model.TextNode;

public class TreeViewImpl extends Composite implements TreeView {

	private static TreeViewUiBinder uiBinder = GWT
			.create(TreeViewUiBinder.class);

	@UiTemplate("TreeView.ui.xml")
	interface TreeViewUiBinder extends UiBinder<Widget, TreeViewImpl> {
	}
	
	@UiField
	Tree tree;

	private Presenter presenter;

	public TreeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setData(Node node) {
		tree.clear();
		decorateTree(tree, node);
	}

	private void decorateTree(HasTreeItems hasTreeItems, Node node) {
		TreeItem treeItem = null;
		if(node instanceof ElementNode) {
			treeItem = new TreeItem(new Label("E: " + ((ElementNode) node).getName()));
		}
		if(node instanceof AttributeNode) {
			treeItem = new TreeItem(new Label("A: " + ((AttributeNode) node).getName() + " = " + 
								((AttributeNode)node).getValue()));
		}
		if(node instanceof TextNode) {
			treeItem = new TreeItem(new Label("T: " + ((TextNode) node).getText()));
		}
		
		if(treeItem != null) {
			hasTreeItems.addItem(treeItem);
			for(Node childNode : node.getChildElements()) {
				decorateTree(treeItem, childNode);
			}
		}
	}

}
