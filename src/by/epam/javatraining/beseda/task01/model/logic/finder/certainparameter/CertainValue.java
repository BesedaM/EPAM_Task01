package by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Functional interface containing method match used in CertainValueFinder class
 * find method
 *
 * @see CertainValueFinder.class
 * @author Beseda
 * @version 1.0 09/03/2019
 */
public interface CertainValue {

    /**
     * Abstract method for finding out whether the certain Publication object in
     * PublicationContainer satisfying the certain condition
     *
     * @param books Input PublicationContainer object
     * @param index Index of the Publication object in the PublicationContainer
     * @return true or false
     * @throws WrongIndexException in case there is no so such publication index
     * in the container
     */
    boolean match(PublicationContainer books, int index)
            throws WrongIndexException;
}
