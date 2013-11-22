package compare.shared.model;

import java.util.List;

public class ElementNode extends Node {

	private String name;
	
	public ElementNode(String name) {
		super();
		this.name = name;
		System.out.println("Element " + name + " " + id);
	}
	
	public ElementNode(String name, List<Node> childElements) {
		super(childElements);
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	
}
