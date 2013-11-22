package compare.shared.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import compare.shared.algo.IComparable;
import compare.shared.algo.weight.IWeightProvider;

public class Node implements IComparable<Node> {

	private static int currentId = 0;
	
	protected int id;
	
	//child elements are xml elements or xml attributes!
	private List<Node> childElements = new LinkedList<Node>();
	
	public Node() {
		this.id = currentId++;
	}
	
	public Node(List<Node> childElements) {
		this.id = currentId++;
		this.childElements = childElements;
	}

	public List<Node> getChildElements() {
		return childElements;
	}

	public void setChildElements(List<Node> childElements) {
		this.childElements = childElements;
	}

	@Override
	public double compare(Node b, IWeightProvider weightProvider) {
		return this.compare(b, weightProvider, new HashMap<Node, Node>());
	}

	@Override
	public double compare(Node b, IWeightProvider weightProvider, Map<Node, Node> predefinedPairs) {
		double result = 0;
		double sumWeights = 0;
		
		Set<Node> bChildrenMissingPartner = new HashSet<Node>(b.childElements);

		//what if maxChildB still null because all compared to elements returned score 0;
		//doesn't matter which one would have been chosen, 0 would have been added making it correct
		for(Node child : this.childElements) {
			double maxScore = 0;
			Node maxChildB = null;
			
			if(predefinedPairs.containsKey(child)) {
				maxChildB = predefinedPairs.get(child);
				maxScore = child.compare(maxChildB, weightProvider, predefinedPairs);
			} else {
				for(Node childB : b.childElements) {
					//what if two child want the same maxChildB? first come first serve for now		
					if(bChildrenMissingPartner.contains(childB)) {
						double score = child.compare(childB, weightProvider, predefinedPairs);
						if(score > maxScore) {
							maxScore = score;
							maxChildB = childB;
						}
					}
				}
			}
			
			//find a partner for child of a
			if(maxChildB != null) {
				//remove from b's children who are missing a partner;
				bChildrenMissingPartner.remove(maxChildB);
				
				double weightA = weightProvider.getWeight(child);
				double weightB = weightProvider.getWeight(maxChildB);
				result += (weightA + weightB) * maxScore;
				sumWeights += weightA + weightB;
			//if not, keep sumWeights up to date
			} else {
				double weight = weightProvider.getWeight(child);
				sumWeights += weight;
			}
		}
		
		for(Node childB : bChildrenMissingPartner) {
			double weight = weightProvider.getWeight(childB);
			sumWeights += weight;
		}
		
		return result / sumWeights;
	}
	
	public int getId() {
		return id;
	}

}
