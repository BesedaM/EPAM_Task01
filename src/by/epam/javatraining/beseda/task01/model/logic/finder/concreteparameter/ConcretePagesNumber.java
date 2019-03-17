package by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter;

import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

/**
 * Class, implementing ConcreteValue interface
 *
 * @see ConcreteValueFinder.class
 * @author Beseda
 * @version 1.0 09/03/2019
 */
public class ConcretePagesNumber implements ConcreteValue {

    private int pagesNumber;

    /**
     * Constructor receiving the concrete parameter, which the user is going to
     * find
     * 
     * @param pagesNumber Number of pages in the Publication
     */
    public ConcretePagesNumber(int pagesNumber) {
        if (pagesNumber > 0) {
            this.pagesNumber = pagesNumber;
        }
    }

    /**
     * Method for finding the Publication object by it's number of pages
     *
     * @param books Input object, implementing PublicationContainer 
     * @param index Index of the Publication object in the PublicationContainer object
     * @return true or false
     * @throws PublicationContainerException
     */
    @Override
    public boolean matches(PublicationContainer books, int index)
            throws PublicationContainerException {
        return books.get(index).getPagesNumber() == this.pagesNumber;
    }

}
