package misc;

import interfaces.ClassManagerInterface;
import java.util.ArrayList;
import java.util.List;
import representation.ClassRepresentation;

public class ClassManager implements ClassManagerInterface {

  private List<ClassRepresentation> classes = new ArrayList<>();

  public List<ClassRepresentation> getClasses() {
    return classes;
  }

  public void setClasses(List<ClassRepresentation> classes) {
    this.classes = classes;
  }

  @Override
  public List<String> getFilePaths() {
    List<String> result = new ArrayList<>();

    classes.forEach(currentClass -> result.add(currentClass.getFilePath()));

    return result;
  }

  public void addClassRepresentation(ClassRepresentation classRepresentation) {
    classes.add(classRepresentation);
  }
}
