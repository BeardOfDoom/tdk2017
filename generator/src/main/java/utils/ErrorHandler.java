package utils;

import representations.ErrorRepresentation;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

  private static List<ErrorRepresentation> errorList = new ArrayList<>();

  public static void addError(ErrorRepresentation error) {
    errorList.add(error);
  }

  public static Boolean containsAnyError() {
    return !errorList.isEmpty();
  }
}