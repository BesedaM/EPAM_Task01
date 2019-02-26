package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class PublicationTechnicalException extends PublicationException {

    public PublicationTechnicalException() {
    }

    public PublicationTechnicalException(String message) {
        super(message);
    }

    public PublicationTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationTechnicalException(Throwable cause) {
        super(cause);
    }

    public PublicationTechnicalException(String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
