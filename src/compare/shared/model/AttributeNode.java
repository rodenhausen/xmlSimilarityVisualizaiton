package compare.shared.model;

import java.util.LinkedList;
import java.util.Map;

import compare.shared.algo.weight.IWeightProvider;

public class AttributeNode extends Node {

	private String name;
	private String value;
	
	public AttributeNode(String name, String value) {
		//attributes don't have children
		super(new LinkedList<Node>());
		this.name = name;
		this.value = value;
		System.out.println("Attribute " + name + "=" + value + " " + id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public double compare(Node b, IWeightProvider weightProvider) {
		if(b instanceof AttributeNode) {
			AttributeNode bAttributeElement = (AttributeNode)b;
			if(this.name.equals(bAttributeElement.name) && 
					this.value.equals(bAttributeElement.value))
				return 1.0;
		}
		return 0;
	}	
	
	@Override
	public double compare(Node b, IWeightProvider weightProvider,
			Map<Node, Node> predefinedPairs) {
		return compare(b, weightProvider);
	}
}
