package hu.david.veres.graph.exception.file;

public class FileIsToLargeException extends FileValidationException {

    private static final String ERROR_MESSAGE = "error.file.file.is.too.large";

    public FileIsToLargeException() {
    }

    public FileIsToLargeException(String message) {
        super(message);
    }

    @Override
    public String getErrorMessage() {
        return ERROR_MESSAGE;
    }
}
