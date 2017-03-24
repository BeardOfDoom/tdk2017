package generator;

import representation.ClassRepresentation;
import representation.ProjectRepresentation;
import representation.operator.OperatorRepresentation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                .setFilePath(GeneratorUtils.getFilePath(directoryName, packageName, GENERATED_UTILS_FILENAME));

//    String generatedUtilsContentFile = Thread.currentThread().getContextClassLoader()
//        .getResource(GENERATED_UTILS_CONTENT_FILENAME).getFile();

        String generatedUtilsContentFile = "E:\\IntelliJ_Projects\\tdk2017\\visualizer\\GeneratedUtilsContent.txt";

        File resultFile = new File(
                GeneratorUtils.getFilePath(directoryName, packageName, "GeneratedUtils"));

        BufferedReader reader = new BufferedReader(new FileReader(generatedUtilsContentFile));
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