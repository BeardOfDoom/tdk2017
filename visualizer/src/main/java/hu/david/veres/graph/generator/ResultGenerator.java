package hu.david.veres.graph.generator;

import hu.david.veres.graph.model.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResultGenerator {

    Result generate(MultipartFile file) throws IOException;

}
