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
public class MultivolumeTotalNumberOfPagesCalculator {

    /**
     * Method for finding the total number of pages of the NonPeriodical object
     * in the BookShelf object
     *
     * @param books - Input BookShelf object
     * @param name - Publication name
     * @return the total number of pages
     */
    public static int calculate(BookShelf books, String name) {
        int pages = 0;
        if (books != null && name != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getName().contains(name)
                        && (books.get(i) instanceof NonPeriodical)) {
                    NonPeriodical temp = (NonPeriodical) books.get(i);
                    pages += temp.getNumberOfPages();
                    if (!temp.isMultivolume()) {
                        break;
                    }
                }
            }
        }
        return pages;
    }
}
