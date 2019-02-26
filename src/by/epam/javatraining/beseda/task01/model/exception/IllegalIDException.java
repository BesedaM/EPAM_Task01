package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 26/02/2019
 */
public class IllegalIDException extends PublicationLogicException{

    public IllegalIDException() {
    }

    public IllegalIDException(String message) {
        super(message);
    }
    
}
