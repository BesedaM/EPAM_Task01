package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * This class represents a finder for Publication object in BookShelf with
 * specific field of extreme value.
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class ExtremeValueFinder {

    /**
     * Inner functional interface containing method get
     */
    public interface Supplier {

        int get(BookShelf books, int index);

    }

    //some predefined values
    public static final Supplier NUMBER_OF_PAGES = (books, i)
            -> (books.get(i).getNumberOfPages());

    public static final Supplier YEAR = (books, i) -> (books.get(i).getYear());

    /**
     * Method for finding the Publication with minimum value of parameter
     *
     * The value of parameter must be in
     * <ul>
     * <li><code>YEAR</code></li>
     * <li><code>NUMBER_OF_PAGES</code></li>
     * </ul>
     *
     * @param books Input BookShelf object
     * @param parameter Type of value, defined with inner Supplier interface
     *
     * @return Publication object, satisfying the specific condition
     */
    public static Publication findMin(BookShelf books, Supplier parameter) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0 && parameter != null) {
            int temp;
            temp = parameter.get(books, 0);
            foundPublication = books.get(0);
            for (int i = 1; i < books.getSize(); i++) {
                if (parameter.get(books, i) < temp) {
                    temp = parameter.get(books, i);
                    foundPublication = books.get(i);
                }
            }
        }
        return foundPublication;
    }

    /**
     * Method for finding the Publication with maximum value of parameter
     *
     * The value of parameter must be in
     * <ul>
     * <li><code>YEAR</code></li>
     * <li><code>NUMBER_OF_PAGES</code></li>
     * </ul>
     *
     * @param books Input BookShelf object
     * @param parameter Type of value, defined with inner Supplier interface
     * @return Publication object, satisfying the specific condition
     */
    public static Publication findMax(BookShelf books, Supplier parameter) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0 && parameter != null) {
            int temp;
            temp = parameter.get(books, 0);
            foundPublication = books.get(0);
            for (int i = 1; i < books.getSize(); i++) {
                if (parameter.get(books, i) > temp) {
                    temp = parameter.get(books, i);
                    foundPublication = books.get(i);
                }
            }
        }
        return foundPublication;
    }
}
