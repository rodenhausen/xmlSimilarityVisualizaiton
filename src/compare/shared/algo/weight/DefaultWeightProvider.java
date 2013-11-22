package compare.shared.algo.weight;

import compare.shared.model.Node;

public class DefaultWeightProvider implements IWeightProvider {
	
	@Override
	public double getWeight(Node element) {
		return 1.0;
	}
	
}
