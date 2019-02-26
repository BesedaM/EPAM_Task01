package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class IllegalNumberOfPagesException  extends PublicationLogicException{

    public IllegalNumberOfPagesException() {
    }

    public IllegalNumberOfPagesException(String message) {
        super(message);
    }
    
}
