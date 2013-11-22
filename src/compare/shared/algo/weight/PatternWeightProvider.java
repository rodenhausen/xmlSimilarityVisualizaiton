package compare.shared.algo.weight;

import java.util.HashMap;

import compare.shared.model.AttributeNode;
import compare.shared.model.ElementNode;
import compare.shared.model.Node;
import compare.shared.model.TextNode;

public class PatternWeightProvider implements IWeightProvider {

	private HashMap<String, Double> elementWeights;
	private HashMap<String, Double> attributeWeights;
	private HashMap<String, Double> textWeights;
	
	public PatternWeightProvider(HashMap<String, Double> elementWeights, 
			HashMap<String, Double> attributeWeights, 
			HashMap<String, Double> textWeights) {
		this.elementWeights = elementWeights;
		this.attributeWeights = attributeWeights;
		this.textWeights = textWeights;
	}
	
	@Override
	public double getWeight(Node node) {
		if(node instanceof AttributeNode) 
			return getAttributeWeight((AttributeNode)node);
		if(node instanceof TextNode) 
			return getTextWeight((TextNode)node);
		if(node instanceof ElementNode) 
			return getElementWeight((ElementNode)node);
		return 0;
	}

	private double getAttributeWeight(AttributeNode node) {
		return this.attributeWeights.get(node.getName() + "=" + node.getValue());
	}

	private double getTextWeight(TextNode node) {
		return this.textWeights.get(node.getText());
	}

	private double getElementWeight(ElementNode node) {
		return this.elementWeights.get(node.getName());
	}

}
