package by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter;

import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * Functional interface containing method getValue used in ExtremeValueFinder
 * class findMin and findMax methods
 *
 * @see ExtremeValuePublicationFinder.class
 * @author Beseda
 * @version 1.0 16/03/2019
 */
public interface FieldValue {


    /**
     * Abstract method for getting the concrete field value of Publication object
     *
     * @param book Input Publication object
     * @return true or false
     */
    int getValue(Publication book);
}
