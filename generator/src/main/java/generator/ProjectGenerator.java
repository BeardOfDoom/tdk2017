package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import representation.ClassRepresentation;
import representation.ProjectRepresentation;
import representation.operator.OperatorRepresentation;
import utils.GeneratorUtils;

public class ProjectGenerator {

  private static final String GENERATED_UTILS_CONTENT_FILENAME = "GeneratedUtilsContent.txt";
  private static final String GENERATED_UTILS_FILENAME = "GeneratedUtils";

  StateGenerator stateGenerator = new StateGenerator();
  OperatorGenerator operatorGenerator = new OperatorGenerator();

  public ProjectGenerator(StateGenerator stateGenerator,
      OperatorGenerator operatorGenerator) {
    this.stateGenerator = stateGenerator;
    this.operatorGenerator = operatorGenerator;
  }

  public List<ClassRepresentation> generate(ProjectRepresentation project, String directoryName,
      String packageName)
      throws IOException {

    List<ClassRepresentation> result = new ArrayList<>();

    stateGenerator.setState(project.getStateRepresentation());
    stateGenerator.setKeepTogetherGettersAndSetters(true);
    ClassRepresentation stateClass = stateGenerator
        .generate(directoryName, packageName, project.getStateRepresentation().getName());
    result.add(stateClass);

    operatorGenerator.setStateClass(stateClass);

    for (OperatorRepresentation operator : project.getOperatorRepresentation()) {
      operatorGenerator.setOperator(operator);
      ClassRepresentation operatorClass = operatorGenerator
          .generate(directoryName, packageName, operator.getName());

      result.add(operatorClass);
    }

    ClassRepresentation generatedUtilsClassRepresentation = copyGeneratedUtils(directoryName,
        packageName);

    result.add(generatedUtilsClassRepresentation);
    return result;
  }

  private ClassRepresentation copyGeneratedUtils(String directoryName, String packageName)
      throws IOException {
    ClassRepresentation generatedUtilsClassRepresentation = new ClassRepresentation();
    generatedUtilsClassRepresentation
        .setFilePath(
            GeneratorUtils.getFilePath(directoryName, packageName, GENERATED_UTILS_FILENAME));

    File resultFile = new File(
        GeneratorUtils.getFilePath(directoryName, packageName, "GeneratedUtils"));

    InputStream generatedUtilsContent = Thread.currentThread().getContextClassLoader()
        .getResourceAsStream(GENERATED_UTILS_CONTENT_FILENAME);

    BufferedReader reader = new BufferedReader(new InputStreamReader(generatedUtilsContent));
    BufferedWriter writer = new BufferedWriter(new FileWriter(resultFile));

    String importLine = "package " + packageName + ";\n\n";
    writer.append(importLine);

    String currentLine;
    while ((currentLine = reader.readLine()) != null) {
      writer.append(currentLine);
      writer.newLine();
    }

    writer.close();
    reader.close();

    return generatedUtilsClassRepresentation;
  }
}