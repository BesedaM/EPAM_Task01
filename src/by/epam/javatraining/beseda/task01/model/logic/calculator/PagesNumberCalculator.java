package by.epam.javatraining.beseda.task01.model.logic.calculator;

import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Class containing method for finding the total number of pages of
 * non-periodical publication, specified by name in the BookShelf object
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PagesNumberCalculator {

    /**
     * Method for finding the total number of pages of the NonPeriodical
     * multivolume object in the BookShelf object
     *
     * @param books Input PublicationContainer object
     * @param name Multivolume Publication name
     * @return the total number of pages
     * @throws WrongIndexException
     */
    public static int calculateMultivolume(PublicationContainer books, String name) 
            throws WrongIndexException {
        int pages = 0;
        if (books != null && name != null) {
            for (int i = 0; i < books.publicationsNumber(); i++) {
                if (books.get(i).getName().contains(name)
                        && (books.get(i) instanceof NonPeriodical)
                        && ((NonPeriodical) books.get(i)).isMultivolume()) {
                    NonPeriodical temp = (NonPeriodical) books.get(i);
                    pages += temp.getPagesNumber();
                }
            }
        }
        return pages;
    }
}
