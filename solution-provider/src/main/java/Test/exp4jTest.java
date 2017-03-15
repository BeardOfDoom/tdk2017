package Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.nfunk.jep.JEP;

import nodes.BackTrackSimpleNode;
import nodes.Node;

public class exp4jTest {
	
	private Node node = new BackTrackSimpleNode(null, new BackTrackSimpleNode(null, null, null, 1, null), null, 2, null);
	private Test1 test1 = new Test1(new Test1(null, 5), 4);
	
	private List<Double> asdTmp = new ArrayList<>(Arrays.asList(500.0, 200.0, 300.0));
	private List<List<Double>> asd = new ArrayList<>(Arrays.asList(asdTmp));
	private double asd2 = 10;
	private double asd3 = 2;
	
	private Set<Double> asd4 = new HashSet<>(Arrays.asList(2.0,3.0,4.0));
	
	private static String removeBrackets(String string){
		int bracketPosition = string.indexOf("[");
		while(bracketPosition != -1){
			string = string.substring(0, bracketPosition) + string.substring(string.indexOf("]") + 1);
			bracketPosition = string.indexOf("[");
		}
		
		return string;
	}
	
	private static List<Integer> processListElement(String listElement){
		List<Integer> elementList = new ArrayList<>();
		while(!listElement.isEmpty()){
			int endOfElement = listElement.indexOf("]");
			elementList.add(Integer.valueOf(listElement.substring(1, endOfElement)));
			listElement = listElement.substring(endOfElement + 1);
		}
		return elementList;
	}
	
	private static Object getVariable(String packageName, String className, String fieldName, String fieldNameListElement, List<String> innerFields, List<String> innerFieldsListElement) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		Class classByName = Class.forName(packageName + "." + className);
		
		Field fieldByName = classByName.getDeclaredField(fieldName);
		fieldByName.setAccessible(true);

		Object object = fieldByName.get(classByName.newInstance());
		
		if(!fieldNameListElement.isEmpty()){
			if(java.util.List.class.isAssignableFrom(object.getClass())){
				List<Integer> elementList = processListElement(fieldNameListElement);
				for(int element : elementList){
					object = ((List<?>)object).get(element);
				}
			} else {
				System.out.println("nem nyert");
			}
		}
		
		for(String innerField : innerFields){
			Class innerClass = object.getClass();
			
			List<Field> fields = Arrays.asList(innerClass.getDeclaredFields());
			boolean isCointains = false;
			for(Field field : fields){
				if(field.getName().equals(innerField)){
					isCointains = true;
				}
			}
			
			if(!isCointains){
				innerClass = innerClass.getSuperclass();
			}
			//System.out.println(innerClass);
			fieldByName = innerClass.getDeclaredField(innerField);
			fieldByName.setAccessible(true);
			object = fieldByName.get(object);
			
			String actualElement = innerFieldsListElement.get(innerFields.indexOf(innerField));
			
			if(!actualElement.isEmpty()){
				if(java.util.List.class.isAssignableFrom(object.getClass())){
					List<Integer> elementList = processListElement(actualElement);
					for(int element : elementList){
						object = ((List<?>)object).get(element);
					}
				} else {
					System.out.println("nem nyert");
				}
			}			
		}
		
