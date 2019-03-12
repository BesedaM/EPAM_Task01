package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 06/03/2019
 */
public class WrongIndexException extends PublicationContainerException{

    public WrongIndexException() {
        super();
    }

    public WrongIndexException(String message) {
        super(message);
    }
    
}
