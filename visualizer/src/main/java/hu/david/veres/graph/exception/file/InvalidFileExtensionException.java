package hu.david.veres.graph.exception.file;

public class InvalidFileExtensionException extends FileValidationException {

    private static final String ERROR_MESSAGE = "error.file.invalid.file.extension";

    public InvalidFileExtensionException() {
    }

    public InvalidFileExtensionException(String message) {
        super(message);
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
