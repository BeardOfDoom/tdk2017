package generator;


import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Modifier;
import representations.ParameterRepresentation;
import representations.operator.OperatorRepresentation;

public class OperatorGenerator {

  private OperatorRepresentation operator;
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
    int result = operator != null ? operator.hashCode() : 0;
    result = 31 * result + (directoryName != null ? directoryName.hashCode() : 0);
    result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
    result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
    result = 31 * result + (keepTogetherGettersAndSetters ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OperatorGenerator{" +
        "operator=" + operator +
        ", directoryName='" + directoryName + '\'' +
        ", packageName='" + packageName + '\'' +
        ", fileName='" + fileName + '\'' +
        ", keepTogetherGettersAndSetters=" + keepTogetherGettersAndSetters +
        '}';
  }

  public boolean isReady() {
    return operator != null && directoryName != null && packageName != null
        && fileName != null;
  }

  public void generateOperator() throws IOException {
    if (isReady()) {
      ClassName className = ClassName.get(packageName, fileName);
      List<ParameterRepresentation> parameters = operator.getParameters();
      List<FieldSpec> fields = GeneratorUtils.generateFieldsFromParameters(parameters);

      TypeSpec operator = TypeSpec.classBuilder(fileName)
          .addModifiers(Modifier.PUBLIC)
          .addSuperinterface(OperatorInterface.class)
          .addFields(fields)
          .addField(generateListField(className))
          .addStaticBlock(generateStaticInitializer(parameters, className))
          .addMethod(GeneratorUtils.generateEmptyConstructor())
          .addMethod(GeneratorUtils.generateConstructor(fields))
          .addMethods(
              GeneratorUtils.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
          .addMethod(GeneratorUtils.generateEqualsMethod(fields, className, fileName.toLowerCase()))
          .addMethod(GeneratorUtils.generateHashCodeMethod(fields))
          .addMethod(GeneratorUtils.generateToStringMethod(fields, className))
          .addMethod(generateIsApplicableMethod())
          .addMethod(generateApplyMethod())
          .build();

      JavaFile javaFile = JavaFile.builder(packageName, operator)
          .skipJavaLangImports(true)
          .build();

      Path path = Paths.get(directoryName);

      javaFile.writeTo(path);

    } else {
      //TODO: Handle error
    }
  }

  private FieldSpec generateListField(ClassName className) {
    ParameterizedTypeName type = ParameterizedTypeName.get(ClassName.get(List.class), className);

    FieldSpec.Builder builder = FieldSpec.builder(type, "OPERATORS")
        .addModifiers(Modifier.PUBLIC)
        .addModifiers(Modifier.STATIC)
        .addModifiers(Modifier.FINAL)
        .initializer("new $T<>()", ArrayList.class);

    return builder.build();
  }

  private CodeBlock generateStaticInitializer(List<ParameterRepresentation> parameters,
      ClassName className) {
    CodeBlock.Builder builder = CodeBlock.builder();

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
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isApplicable")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class)
        .addParameter(StateInterface.class, "state")
        .addStatement("return $L", operator.getOperatorPrecondition());

    return builder.build();
  }

  private MethodSpec generateApplyMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("apply")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(StateInterface.class)
        .addParameter(StateInterface.class, "state")
        .addStatement("return null");

    return builder.build();
  }
}