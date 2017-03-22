package misc;

import java.util.ArrayList;
import java.util.List;
import representation.ClassRepresentation;

public class ClassManager {

  private static List<ClassRepresentation> classes = new ArrayList<>();

  private ClassManager() {
  }

  public static List<ClassRepresentation> getClasses() {
    return classes;
  }

  public static void setClasses(List<ClassRepresentation> classes) {
    ClassManager.classes = classes;
  }

  public static List<String> getFilePaths() {
    List<String> result = new ArrayList<>();

    classes.forEach(currentClass -> result.add(currentClass.getFilePath()));

    return result;
  }

  public static void addClass(ClassRepresentation classRepresentation) {
    classes.add(classRepresentation);
  }

  public static void addClasses(List<ClassRepresentation> classes) {
    ClassManager.classes.addAll(classes);
  }

  public static void clear() {
    ClassManager.classes.clear();
  }

}
