package by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter;

import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

/**
 * Functional interface containing method match used in ConcreteValueFinder class
 * find method
 *
 * @see ConcretePublicationFinder.class
 * @author Beseda
 * @version 1.0 09/03/2019
 */
public interface ConcreteValue {

    /**
     * Abstract method for finding out whether the concrete Publication object in
     * PublicationContainer object satisfying the concrete condition
     *
     * @param books Input object, implementing PublicationContainer 
     * @param index Index of the Publication object in the PublicationContainer object
     * @return true or false
     * @throws PublicationContainerException in case there is no so such publication index
     * in the container
     */
    boolean matches(PublicationContainer books, int index)
            throws PublicationContainerException;
}
