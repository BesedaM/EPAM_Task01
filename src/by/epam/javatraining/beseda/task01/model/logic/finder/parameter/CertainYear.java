package by.epam.javatraining.beseda.task01.model.logic.finder.parameter;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Class, implementing CertainValue interface
 *
 * @see CertainValueFinder.class
 * @author Beseda
 * @version 1.0 09/03/2019
 */
public class CertainYear implements CertainValue {

    private int year;

    /**
     * Constructor receiving the certain parameter, which the user is going to
     * find
     * 
     * @param year Year of publication of Publication
     */
    public CertainYear(int year) {
        if (year > 0) {
            this.year = year;
        }
    }

    /**
     * Method for finding the Publication object by the year of it's publication
     *
     * @param books Input PublicationContainer object
     * @param index Index of the Publication object in the PublicationContainer
     * @return true or false
     * @throws WrongIndexException
     */
    @Override
    public boolean match(PublicationContainer books, int index)
            throws WrongIndexException {
        return books.get(index).getYear() == this.year;
    }

}
