package hu.david.veres.graph.validator;

import hu.david.veres.graph.exception.file.FileIsEmptyException;
import hu.david.veres.graph.exception.file.FileIsToLargeException;
import hu.david.veres.graph.exception.file.FileValidationException;
import hu.david.veres.graph.exception.file.InvalidFileExtensionException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidatorImpl implements FileValidator {

    private static final Long MAX_FILE_SIZE = 5 * 1024 * 1024L;
    private static final String EXTENSION = "txt";

    @Override
    public void validate(MultipartFile file) throws FileValidationException {

        if (file.isEmpty()) {
            throw new FileIsEmptyException();
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            throw new FileIsToLargeException();
        }

        if (!FilenameUtils.isExtension(file.getOriginalFilename(), EXTENSION)) {
            throw new InvalidFileExtensionException();
        }

    }

}
