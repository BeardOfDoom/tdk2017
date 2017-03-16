package generator;


import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import generator.classes.GeneratedUtils;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.lang.model.element.Modifier;
import representation.ClassRepresentation;
import representation.ParameterRepresentation;
import representation.operator.OperatorRepresentation;
import representation.operator.VariableRepresentation;

public class OperatorGenerator {

  private OperatorRepresentation operator;
  private ClassRepresentation stateClass;
  private String directoryName;
  private String packageName;
  private String fileName;
  private boolean keepTogetherGettersAndSetters = true;

  public OperatorGenerator() {
  }

  public OperatorRepresentation getOperator() {
    return operator;
  }

  public void setOperator(OperatorRepresentation operator) {
    this.operator = operator;
  }

  public String getDirectoryName() {
    return directoryName;
  }

  public void setDirectoryName(String directoryName) {
    this.directoryName = directoryName;
  }

  public String getPackageName() {
    return packageName;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public boolean isKeepTogetherGettersAndSetters() {
    return keepTogetherGettersAndSetters;
  }

  public void setKeepTogetherGettersAndSetters(boolean keepTogetherGettersAndSetters) {
    this.keepTogetherGettersAndSetters = keepTogetherGettersAndSetters;
  }

  public ClassRepresentation getStateClass() {
    return stateClass;
  }

  public void setStateClass(ClassRepresentation stateClass) {
    this.stateClass = stateClass;
  }

  public boolean isReady() {
    return operator != null && directoryName != null && packageName != null
        && fileName != null;
  }

  public ClassRepresentation generateOperator() throws IOException {
    if (isReady()) {
      ClassName className = ClassName.get(packageName, fileName);
      List<ParameterRepresentation> parameters = operator.getParameters();
      List<FieldSpec> fields = GeneratorUtils.generateFieldsFromParameters(parameters);

      TypeSpec operator = TypeSpec.classBuilder(fileName)
          .addModifiers(Modifier.PUBLIC)
          .addSuperinterface(OperatorInterface.class)
          .addFields(fields)
          .addField(generateCostField())
          .addMethod(generateInitOperatorsMethod(parameters, className))
          .addMethod(GeneratorUtils.generateEmptyConstructor())
          .addMethod(GeneratorUtils.generateConstructor(fields))
          .addMethods(
              GeneratorUtils.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
          .addMethod(GeneratorUtils.generateEqualsMethod(fields, className, fileName.toLowerCase()))
          .addMethod(GeneratorUtils.generateHashCodeMethod(fields))
          .addMethod(GeneratorUtils.generateToStringMethod(fields, className))
          .addMethod(generateIsApplicableMethod())
          .addMethod(generateApplyMethod())
          .addMethod(generateGetCostMethod())
          .build();

      JavaFile javaFile = JavaFile.builder(packageName, operator)
          .skipJavaLangImports(true)
          .addStaticImport(GeneratedUtils.class, "GeneratedUtils")
          .build();

      Path path = Paths.get(directoryName);

      javaFile.writeTo(path);

      return new ClassRepresentation(className, fields);
    } else {
      //TODO: Handle error
    }
    return null;
  }

  private MethodSpec generateInitOperatorsMethod(List<ParameterRepresentation> parameters,
      ClassName className) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("initOperators")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(void.class);

    String lowerCaseClassName = className.simpleName().toLowerCase();
    String parameterNames = GeneratorUtils.getParameterNamesAsString(parameters);

    for (ParameterRepresentation parameter : parameters) {
      String parameterName = parameter.getParameterName();
      Integer from = parameter.getFrom();
      Integer to = parameter.getTo();
      Integer by = parameter.getBy();

      builder
          .beginControlFlow("for($1T $2L = $3L; $2L <= $4L; $2L += $5L)", int.class, parameterName,
              from, to, by);
    }

    builder.addStatement("$T $L = new $T($L)", className, lowerCaseClassName,
        className, parameterNames)
        .addStatement("OPERATORS.add($L)", lowerCaseClassName);

    for (ParameterRepresentation parameter : parameters) {
      builder.endControlFlow();
    }

    return builder.build();

  }

  private MethodSpec generateIsApplicableMethod() {
    String parameterName = "stateObject";
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isApplicable")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class)
        .addParameter(StateInterface.class, parameterName)
        .addStatement("$1T $2L = (($1T) $3L)", stateClass.getClassName(), "original", parameterName)
        .addStatement("return $L", operator.getOperatorPrecondition());

    return builder.build();
  }

  private MethodSpec generateApplyMethod() {
    String parameterName = "stateObject";
    MethodSpec.Builder builder = MethodSpec.methodBuilder("apply")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(StateInterface.class)
        .addParameter(StateInterface.class, parameterName);

    builder
        .addStatement("$1T $2L = (($1T) $3L)", stateClass.getClassName(), "original", parameterName)
        .addStatement("$1T $2L = original.copy()", stateClass.getClassName(), "state");

    builder.addCode("\n");

    for (VariableRepresentation variable : operator.getVariables()) {
      builder.addStatement("$1T $2L = $3L", variable.getClassName(), variable.getName(),
          variable.getValue());
    }

    builder.addCode("\n");

    CodeBlock assigns = GeneratorUtils.getAssignStatements(operator.getAssigns());
    builder.addCode(assigns);

    builder.addStatement("return state");

    return builder.build();
  }

  private FieldSpec generateCostField() {
    FieldSpec.Builder builder = FieldSpec.builder(Double.class, "cost")
        .addModifiers(Modifier.PRIVATE)
        .initializer("$L", operator.getCost());

    return builder.build();
  }

  private MethodSpec generateGetCostMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getCost")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(double.class);

    builder.addStatement("return cost");

    return builder.build();
  }
}