package by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter;

import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * Class, implementing FieldValue interface
 *
 * @see ExtremeValueFinder.class
 * @author Beseda
 * @version 1.0 16/03/2019
 */
public class YearField implements FieldValue {

    @Override
    public int getValue(Publication book) {
        return book.getYear();
    }

}
