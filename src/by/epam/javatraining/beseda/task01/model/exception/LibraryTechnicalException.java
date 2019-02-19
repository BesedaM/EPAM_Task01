package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19.02.2019
 */
public class LibraryTechnicalException extends LibraryException {

    public LibraryTechnicalException() {
    }

    public LibraryTechnicalException(String message) {
        super(message);
    }

    public LibraryTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryTechnicalException(Throwable cause) {
        super(cause);
    }

    public LibraryTechnicalException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
