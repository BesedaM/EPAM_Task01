package by.epam.javatraining.beseda.task01.model.logic.calculator;

import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

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
     * @param books Input object, implementing PublicationContainer
     * @param name Multivolume Publication name
     * @return the total number of pages
     * @throws WrongIndexException
     */
    public static int calculateMultivolume(PublicationContainer books,
            String name) throws PublicationContainerException {
        int pages = 0;
        NonPeriodical temp;
        if (books != null && name != null && books.publicationsNumber() > 0) {
            for (int i = 0; i < books.publicationsNumber(); i++) {
                if (books.get(i) != null && books.get(i).getName().contains(name)
                        && (books.get(i) instanceof NonPeriodical)
                        && ((NonPeriodical) books.get(i)).isMultivolume()) {
                    temp = (NonPeriodical) books.get(i);
                    pages += temp.getPagesNumber();
                }
            }
        }
        return pages;
    }
}
