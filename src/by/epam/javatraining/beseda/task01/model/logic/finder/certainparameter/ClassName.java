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
public class ClassName implements CertainValue {

    private String className;

    /**
     * Constructor receiving the certain parameter, which the user is going to
     * find
     *
     * @param className Short string representation of class name
     */
    public ClassName(String className) {
        if (className != null) {
            this.className = className;
        } else {
            this.className = "";
        }
    }

    /**
     * Method for finding out whether the Publication object in
     * PublicationContainer derived the certain class
     *
     * @param books Input PublicationContainer object
     * @param index Index of the Publication object in the PublicationContainer
     * @return true or false
     * @throws WrongIndexException
     */
    @Override
    public boolean match(PublicationContainer books, int index)
            throws WrongIndexException {
        return books.get(index).getClass().getSimpleName().toLowerCase()
                .contains((this.className).toLowerCase());
    }

}
