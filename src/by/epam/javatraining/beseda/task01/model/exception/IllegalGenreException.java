package by.epam.javatraining.beseda.task01.model.exception;

/**
 *
 * @author Beseda
 * @version 1.0 04/03/2019
 */
public class IllegalGenreException extends PublicationLogicException{

    public IllegalGenreException() {
    }

    public IllegalGenreException(String message) {
        super(message);
    }

}
