package generator;


import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
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

public class OperatorGenerator {

  private Map<String, Object> namedArguments = new HashMap<>();

  public OperatorGenerator() {
  }

  public ClassRepresentation generate(OperatorRepresentation operatorRepresentation, ClassRepresentation stateClass,
      String directoryName, String packageName, String fileName, boolean keepTogetherGettersAndSetters)
      throws IOException {

    //TODO: Handle error
    if (operatorRepresentation == null || stateClass == null) {
      System.out.println("Error");
    }

    fillNamedArguments(operatorRepresentation, stateClass);

    ClassName className = ClassName.get(packageName, fileName);
    List<ParameterRepresentation> parameters = operatorRepresentation.getParameters();
    List<FieldSpec> fields = GeneratorUtils.generateFieldsFromParameters(parameters);

    TypeSpec operator = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(OperatorInterface.class)
        .addAnnotation(generateSuppressWarningsAnnotation())
        .addFields(fields)
        .addField(generateCostField(operatorRepresentation))
        .addMethod(generateInitOperatorsMethod(parameters, className))
        .addMethod(GeneratorUtils.generateEmptyConstructor())
        .addMethod(GeneratorUtils.generateConstructor(fields))
        .addMethods(
            GeneratorUtils.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
        .addMethod(GeneratorUtils.generateEqualsMethod(fields, className, fileName.toLowerCase()))
        .addMethod(GeneratorUtils.generateHashCodeMethod(fields))
        .addMethod(GeneratorUtils.generateToStringMethod(fields, className))
        .addMethod(generateIsApplicableMethod(operatorRepresentation, stateClass))
        .addMethod(generateApplyMethod(operatorRepresentation, stateClass))
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

  private void fillNamedArguments(OperatorRepresentation operatorRepresentation, ClassRepresentation stateClass) {
    namedArguments.clear();

    namedArguments.put(GeneratorUtils.hashSetEntry.getKey(), GeneratorUtils.hashSetEntry.getValue());
    namedArguments.put(GeneratorUtils.arraysEntry.getKey(), GeneratorUtils.arraysEntry.getValue());

    for (ParameterRepresentation parameter : operatorRepresentation.getParameters()) {

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

  private CodeBlock generateIsApplicableStatement(OperatorRepresentation operatorRepresentation) {
    //TODO: handle illegal argument exception when namedArguments field is error

    CodeBlock.Builder builder = CodeBlock.builder()
        .add("return ")
        .addNamed(operatorRepresentation.getOperatorPrecondition(), namedArguments)
        .add(";");

    return builder.build();
  }

  private MethodSpec generateIsApplicableMethod(OperatorRepresentation operatorRepresentation,
      ClassRepresentation stateClass) {

    System.out.println("\n\n" + stateClass + "\n\n");
    String parameterName = "stateObject";
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isApplicable")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class)
        .addParameter(StateInterface.class, parameterName)
//        .addStatement("System.out.println(" + parameterName + ".getClass())")
        .addStatement("$1L $2L = ($1L.class.cast($3L))", stateClass.getClassName().toString(), "original",
            parameterName)
        .addCode(generateIsApplicableStatement(operatorRepresentation));

    return builder.build();
  }

  private CodeBlock generateApplyStatement(OperatorRepresentation operatorRepresentation) {
    CodeBlock.Builder builder = CodeBlock.builder();

    for (String currentStatement : operatorRepresentation.getOperatorEffects()) {
      builder.addNamed(currentStatement, namedArguments)
          .add(";\n");
    }

    return builder.build();
  }

  private MethodSpec generateApplyMethod(OperatorRepresentation operatorRepresentation,
      ClassRepresentation stateClass) {
    String parameterName = "stateObject";
    MethodSpec.Builder builder = MethodSpec.methodBuilder("apply")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(StateInterface.class)
        .addParameter(StateInterface.class, parameterName);

    builder
        .addStatement("$1L $2L = (($1L) $3L)", stateClass.getClassName().toString(), "original", parameterName)
        .addStatement("$1L $2L = original.copy()", stateClass.getClassName().toString(), "state");

    builder.addCode("\n");

    for (VariableRepresentation variable : operatorRepresentation.getVariables()) {
      builder.addStatement("$1T $2L = $3L", variable.getClassName(), variable.getName(),
          variable.getValue());
    }

    builder.addCode(generateApplyStatement(operatorRepresentation));

    builder.addCode("\n");

    builder.addStatement("return state");

    return builder.build();
  }

  private FieldSpec generateCostField(OperatorRepresentation operatorRepresentation) {
    FieldSpec.Builder builder = FieldSpec.builder(Double.class, "cost")
        .addModifiers(Modifier.PRIVATE)
        .initializer("$L", operatorRepresentation.getCost());

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