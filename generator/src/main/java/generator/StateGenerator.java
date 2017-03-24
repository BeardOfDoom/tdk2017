package generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import interfaces.GeneratorInterface;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.lang.model.element.Modifier;
import misc.VarStruct;
import misc.VarType;
import representation.ClassRepresentation;
import representation.ParameterRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;

//TODO: Review set functions
public class StateGenerator implements GeneratorInterface {

  private StateRepresentation state;
  private boolean keepTogetherGettersAndSetters = true;

  public StateGenerator() {
  }

  public StateGenerator(StateRepresentation state, boolean keepTogetherGettersAndSetters) {
    this.state = state;
    this.keepTogetherGettersAndSetters = keepTogetherGettersAndSetters;
  }

  public StateRepresentation getState() {
    return state;
  }

  public void setState(StateRepresentation state) {
    this.state = state;
  }

  public Boolean getKeepTogetherGettersAndSetters() {
    return keepTogetherGettersAndSetters;
  }

  public void setKeepTogetherGettersAndSetters(Boolean keepTogetherGettersAndSetters) {
    this.keepTogetherGettersAndSetters = keepTogetherGettersAndSetters;
  }

  @Override
  public ClassRepresentation generate(String directoryName, String packageName,
      String fileName) throws IOException {

    if (state == null) {
      System.out.println("hiba");
    }

    ClassName className = ClassName.get(packageName, fileName);
    List<AttributeRepresentation> attributes = state.getAttributes();
    List<FieldSpec> fields = GeneratorUtils.generateFieldsFromAttributes(attributes);

    TypeSpec state = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(StateInterface.class)
        .addFields(fields)
        .addMethod(generateConstructWithInitializer())
        .addMethods(
            GeneratorUtils.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
        .addMethod(generateGetStartMethod(className))
        .addMethod(generateIsGoalMethod())
        .addMethod(GeneratorUtils.generateEqualsMethod(fields, className, fileName.toLowerCase()))
        .addMethod(GeneratorUtils.generateHashCodeMethod(fields))
        .addMethod(GeneratorUtils.generateToStringMethod(fields, className))
        .addMethod(generateCopyMethod(className))
        .build();

    JavaFile javaFile = JavaFile.builder(packageName, state)
        .skipJavaLangImports(true)
        .build();

    Path path = Paths.get(directoryName);

    javaFile.writeTo(path);

    String filePath = GeneratorUtils.getFilePath(directoryName, packageName, fileName);

    return new ClassRepresentation(className, fields, filePath);
  }

  private MethodSpec generateConstructWithInitializer() {
    MethodSpec.Builder builder = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC);

    for (AttributeRepresentation currentAttribute : state.getAttributes()) {
      builder.addCode(generateInitializer(currentAttribute));
      builder.addCode("");
    }

    return builder.build();
  }

  //TODO: hiba a tmpList nél nem attributeType hanem az inner Type
  private CodeBlock generateInitializer(AttributeRepresentation attribute) {
    CodeBlock.Builder builder = CodeBlock.builder();
    String attributeName = attribute.getAttributeName();

    if (attribute.getVarStruct().equals(VarStruct.SET)) {
      builder
          .addStatement("this.set" + attributeName + "(new $T<>())", HashSet.class);
    } else {
      Integer dimensionN = attribute.getDimension().getDimensionN();
      Integer dimensionM = attribute.getDimension().getDimensionM();
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

  private MethodSpec generateGetStartMethod(ClassName className) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getStart")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(className)
        .addStatement("$1T state = new $1T()", className);

    for (ParameterRepresentation parameter : state.getStateStartParameters()) {
      builder
          .beginControlFlow("for(int $1L = $2L; $1L <= $3L; $1L += $4L)",
              parameter.getParameterName(),
              parameter.getFrom(), parameter.getTo(), parameter.getBy());

    }

    CodeBlock assigns = GeneratorUtils.getAssignStatements(state.getAssigns());
    builder.addCode(assigns);

    for (int i = 0; i < state.getStateStartParameters().size(); i++) {
      builder.endControlFlow();
    }

    builder.addStatement("return state");

    return builder.build();
  }

  private MethodSpec generateIsGoalMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isGoal")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class);

    builder.addStatement("return $L", state.getStateGoal());

    return builder.build();
  }

  private MethodSpec generateCopyMethod(ClassName className) {
    String resultName = "result";

    MethodSpec.Builder builder = MethodSpec.methodBuilder("copy")
        .addModifiers(Modifier.PUBLIC)
        .returns(className);

    builder.addStatement("$1T $2L = new $1T()", className, resultName);

    for (AttributeRepresentation attribute : state.getAttributes()) {
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

}