package by.epam.javatraining.beseda.task01.model.logic.calculator;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;

/**
 * Class containing method for finding the total number of pages of
 * non-periodical publication, specified by name in the BookShelf object
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class NumberOfPagesCalculator {

    /**
     * Method for finding the total number of pages of the NonPeriodical
     * multivolume object in the BookShelf object
     *
     * @param books Input BookShelf object
     * @param name Multivolume Publication name
     * @return the total number of pages
     */
    public static int calculateMultivolume(BookShelf books, String name) {
        int pages = 0;
        if (books != null && name != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getName().contains(name)
                        && (books.get(i) instanceof NonPeriodical)
                        && ((NonPeriodical) books.get(i)).isMultivolume()) {
                    NonPeriodical temp = (NonPeriodical) books.get(i);
                    pages += temp.getNumberOfPages();
                }
            }
        }
        return pages;
    }
}
