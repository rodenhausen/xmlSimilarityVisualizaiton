package compare.shared.algo;

import java.util.HashMap;
import java.util.Map;

import compare.shared.algo.weight.IWeightProvider;
import compare.shared.model.Node;

public class ExhaustiveComparer {

	public Result compare(Node a, Node b, IWeightProvider weightProvider) {		
		//compare all possible child element pairs
		Map<Node, Map<Node, Result>> childElementResults = new HashMap<Node, 
				Map<Node, Result>>();
		for(Node childA : a.getChildElements()) {
			for(Node childB : b.getChildElements()) {
				//compare
				Result result = this.compare(childA, childB, weightProvider);
				
				//store result
				if(!childElementResults.containsKey(childA))
					childElementResults.put(childA, new HashMap<Node, Result>());
				childElementResults.get(childA).put(childB, result);
			}
		}
		
		//compute comparison score
		double score = a.compare(b, weightProvider);
		
		return new Result(a, b, score, childElementResults);
	}
	
}
