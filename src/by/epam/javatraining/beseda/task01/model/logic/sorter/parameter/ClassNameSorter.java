package by.epam.javatraining.beseda.task01.model.logic.sorter.parameter;

import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

/**
 * Class, implementing Sortable interface
 *
 * @see Sorter.class
 * @see Sortable interface
 * @author Beseda
 * @version 1.0 08/03/2019
 */
public class ClassNameSorter implements Sortable {

    /**
     * Method comparing two Publication objects in PublicationContainer object by their
     * class names
     *
     * @param books Input object, implementing PublicationContainerInterface 
     * @param index Index of current Publication
     * @return true or false
     * @throws PublicationContainerException
     */
    @Override
    public boolean compare(PublicationContainer books, int index)
            throws PublicationContainerException {
        return books.get(index - 1).getClass().getSimpleName()
                .compareTo(books.get(index).getClass().getSimpleName()) > 0;
    }

}
