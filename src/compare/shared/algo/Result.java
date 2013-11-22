package compare.shared.algo;

import java.util.Map;

import compare.shared.model.Node;

public class Result {

	//the compared elements
	private Node a;
	private Node b;
	
	//the comparison results of a and b's child elements, possibly all combinations
	private Map<Node, Map<Node, Result>> childElementResults;
	
	//the score of the comparison of a and b
	private double score;
	
	public Result(Node a, Node b, double score, Map<Node, Map<Node, Result>> childElementResults) {
		this.a = a;
		this.b = b;
		this.score = score;
		this.childElementResults = childElementResults;
	}

	public double getScore() {
		return score;
	}

	public Node getA() {
		return a;
	}

	public Node getB() {
		return b;
	}

	public Map<Node, Map<Node, Result>> getChildElementResults() {
		return childElementResults;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		//stringBuilder.append(a + "\n");
		//stringBuilder.append(b + "\n");
		stringBuilder.append("compare(" + a.getId() + ", " + b.getId() + ") = " + score + "\n");
		stringBuilder.append("childResults:\n");
		for(Node a : childElementResults.keySet()) {
			for(Node b : childElementResults.get(a).keySet()) {
				Result result = childElementResults.get(a).get(b);
				stringBuilder.append(result.toString());
			}
		}
		return stringBuilder.toString();
	}
}
