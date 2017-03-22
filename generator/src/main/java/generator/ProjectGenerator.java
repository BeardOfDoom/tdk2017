package generator;

import representation.ClassRepresentation;
import representation.ProjectRepresentation;
import representation.operator.OperatorRepresentation;
import utils.CommonUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectGenerator {

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

        ClassRepresentation generatedUtilsClassRepresentation = new ClassRepresentation();
        ClassRepresentation operatorInterface = new ClassRepresentation();
        ClassRepresentation stateInterface = new ClassRepresentation();

        generatedUtilsClassRepresentation
                .setFilePath(CommonUtils.getFilePath(directoryName, packageName, "GeneratedUtils"));

        operatorInterface.setFilePath(CommonUtils.getFilePath(directoryName, packageName, "OperatorInterface"));
        stateInterface.setFilePath(CommonUtils.getFilePath(directoryName, packageName, "StateInterface"));

        result.add(generatedUtilsClassRepresentation);
        result.add(operatorInterface);
        result.add(stateInterface);

        return result;
    }
}
