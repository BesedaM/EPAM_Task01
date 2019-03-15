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
public class CertainName implements CertainValue {

    private String name;

    /**
     * Constructor receiving the certain parameter, which the user is going to
     * find
     *
     * @param name Name of the Publication
     */
    public CertainName(String name) {
        if (name != null && name.length() > 2) {
            this.name = name;
        }
    }

    /**
     * Method for finding the Publication object by it's name
     *
     * @param books Input PublicationContainer object
     * @param index Index of the Publication object in the PublicationContainer
     * @return true or false
     * @throws WrongIndexException
     */
    @Override
    public boolean match(PublicationContainer books, int index)
            throws WrongIndexException {
        return this.name != null && 
                books.get(index).getName().contains((this.name));
    }

}