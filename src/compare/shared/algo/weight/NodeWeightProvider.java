package compare.shared.algo.weight;

import java.util.HashMap;
import java.util.Map;

import compare.shared.model.Node;

/** 
 * Provides wieghts for all elements that appear in Elements a AND b that are 
 * to be compared
 * @author General
 *
 */
public class NodeWeightProvider implements IWeightProvider {

	//if element comparison based on hash is not sufficient, provider can implement something else
	//e.g. considering certain attributes only
	private Map<Node, Double> weights = new HashMap<Node, Double>();
	
	@Override
	public double getWeight(Node element) {
		return weights.get(element);
	}
	
}
