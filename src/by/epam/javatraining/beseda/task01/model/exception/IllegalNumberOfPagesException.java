package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author User
 */
public class IllegalNumberOfPagesException  extends LibraryLogicException{

    public IllegalNumberOfPagesException() {
    }

    public IllegalNumberOfPagesException(String message) {
        super(message);
    }
    
}
