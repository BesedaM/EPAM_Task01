package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19.02.2019
 */
public class IllegalAuthorException  extends LibraryLogicException{

    public IllegalAuthorException() {
    }

    public IllegalAuthorException(String message) {
        super(message);
    }
    
    
}
