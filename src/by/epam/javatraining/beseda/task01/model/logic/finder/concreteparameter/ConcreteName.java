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
public class ConcreteName implements ConcreteValue {

    private String name;

    /**
     * Constructor receiving the concrete parameter, which the user is going to
     * find
     *
     * @param name Name of the Publication
     */
    public ConcreteName(String name) {
        if (name != null && name.length() > 2) {
            this.name = name;
        }
    }

    /**
     * Method for finding the Publication object by it's name
     *
     * @param books Input object, implementing PublicationContainer 
     * @param index Index of the Publication object in the PublicationContainer object
     * @return true or false
     * @throws PublicationContainerException
     */
    @Override
    public boolean matches(PublicationContainer books, int index)
            throws PublicationContainerException {
        return this.name != null && 
                books.get(index).getName().contains((this.name));
    }

}
