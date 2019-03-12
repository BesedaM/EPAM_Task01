package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 06/03/2019
 */
public class NotEnoughSpaceException extends PublicationContainerException {

    public NotEnoughSpaceException() {
        super();
    }

    public NotEnoughSpaceException(String message) {
        super(message);
    }

}
