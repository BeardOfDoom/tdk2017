package generator;


import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import interfaces.GeneratorInterface;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import representation.ClassRepresentation;
import representation.ParameterRepresentation;
import representation.operator.OperatorRepresentation;
import representation.operator.VariableRepresentation;
import utils.GeneratorUtils;

public class OperatorGenerator implements GeneratorInterface {

  private OperatorRepresentation operator;
  private ClassRepresentation stateClass;
  private boolean keepTogetherGettersAndSetters = true;
  private Map<String, Object> namedArguments = new HashMap<>();

  public OperatorGenerator() {
  }

  public OperatorGenerator(OperatorRepresentation operator,
      ClassRepresentation stateClass, boolean keepTogetherGettersAndSetters) {
    this.operator = operator;
    this.stateClass = stateClass;
    this.keepTogetherGettersAndSetters = keepTogetherGettersAndSetters;
  }

  public OperatorRepresentation getOperator() {
    return operator;
  }

  public void setOperator(OperatorRepresentation operator) {
    this.operator = operator;
  }

  public ClassRepresentation getStateClass() {
    return stateClass;
  }

  public void setStateClass(ClassRepresentation stateClass) {
    this.stateClass = stateClass;
  }

  public boolean isKeepTogetherGettersAndSetters() {
    return keepTogetherGettersAndSetters;
  }

  public void setKeepTogetherGettersAndSetters(boolean keepTogetherGettersAndSetters) {
    this.keepTogetherGettersAndSetters = keepTogetherGettersAndSetters;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    OperatorGenerator that = (OperatorGenerator) o;

    if (keepTogetherGettersAndSetters != that.keepTogetherGettersAndSetters) {
      return false;
    }
    if (operator != null ? !operator.equals(that.operator) : that.operator != null) {
      return false;
    }
    return stateClass != null ? stateClass.equals(that.stateClass) : that.stateClass == null;
  }

  @Override
  public int hashCode() {
    int result = operator != null ? operator.hashCode() : 0;
    result = 31 * result + (stateClass != null ? stateClass.hashCode() : 0);
    result = 31 * result + (keepTogetherGettersAndSetters ? 1 : 0);
    return result;
  }

  @Override
  public ClassRepresentation generate(String directoryName, String packageName, String fileName)
      throws IOException {

    if (operator == null || stateClass == null) {
      System.out.println("hiba");
    }

    fillNamedArguments();

    ClassName className = ClassName.get(packageName, fileName);
    List<ParameterRepresentation> parameters = operator.getParameters();
    List<FieldSpec> fields = GeneratorUtils.generateFieldsFromParameters(parameters);

    TypeSpec operator = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(OperatorInterface.class)
        .addAnnotation(generateSuppressWarningsAnnotation())
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
        .build();

    Path path = Paths.get(directoryName);

    javaFile.writeTo(path);

    String filePath = GeneratorUtils.getFilePath(directoryName, packageName, fileName);

    return new ClassRepresentation(className, fields, filePath);
  }

  private AnnotationSpec generateSuppressWarningsAnnotation() {
    AnnotationSpec.Builder builder = AnnotationSpec.builder(SuppressWarnings.class)
        .addMember("value", "$S", "unchecked");

    return builder.build();
  }

  private void fillNamedArguments() {
    for (ParameterRepresentation parameter : operator.getParameters()) {

      boolean containsError = false;

      Integer from = parameter.getFrom();
      Integer to = parameter.getTo();
      Integer by = parameter.getBy();

      TypeName typeName = stateClass.getFields().get(from).type;

      for (int i = from + by; i <= to; i += by) {
        if (i >= stateClass.getFields().size() || !stateClass.getFields().get(i).type
            .equals(typeName)) {
          containsError = true;
          break;
        }
      }

      if (containsError) {
        namedArguments.put(parameter.getParameterName(), "error");
      } else {
        namedArguments.put(parameter.getParameterName(), typeName);
      }
    }
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

  private CodeBlock generateIsApplicableStatement() {
    //TODO: handle illegal argument exception when namedArguments field is error

    CodeBlock.Builder builder = CodeBlock.builder()
        .add("return ")
        .addNamed(operator.getOperatorPrecondition(), namedArguments)
        .add(";");

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
        .addCode(generateIsApplicableStatement());

    return builder.build();
  }

  private CodeBlock generateApplyStatement() {
    CodeBlock.Builder builder = CodeBlock.builder();

    for (String currentStatement : operator.getOperatorEffects()) {
      builder.addNamed(currentStatement, namedArguments)
          .add(";\n");
    }

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

    builder.addCode(generateApplyStatement());

    builder.addCode("\n");

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