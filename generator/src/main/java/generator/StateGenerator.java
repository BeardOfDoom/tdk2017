package generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import enums.VarStruct;
import enums.VarType;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import misc.Dimension;
import representation.AssignRepresentation;
import representation.ClassRepresentation;
import representation.ParameterRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;
import utils.GeneratorUtils;

//TODO: Review set functions
public class StateGenerator {

  private Map<String, Object> namedStateStartArguments = new HashMap<>();
  private Map<String, Object> namedStateGoalArguments = new HashMap<>();

  public StateGenerator() {
  }

  public ClassRepresentation generate(StateRepresentation stateRepresentation, String directoryName, String packageName,
      String fileName, boolean keepTogetherGettersAndSetters) throws IOException {

    //TODO: Handle error
    if (stateRepresentation == null) {
      System.out.println("Error");
    }

    fillNamedArguments(stateRepresentation);

    ClassName className = ClassName.get(packageName, fileName);
    List<AttributeRepresentation> attributes = stateRepresentation.getAttributes();
    List<FieldSpec> fields = GeneratorUtils.generateFieldsFromAttributes(attributes);

    TypeSpec state = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(StateInterface.class)
        .addFields(fields)
        .addMethod(generateConstructWithInitializer(stateRepresentation))
        .addMethods(
            GeneratorUtils.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
        .addMethod(generateGetStartMethod(stateRepresentation, className))
        .addMethod(generateIsGoalMethod(stateRepresentation))
        .addMethod(GeneratorUtils.generateEqualsMethod(fields, className, fileName.toLowerCase()))
        .addMethod(GeneratorUtils.generateHashCodeMethod(fields))
        .addMethod(GeneratorUtils.generateToStringMethod(fields, className))
        .addMethod(generateCopyMethod(stateRepresentation, className))
        .addMethod(generateGetAttributeByNumberMethod())
        .addMethod(generateSetAttributeByNumberMethod())
        .build();

    JavaFile javaFile = JavaFile.builder(packageName, state)
        .skipJavaLangImports(true)
        .build();

    Path path = Paths.get(directoryName);

    javaFile.writeTo(path);

    String filePath = GeneratorUtils.getFilePath(directoryName, packageName, fileName);

    return new ClassRepresentation(className, fields, filePath);
  }

  private MethodSpec generateConstructWithInitializer(StateRepresentation stateRepresentation) {
    MethodSpec.Builder builder = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC);

    for (AttributeRepresentation currentAttribute : stateRepresentation.getAttributes()) {
      builder.addCode(generateInitializer(currentAttribute));
      builder.addCode("");
    }

    return builder.build();
  }

  private CodeBlock generateInitializer(AttributeRepresentation attribute) {
    CodeBlock.Builder builder = CodeBlock.builder();
    String attributeName = attribute.getAttributeName();

    if (attribute.getVarStruct().equals(VarStruct.SET)) {
      builder
          .addStatement("this.set" + attributeName + "(new $T<>())", HashSet.class);
    } else {
      String dimensionN = attribute.getDimension().getDimensionN();
      String dimensionM = attribute.getDimension().getDimensionM();
      TypeName attributeType = GeneratorUtils.getAttributeType(attribute);
      TypeName innerAttributeType = GeneratorUtils.getInnerAttributeType(attribute);

      builder
          .addStatement("$T init" + attributeName + "= new $T<>()", attributeType, ArrayList.class)
          .beginControlFlow("for(int i = 0; i<$L; i++)", dimensionN)
          .addStatement("$1T tmpList = new $2T<>()", innerAttributeType, ArrayList.class)
          .beginControlFlow("for(int j = 0; j<$L; j++)", dimensionM)
          .add(getMatrixStart(attribute))
          .endControlFlow()
          .addStatement("init" + attributeName + ".add(tmpList)")
          .endControlFlow()
          .addStatement("this.set" + attributeName + "(init" + attributeName + ")");
    }

    return builder.build();
  }

  private CodeBlock getMatrixStart(AttributeRepresentation attribute) {
    CodeBlock.Builder builder = CodeBlock.builder();

    if (attribute.getVarType().equals(VarType.NUMBER)) {
      builder.addStatement("tmpList.add($L)", 0d);
    } else {
      builder.addStatement("tmpList.add(new $T())", String.class);
    }

    return builder.build();
  }

  private MethodSpec generateGetStartMethod(StateRepresentation stateRepresentation, ClassName className) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getStart")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(className)
        .addStatement("$1T state = new $1T()", className);

    for (ParameterRepresentation parameter : stateRepresentation.getStateStartParameters()) {
      builder
          .beginControlFlow("for(int $1L = $2L; $1L <= $3L; $1L += $4L)",
              parameter.getParameterName(),
              parameter.getFrom(), parameter.getTo(), parameter.getBy());

    }

    for (AssignRepresentation assignStatement : stateRepresentation.getAssignRepresentations()) {
      builder.addCode(getAssignStatement(assignStatement));
    }

    for (int i = 0; i < stateRepresentation.getStateStartParameters().size(); i++) {
      builder.endControlFlow();
    }

    builder.addStatement("return state");

