package by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter;

import by.epam.javatraining.beseda.task01.model.entity.container.AbstractPublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

/**
 * Class, implementing ConcreteValue interface
 *
 * @see ConcreteValueFinder.class
 * @author Beseda
 * @version 1.0 09/03/2019
 */
public class ConcreteYear implements ConcreteValue {

    private int year;

    /**
     * Constructor receiving the concrete parameter, which the user is going to
     * find
     * 
     * @param year Year of publication of Publication
     */
    public ConcreteYear(int year) {
        if (year > 0) {
            this.year = year;
        }
    }

    /**
     * Method for finding the Publication object by the year of it's publication
     *
     * @param books Input object, implementing PublicationContainer 
     * @param index Index of the Publication object in the PublicationContainer object
     * @return true or false
     * @throws PublicationContainerException
     */
    @Override
    public boolean matches(PublicationContainer books, int index)
            throws PublicationContainerException {
        return books.get(index).getYear() == this.year;
    }

}
