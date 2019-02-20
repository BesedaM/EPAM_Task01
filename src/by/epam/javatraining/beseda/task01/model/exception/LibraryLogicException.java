package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class LibraryLogicException extends LibraryException{

    public LibraryLogicException() {
    }

    public LibraryLogicException(String message) {
        super(message);
    }

    public LibraryLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryLogicException(Throwable cause) {
        super(cause);
    }

    public LibraryLogicException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
