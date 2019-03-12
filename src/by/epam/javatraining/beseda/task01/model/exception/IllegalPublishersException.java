package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 04/03/2019
 */
public class IllegalPublishersException extends PublicationLogicException{

    public IllegalPublishersException() {
    }

    public IllegalPublishersException(String message) {
        super(message);
    }

}
