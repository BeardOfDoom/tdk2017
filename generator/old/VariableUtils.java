package utils;

import containers.AttributeRepresentation;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import misc.Dimension;
import misc.Matrix;

public class VariableUtils {

  private static final String VAR_STRUCT_SET = "Set";
  private static final String VAR_STRUCT_MATRIX = "Matrix";

  private static final String VAR_TYPE_NUMBER = "Number";
  private static final String VAR_TYPE_WORD = "Word";

  private static List<AttributeRepresentation> variableList = new ArrayList<>();

  public static void addVariable(String varName, String varStruct, String varType) {
    variableList.add(new AttributeRepresentation(varName, getVarStructClass(varStruct),
        getVarTypeClass(varType)));
  }

  public static void addVariable(String varName, String varStruct, String varType,
      Integer dimensionN,
      Integer dimensionM) {

    variableList.add(
        new AttributeRepresentation(varName, getVarStructClass(varStruct), getVarTypeClass(varType),
            new Dimension(dimensionN, dimensionM)));
  }

  public static Boolean isAvailableVariable(String varName) {
    return !getVariableNames().contains(varName);
  }

  //TODO: Handle Exception
  public static Class getVariableStruct(String varName) throws NoSuchElementException {
    return getVariableByName(varName).get().getVarStruct();
  }

  //TODO: Handle Exception
  public static Class getVariableType(String varName) throws NoSuchElementException {
    return getVariableByName(varName).get().getVarType();
  }

  public static void printVariableList() {
    System.out.println(variableList);
  }

  public static List<AttributeRepresentation> getVariableList() {
    return variableList;
  }

  public static List<String> getVariableNames() {
    return variableList.stream().map(AttributeRepresentation::getVariableName)
        .collect(Collectors.toList());
  }

  private static Optional<AttributeRepresentation> getVariableByName(String varName) {
    for (AttributeRepresentation variable : variableList) {
      if (variable.getVariableName().equals(varName)) {
        return Optional.of(variable);
      }
    }
    return Optional.empty();
  }

  //TODO: Handle when none of the above
  private static Class getVarStructClass(String varStruct) {
    return varStruct.equals(VAR_STRUCT_SET) ? Set.class : Matrix.class;
  }

  private static Class getVarTypeClass(String varType) {
    return varType.equals(VAR_TYPE_NUMBER) ? Double.class : String.class;
  }
}