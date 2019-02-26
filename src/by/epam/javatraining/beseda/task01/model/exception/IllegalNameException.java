package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class IllegalNameException  extends PublicationLogicException{

    public IllegalNameException() {
    }

    public IllegalNameException(String message) {
        super(message);
    }
 
}
