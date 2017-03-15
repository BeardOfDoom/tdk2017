package generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
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
import representations.MatrixAssignRepresentation;
import representations.ParameterRepresentation;
import representations.SetAssignRepresentation;
import representations.state.AttributeRepresentation;
import representations.state.StateRepresentation;

public class StateGenerator {

  private StateRepresentation state;
  private String directoryName;
  private String packageName;
  private String fileName;
  private boolean keepTogetherGettersAndSetters = true;

  public StateGenerator() {
  }

  public StateGenerator(StateRepresentation representation, String directoryName,
      String packageName, String fileName, boolean keepTogetherGettersAndSetters) {
    this.state = representation;
    this.directoryName = directoryName;
    this.packageName = packageName;
    this.fileName = fileName;
    this.keepTogetherGettersAndSetters = keepTogetherGettersAndSetters;
  }

  public StateRepresentation getState() {
    return state;
  }

  public void setState(StateRepresentation state) {
    this.state = state;
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

  public Boolean getKeepTogetherGettersAndSetters() {
    return keepTogetherGettersAndSetters;
  }

  public void setKeepTogetherGettersAndSetters(Boolean keepTogetherGettersAndSetters) {
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

    StateGenerator that = (StateGenerator) o;

    if (keepTogetherGettersAndSetters != that.keepTogetherGettersAndSetters) {
      return false;
    }
    if (state != null ? !state.equals(that.state)
        : that.state != null) {
      return false;
    }
    if (directoryName != null ? !directoryName.equals(that.directoryName)
        : that.directoryName != null) {
      return false;
    }
    if (packageName != null ? !packageName.equals(that.packageName) : that.packageName != null) {
      return false;
    }
    return fileName != null ? fileName.equals(that.fileName) : that.fileName == null;
  }

  @Override
  public int hashCode() {
    int result = state != null ? state.hashCode() : 0;
    result = 31 * result + (directoryName != null ? directoryName.hashCode() : 0);
    result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
    result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
    result = 31 * result + (keepTogetherGettersAndSetters ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "StateGenerator{" +
        "state=" + state +
        ", directoryName='" + directoryName + '\'' +
        ", packageName='" + packageName + '\'' +
        ", fileName='" + fileName + '\'' +
        ", keepTogetherGettersAndSetters=" + keepTogetherGettersAndSetters +
        '}';
  }

  public boolean isReady() {
    return state != null && directoryName != null && packageName != null
        && fileName != null;
  }

  //TODO: handle error!
  public void generateState() throws IOException {
    if (isReady()) {
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
          .addMethod(generateGetStartMethod())
          .addMethod(generateIsGoalMethod())
          .addMethod(GeneratorUtils.generateEqualsMethod(fields, className, fileName.toLowerCase()))
          .addMethod(GeneratorUtils.generateHashCodeMethod(fields))
          .addMethod(GeneratorUtils.generateToStringMethod(fields, className))
          .build();

      JavaFile javaFile = JavaFile.builder(packageName, state)
          .skipJavaLangImports(true)
          .build();

      Path path = Paths.get(directoryName);

      javaFile.writeTo(path);

    } else {
      //TODO: Handle error
    }
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

  private CodeBlock generateInitializer(AttributeRepresentation attribute) {
    CodeBlock.Builder builder = CodeBlock.builder();
    String attributeName = attribute.getAttributeName();

    if (attribute.getVarStruct().equals(VarStruct.SET)) {
      builder
          .addStatement("this.set" + attributeName + "(new $T<>())", HashSet.class);
    } else {
      Integer dimensionN = attribute.getDimension().getDimensionN();
      Integer dimensionM = attribute.getDimension().getDimensionM();
      ParameterizedTypeName attributeType = GeneratorUtils.getAttributeType(attribute);

      builder
          .addStatement("$T init" + attributeName + "= new $T<>()", attributeType, ArrayList.class)
          .beginControlFlow("for(int i = 0; i<$L; i++)", dimensionN)
          .addStatement("$T<$T> tmpList = new $T<>()", List.class, Double.class, ArrayList.class)
          .beginControlFlow("for(int j = 0; j<$L; j++)", dimensionM)
          .addStatement("tmpList.add($L)", 0d)
          .endControlFlow()
          .addStatement("init" + attributeName + ".add(tmpList)")
          .endControlFlow()
          .addStatement("this.set" + attributeName + "(init" + attributeName + ")");
    }

    return builder.build();
  }

  private MethodSpec generateGetStartMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getStart")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(ClassName.get(packageName, fileName))
        .addStatement("$1T state = new $1T()", ClassName.get(packageName, fileName));

    for (ParameterRepresentation parameter : state.getStateStartParameters()) {
      builder
          .beginControlFlow("for(int $1L = $2L; $1L <= $3L; $1L += $4L)",
              parameter.getParameterName(),
              parameter.getFrom(), parameter.getTo(), parameter.getBy());

    }

    for (SetAssignRepresentation setStart : state.getSetStarts()) {
      String attributeName = setStart.getAttribute().getAttributeName();
      builder
          .addStatement("state.set" + attributeName + "(new $T<>(Arrays.asList($L))",
              HashSet.class, GeneratorUtils.getSetStartValuesAsString(setStart));
    }

    for (MatrixAssignRepresentation matrixStart : state.getMatrixStarts()) {
      String attributeName = matrixStart.getAttribute().getAttributeName();
      String dimensionN = matrixStart.getDimensionN();
      String dimensionM = matrixStart.getDimensionM();
      String value = matrixStart.getValue();
      if (matrixStart.getAttribute().getVarType().equals(VarType.NUMBER)) {
        value = "Double.valueOf(" + value + ")";
      }

      builder.addStatement("state.get" + attributeName + "().get($L).set($L, $L)",
          dimensionN,
          dimensionM, value);
    }

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

    builder.addStatement("return ($L)", state.getStateGoal());

    return builder.build();
  }

}