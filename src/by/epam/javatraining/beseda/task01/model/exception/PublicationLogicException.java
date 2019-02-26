package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class PublicationLogicException extends PublicationException{

    public PublicationLogicException() {
    }

    public PublicationLogicException(String message) {
        super(message);
    }

    public PublicationLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationLogicException(Throwable cause) {
        super(cause);
    }

    public PublicationLogicException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
