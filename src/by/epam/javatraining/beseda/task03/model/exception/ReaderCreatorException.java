package by.epam.javatraining.beseda.task03.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class ReaderCreatorException extends Exception {

    public ReaderCreatorException() {
    }

    public ReaderCreatorException(String message) {
        super(message);
    }

    public ReaderCreatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderCreatorException(Throwable cause) {
        super(cause);
    }

    public ReaderCreatorException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
