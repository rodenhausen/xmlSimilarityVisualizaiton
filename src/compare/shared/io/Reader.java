package compare.shared.io;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import compare.shared.model.AttributeNode;
import compare.shared.model.ElementNode;
import compare.shared.model.Node;
import compare.shared.model.TextNode;

import nu.xom.Builder;
import nu.xom.Document;

public class Reader {
	
	public ElementNode read(File file) throws Exception {
		Builder parser = new Builder();
		Document doc = parser.build(file);
		nu.xom.Element rootElement = doc.getRootElement();
		ElementNode element = new ElementNode(rootElement.getLocalName());
		this.fill(element, rootElement);
		return element;
	}

	private void fill(ElementNode destination, nu.xom.Element source) {
		List<Node> childElements = new LinkedList<Node>();
		
		for(int i=0; i<source.getAttributeCount(); i++) {
			nu.xom.Attribute sourceAttribute = source.getAttribute(i);
			AttributeNode childElement = new AttributeNode(sourceAttribute.getLocalName(), 
					sourceAttribute.getValue());
			childElements.add(childElement);
		}
		for(int i=0; i<source.getChildCount(); i++) {
			nu.xom.Node sourceNode = source.getChild(i);
			if(sourceNode instanceof nu.xom.Text) {
				nu.xom.Text sourceText = (nu.xom.Text)sourceNode;
				if(!sourceText.getValue().trim().isEmpty()) {
					TextNode childElement = new TextNode(sourceText.getValue());
					childElements.add(childElement);
				}
			}
			if(sourceNode instanceof nu.xom.Element) {
				nu.xom.Element sourceElement = (nu.xom.Element)sourceNode;
				ElementNode childElement = new ElementNode(sourceElement.getLocalName());
				this.fill(childElement, sourceElement);
				childElements.add(childElement);
			}
		}
		destination.setChildElements(childElements);
	}

}

