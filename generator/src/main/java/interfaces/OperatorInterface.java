package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface OperatorInterface {

  public static final List<OperatorInterface> OPERATORS = new ArrayList<>();

  public boolean isApplicable(StateInterface state);

  public StateInterface apply(StateInterface state);
}
