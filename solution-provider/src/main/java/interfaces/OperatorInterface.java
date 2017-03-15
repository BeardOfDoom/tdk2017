package interfaces;

import java.util.ArrayList;
import java.util.List;

import interfaces.StateInterface;

public interface OperatorInterface {
	
	public static final List<OperatorInterface> OPERATORS  = new ArrayList<>();
	
	public void initOperators();
	
	public boolean isApplicable(StateInterface state);
	
	public StateInterface apply(StateInterface state);
	
	public default double getCost(){
		return 1;
	}
}
