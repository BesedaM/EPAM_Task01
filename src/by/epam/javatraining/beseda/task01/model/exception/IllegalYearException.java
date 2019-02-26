package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class IllegalYearException extends PublicationLogicException{

    public IllegalYearException() {
    }

    public IllegalYearException(String message) {
        super(message);
    }
    
    
}
