package compare.shared.model;

import java.util.LinkedList;
import java.util.Map;

import compare.shared.algo.weight.IWeightProvider;

//the text of an xml rather than child elements (e.g. text description)
public class TextNode extends Node {

	private String text;
	
	public TextNode(String text) {
		super(new LinkedList<Node>());
		this.text = text;
		if(text.length() > 30)
			System.out.println("Text " + text.substring(0, 30) + " " + id);
		else
			System.out.println("Text " + text + " " + id);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public double compare(Node b, IWeightProvider weightProvider) {
		if(b instanceof TextNode) {
			TextNode bTextElement = (TextNode)b;
			if(this.text.equals(bTextElement.text))
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
