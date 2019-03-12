package by.epam.javatraining.beseda.task01.model.logic.sorter.sortable;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Class, implementing Sortable interface
 *
 * @see Sorter.class
 * @see Sortable interface
 * @author Beseda
 * @version 1.0 08/03/2019
 */
public class DateSorter implements Sortable {

    /**
     * Comparing two Publication objects in PublicationContainer object by the
     * dates of the publication
     *
     * @param books PublicationContainer object
     * @param index Index of current Publication
     * @return true or false
     * @throws WrongIndexException
     */
    @Override
    public boolean compare(PublicationContainer books, int index)
            throws WrongIndexException {
        return books.get(index - 1).getYear() > books.get(index).getYear()
                || books.get(index - 1).getYear() == books.get(index).getYear()
                && books.get(index - 1).getDays() > books.get(index).getDays();
    }

}
