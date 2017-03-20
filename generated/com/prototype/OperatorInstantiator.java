package com.prototype;

import interfaces.OperatorInstantiatorInterface;
import interfaces.OperatorInterface;
import java.util.ArrayList;
import java.util.List;

public class OperatorInstantiator implements OperatorInstantiatorInterface {
  @Override
  public List<OperatorInterface> getOperatorInstances() {
    List<OperatorInterface> result = new ArrayList<>();

    Operator1 operator1 = new Operator1();
    operator1.initOperators();
    result.addAll(Operator1.OPERATORS);

    return result;
  }
}