    return builder.build();
  }

  private MethodSpec generateIsGoalMethod(StateRepresentation stateRepresentation) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isGoal")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class);

    builder.addCode(getStateGoalStatement(stateRepresentation));

    return builder.build();
  }

  private MethodSpec generateCopyMethod(StateRepresentation stateRepresentation, ClassName className) {
    String resultName = "result";

    MethodSpec.Builder builder = MethodSpec.methodBuilder("copy")
        .addModifiers(Modifier.PUBLIC)
        .returns(className);

    builder.addStatement("$1T $2L = new $1T()", className, resultName);

    for (AttributeRepresentation attribute : stateRepresentation.getAttributes()) {
      Class typeClass =
          attribute.getVarType().equals(VarType.NUMBER) ? Double.class : String.class;
      String lowerCaseAttributeName = attribute.getAttributeName().toLowerCase();

      if (attribute.getVarStruct().equals(VarStruct.SET)) {
        builder.beginControlFlow("for ($1T element : $2L)", typeClass, lowerCaseAttributeName)
            .addStatement("$1L.get$2L().add(element)", resultName, attribute.getAttributeName())
            .endControlFlow();

      } else {
        builder.beginControlFlow("for ($1T<$2T> list : $3L)", List.class, typeClass,
            lowerCaseAttributeName)
            .addStatement("$1T<$2T> tmpList = new $3T<>()", List.class, typeClass, ArrayList.class)
            .beginControlFlow("for ($T element : list)", typeClass)
            .addStatement("tmpList.add(element)")
            .endControlFlow()
            .addStatement("$1T index = $2L.indexOf(list)", Integer.class, lowerCaseAttributeName)
            .addStatement("$1L.get$2L().set(index, tmpList)", resultName,
                attribute.getAttributeName())
            .endControlFlow();
      }
    }

    builder.addStatement("return $L", resultName);

    return builder.build();
  }

  private MethodSpec generateGetAttributeByNumberMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getAttributeByNumber")
        .returns(Object.class)
        .addModifiers(Modifier.PUBLIC)
        .addParameter(Integer.class, "number");

    builder.beginControlFlow("try")
        .addStatement("return this.getClass().getDeclaredFields()[number].get(this)")
        .endControlFlow()
        .beginControlFlow("catch($T e)", IllegalAccessException.class)
        .addStatement("e.printStackTrace()")
        .endControlFlow();

    builder.addStatement("return null");

    return builder.build();
  }

  private MethodSpec generateSetAttributeByNumberMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("setAttributeByNumber")
        .returns(void.class)
        .addModifiers(Modifier.PUBLIC)
        .addParameter(Integer.class, "number")
        .addParameter(Object.class, "value");

    builder.beginControlFlow("try")
        .addStatement("this.getClass().getDeclaredFields()[number].set(this, value)")
        .endControlFlow()
        .beginControlFlow("catch($T e)", IllegalAccessException.class)
        .addStatement("e.printStackTrace()")
        .endControlFlow();

    return builder.build();
  }

  private CodeBlock getAssignStatement(AssignRepresentation assignStatement) {
    CodeBlock.Builder builder = CodeBlock.builder();
    String attributeName = assignStatement.getAttributeRepresentation().getAttributeName();
    String value;
    Dimension dimension;

    switch (assignStatement.getType()) {
      case SET:
        value = assignStatement.getValue();
        builder
            .addNamed("state.set" + attributeName + "(" + value + ");\n", namedStateStartArguments);
        break;

      case MATRIX:
        dimension = assignStatement.getDimension();
        value = assignStatement.getValue();
        builder.addStatement("state.get" + attributeName + "().get($L).set($L, $L)",
            dimension.getDimensionN(),
            dimension.getDimensionM(), value);
        break;
    }
    return builder.build();
  }

  private CodeBlock getStateGoalStatement(StateRepresentation stateRepresentation) {
    CodeBlock.Builder builder = CodeBlock.builder()
        .addNamed("return " + stateRepresentation.getStateGoal(), namedStateGoalArguments)
        .add(";\n");
    return builder.build();
  }

  private void fillNamedArguments(StateRepresentation stateRepresentation) {
    namedStateGoalArguments.clear();
    namedStateStartArguments.clear();

    namedStateStartArguments.put(GeneratorUtils.hashSetEntry.getKey(), GeneratorUtils.hashSetEntry.getValue());
    namedStateStartArguments.put(GeneratorUtils.arraysEntry.getKey(), GeneratorUtils.arraysEntry.getValue());

    namedStateGoalArguments.put(GeneratorUtils.hashSetEntry.getKey(), GeneratorUtils.hashSetEntry.getValue());
    namedStateGoalArguments.put(GeneratorUtils.arraysEntry.getKey(), GeneratorUtils.arraysEntry.getValue());

    for (AttributeRepresentation attribute : stateRepresentation.getAttributes()) {
      String attributeName = attribute.getAttributeName();
      String lowerCaseAttributeName = attributeName.toLowerCase();

      namedStateStartArguments.put(lowerCaseAttributeName, "state.get" + attributeName + "()");
      namedStateGoalArguments.put(lowerCaseAttributeName, lowerCaseAttributeName);
    }
  }
}