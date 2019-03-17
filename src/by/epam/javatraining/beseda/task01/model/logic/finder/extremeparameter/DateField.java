package by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter;

import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * Class, implementing ExtremeValue interface
 *
 * @see ExtremeValueFinder.class
 * @author Beseda
 * @version 1.0 16/03/2019
 */
public class DateField implements FieldValue {

    @Override
    public int getValue(Publication book) {
        return (int)(book.getYear() * 1000 + book.getDays());
    }

}
