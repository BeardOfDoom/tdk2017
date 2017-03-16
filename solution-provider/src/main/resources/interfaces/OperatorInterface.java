package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface OperatorInterface {

	public static final List<OperatorInterface> OPERATORS = new ArrayList<>();

	public void initOperators();

	public boolean isApplicable(StateInterface stateObject);

	public StateInterface apply(StateInterface stateObject);

	public default double getCost() {
		return 1;
	}
}