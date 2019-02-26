package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class PublicationException extends Exception{

    public PublicationException() {
    }

    public PublicationException(String message) {
        super(message);
    }

    public PublicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationException(Throwable cause) {
        super(cause);
    }

    public PublicationException(String message, Throwable cause, 
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
