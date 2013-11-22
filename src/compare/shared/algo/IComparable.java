package compare.shared.algo;

import java.util.Map;

import compare.shared.algo.weight.IWeightProvider;
import compare.shared.model.Node;

public interface IComparable<T extends Node> {

	public double compare(T b, IWeightProvider weightProvider);
	
	public double compare(T b, IWeightProvider weightProvider, Map<Node, Node> predefinedPairs);
	
}
