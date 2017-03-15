package hu.david.veres.graph.validator;

import hu.david.veres.graph.exception.file.FileValidationException;
import org.springframework.web.multipart.MultipartFile;

public interface FileValidator {

    void validate(MultipartFile file) throws FileValidationException;

}
