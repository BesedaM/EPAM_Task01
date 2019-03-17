package by.epam.javatraining.beseda.task01.model.logic.sorter.parameter;

import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

/**
 * Functional interface containing method compare used in Sorter class sort
 * method
 *
 * @author Beseda
 * @version 1.0 08/03/2019
 */
public interface Sortable {

    /**
     * Abstract method for comparing two Publication objects
     *
     * @param books Input object, implementing PublicationContainerInterface 
     * @param index Index of the Publication object in the PublicationContainer
     * container
     * @return true or false
     * @throws PublicationContainerException
     */
    boolean compare(PublicationContainer books, int index) 
            throws PublicationContainerException;

}
