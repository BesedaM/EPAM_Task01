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
public class ConcreteClassName implements ConcreteValue {

    private String className;

    /**
     * Constructor receiving the concrete parameter, which the user is going to
     * find
     *
     * @param className Short string representation of class name
     */
    public ConcreteClassName(String className) {
        if (className != null) {
            this.className = className;
        } else {
            this.className = "";
        }
    }

    /**
     * Method for finding out whether the Publication object in
     * PublicationContainer derived the concrete class
     *
     * @param books Input object, implementing PublicationContainer 
     * @param index Index of the Publication object in the PublicationContainer object
     * @return true or false
     * @throws PublicationContainerException
     */
    @Override
    public boolean matches(PublicationContainer books, int index)
            throws PublicationContainerException {
        return books.get(index).getClass().getSimpleName().toLowerCase()
                .contains((this.className).toLowerCase());
    }

}