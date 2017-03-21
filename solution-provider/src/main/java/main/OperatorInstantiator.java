package main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import exceptions.OperatorInitializationException;
import exceptions.StateInitializationException;
import interfaces.OperatorInterface;

@SuppressWarnings("unchecked")
public class OperatorInstantiator{
	
  public List<OperatorInterface> getOperatorInstances(List<Class<?>> operatorClasses) throws OperatorInitializationException {
    List<OperatorInterface> result = new ArrayList<>();

	for(Class<?> operatorClass : operatorClasses){
		try {
			operatorClass.getMethod("initOperators").invoke(operatorClass.newInstance());
			Field operatorField = operatorClass.getField("OPERATORS");
			result.addAll((List<OperatorInterface>) operatorField.get(operatorClass));
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException | NoSuchFieldException e) {
			throw new OperatorInitializationException(e);
		}
	}
    return result;
  }
}