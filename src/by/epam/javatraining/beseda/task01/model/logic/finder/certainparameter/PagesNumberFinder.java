package by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Class, implementing CertainValue interface
 *
 * @see CertainValueFinder.class
 * @author Beseda
 * @version 1.0 09/03/2019
 */
public class PagesNumberFinder implements CertainValue {

    private int pagesNumber;

    /**
     * Constructor receiving the certain parameter, which the user is going to
     * find
     * 
     * @param pagesNumber Number of pages in the Publication
     */
    public PagesNumberFinder(int pagesNumber) {
        if (pagesNumber > 0) {
            this.pagesNumber = pagesNumber;
        }
    }

    /**
     * Method for finding the Publication object by it's number of pages
     *
     * @param books Input PublicationContainer object
     * @param index Index of the Publication object in the PublicationContainer
     * @return true or false
     * @throws WrongIndexException
     */
    @Override
    public boolean match(PublicationContainer books, int index)
            throws WrongIndexException {
        return books.get(index).getPagesNumber() == this.pagesNumber;
    }

}
