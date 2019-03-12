package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class IllegalPagesNumberException  extends PublicationLogicException{

    public IllegalPagesNumberException() {
    }

    public IllegalPagesNumberException(String message) {
        super(message);
    }
    
}
