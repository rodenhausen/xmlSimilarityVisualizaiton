package compare.client;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import compare.client.presenter.DualTreePresenter;
import compare.client.view.DualTreeViewImpl;
import compare.shared.model.AttributeNode;
import compare.shared.model.ElementNode;
import compare.shared.model.Node;

public class XmlSimilarityVisualization implements EntryPoint {


	//private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	public void onModuleLoad() {
	    
	    AttributeNode a1 = new AttributeNode("name1", "value1");
	    AttributeNode a2 = new AttributeNode("name2", "value2");
		List<Node> caChildren = new LinkedList<Node>();
		caChildren.add(a1);
		caChildren.add(a2);
		AttributeNode b1 = new AttributeNode("name3", "value3");
		List<Node> cbChildren = new LinkedList<Node>();
		cbChildren.add(b1);
		
		ElementNode characterA = new ElementNode("ca", caChildren);
		ElementNode characterB = new ElementNode("cb", cbChildren);
		
		List<Node> strAChildren = new LinkedList<Node>();
		strAChildren.add(characterB);
		strAChildren.add(characterA);
		
		ElementNode strA = new ElementNode("strA", strAChildren);
		
		AttributeNode a3 = new AttributeNode("name4", "value4");
		AttributeNode a4 = new AttributeNode("name5", "value5");
		List<Node> ca2Children = new LinkedList<Node>();
		ca2Children.add(a3);
		ca2Children.add(a4);
		AttributeNode b2 = new AttributeNode("name3", "value3");
		List<Node> cb2Children = new LinkedList<Node>();
		cb2Children.add(b2);
		
		ElementNode characterA2 = new ElementNode("ca2", ca2Children);
		ElementNode characterB2 = new ElementNode("cb2", cb2Children);
		
		List<Node> strBChildren = new LinkedList<Node>();
		strBChildren.add(characterA2);
		strBChildren.add(characterB2);
		
		ElementNode strB = new ElementNode("strB", strBChildren);


		DualTreeViewImpl view = new DualTreeViewImpl();
		DualTreePresenter treePresenter = new DualTreePresenter(view, strA, strB);
	
	    RootPanel.get().add(view);
	}
}
