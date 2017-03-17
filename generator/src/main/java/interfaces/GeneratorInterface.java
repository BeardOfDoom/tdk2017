package interfaces;

import java.io.IOException;

public interface GeneratorInterface {

  public ClassRepresentationInterface generate(String directoryName, String packageName,
      String fileName)
      throws IOException;


}