		return object;
	}

	private static List<Object> processVariableName(String variableName){
		List<Object> processedValues = new ArrayList<>();
		
		int pointPosition = variableName.indexOf(".");
		String packageName = variableName.substring(0, pointPosition);
		variableName = variableName.substring(pointPosition + 1);
		
		pointPosition = variableName.indexOf(".");
		String className = variableName.substring(0, pointPosition);
		variableName = variableName.substring(pointPosition + 1);
		
		pointPosition = variableName.indexOf(".");
		String fieldName = null;
		if(pointPosition == -1){
			fieldName = variableName;
			variableName = "";
		} else {
			fieldName = variableName.substring(0, pointPosition);
			variableName = variableName.substring(pointPosition + 1);
		}
		
		String fieldNameListElement = "";
		int bracketPosition = fieldName.indexOf("[");
		if(bracketPosition != -1){
			fieldNameListElement = fieldName.substring(bracketPosition);
			fieldName = fieldName.substring(0, bracketPosition);
		}
		
		List<String> innerFields = new ArrayList<>();
		List<String> innerFieldsListElement = new ArrayList<>();
		while(!variableName.equals("")){
			pointPosition = variableName.indexOf(".");
			if(pointPosition == -1){
				innerFields.add(variableName);
				variableName = "";
			} else {
				innerFields.add(variableName.substring(0, pointPosition));
				variableName = variableName.substring(pointPosition + 1);
			}
			
			int lastInnerFieldPosition = innerFields.size() - 1;
			String lastInnerField = innerFields.get(lastInnerFieldPosition);
			
			String innerFieldNameListElement = "";
			bracketPosition = lastInnerField.indexOf("[");
			if(bracketPosition != -1){
				innerFieldNameListElement = lastInnerField.substring(bracketPosition);
				innerFields.set(lastInnerFieldPosition, lastInnerField.substring(0, bracketPosition));
			}
			innerFieldsListElement.add(innerFieldNameListElement);
		}
		
		//System.out.println(packageName + " " + className + " " + fieldName + " " + fieldNameListElement + " " + innerFields + " " + innerFieldsListElement) ;
		Object object = null;
		try {
			object = getVariable(packageName, className, fieldName, fieldNameListElement, innerFields, innerFieldsListElement);
			//System.out.println(object);
			
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException | InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Set.class.isAssignableFrom(object.getClass())){
			Set<?> set = (Set)object;
			for(Object setElement : set){
				processedValues.add(setElement);
			}
		} else {
			processedValues.add(object);
		}
		
		return processedValues;
	}
	
	public static void main(String[] args) {
		String expression = "testFunction(Test.exp4jTest.asd4) + Test.exp4jTest.test1.test.asd2[0][0][10] + Test.exp4jTest.asd2 * 3 + Test.exp4jTest.asd3 ^ 3";
		Set<String> variables = new HashSet<>(Arrays.asList("Test.exp4jTest.asd4", "Test.exp4jTest.test1.test.asd2[0][0][10]", "Test.exp4jTest.asd2", "Test.exp4jTest.asd3"));
		
		Set<String> variablesWithoutBrackets = new HashSet<>();
		
		Map<String, Double> variablesWithValue = new HashMap<>();
		
		for(String variable : variables){
			String variableWithOutBrackets = removeBrackets(variable);
			variableWithOutBrackets = variableWithOutBrackets.replace(".", "");
			
			List<Object> processedValues = processVariableName(variable);
			List<String> newVariableNames = new ArrayList<>();
			
			for(int i = 0; i < processedValues.size(); i++){
				variablesWithValue.put(variableWithOutBrackets + i, (Double)processedValues.get(i));
				variablesWithoutBrackets.add(variableWithOutBrackets + i);
				newVariableNames.add(variableWithOutBrackets + i);
			}
			String newVariableNamesWithComma = "";
			for (int i = 0; i < newVariableNames.size(); i++) {
				if (i == newVariableNames.size() - 1) {
					newVariableNamesWithComma += newVariableNames.get(i);
				} else {
					newVariableNamesWithComma += newVariableNames.get(i) + " , ";
				}
			}
			
			expression = expression.replace(variable, newVariableNamesWithComma);
		}
		
		System.out.println(expression + " " + variables);
		
		JEP myParser = new JEP();
	    myParser.addStandardFunctions();
	    myParser.addStandardConstants();
	    myParser.addFunction("testFunction", new newFunctionTest());
	    for(String key : variablesWithValue.keySet()){
	    	System.out.println(key + " " + variablesWithValue.get(key));
	    	myParser.addVariable(key, variablesWithValue.get(key));
	    }
	    System.out.println(expression);
	    myParser.parseExpression(expression);
	    System.out.println(myParser.getValue());
	}
}
