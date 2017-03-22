import generator.OperatorGenerator;
import generator.ProjectGenerator;
import generator.StateGenerator;
import java.io.IOException;
import java.util.List;
import misc.ClassManager;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;
import utils.CommonUtils;

public class Main {

  private static final String INPUT_FILE_NAME = "input.txt";

  private static final String OUTPUT_DIRECTORY_NAME = "generated";
  private static final String OUTPUT_PACKAGE_NAME = "com.prototype";

  //TODO: Error listener on lexer

  public static void main(String[] args) throws IOException {

    StateGenerator stateGenerator = new StateGenerator();
    OperatorGenerator operatorGenerator = new OperatorGenerator();
    ProjectRepresentation projectRepresentation = CommonUtils.processInputFile(INPUT_FILE_NAME);

    if (!projectRepresentation.getContainsError()) {
      ProjectGenerator
          projectGenerator = new ProjectGenerator(stateGenerator, operatorGenerator);
      List<ClassRepresentation> generatedClasses = projectGenerator
          .generate(projectRepresentation, OUTPUT_DIRECTORY_NAME, OUTPUT_PACKAGE_NAME);

      ClassManager.clear();
      ClassManager.addClasses(generatedClasses);
      System.out.println("Files generated!");
    }
  }
}