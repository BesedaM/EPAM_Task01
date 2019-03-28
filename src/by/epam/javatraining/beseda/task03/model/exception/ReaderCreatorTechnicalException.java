package by.epam.javatraining.beseda.task03.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class ReaderCreatorTechnicalException extends ReaderCreatorException {

    public ReaderCreatorTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReaderCreatorTechnicalException(Throwable cause) {
        super(cause);
    }

    public ReaderCreatorTechnicalException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
