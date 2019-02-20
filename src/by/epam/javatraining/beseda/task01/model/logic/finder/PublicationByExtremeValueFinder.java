package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * This class is an attempt to unify several finders for finding the Publication
 * object in BookShelf with certain field of extreme value. The value type is
 * specified with Supplier interface
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationByExtremeValueFinder {

    /**
     * Inner functional interface containing method get
     *
     * @param books - input BookShelf object
     * @param index - index of element in BookShelf container class
     */
    interface Supplier {

        double get(BookShelf books, int index);

    }

    //some predefined values
    public final Supplier YEAR = (books, i) -> (books.get(i).getYear());

    public final Supplier NUMBER_OF_PAGES = (books, i) -> (books.get(i).getNumberOfPages());

    /**
     * Method for finding the Publication with minimum value of parameter
     *
     * @param books - input BookShelf object
     * @param parameter - type of value, defined with inner Supplier interface
     * @return Publication object, satisfying the certain condition
     */
    public static Publication findMin(BookShelf books, Supplier parameter) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0 && parameter != null) {
            int tempYear;
            tempYear = (int) parameter.get(books, 0);
            for (int i = 1; i < books.getSize(); i++) {
                if ((int) parameter.get(books, i) < tempYear) {
                    tempYear = (int) parameter.get(books, i);
                    foundPublication = books.get(i);
                }
            }
        }
        return foundPublication;
    }

    /**
     * Method for finding the Publication with maximum value of parameter
     *
     * @param books - input BookShelf object
     * @param parameter - type of value, defined with inner Supplier interface
     * @return Publication object, satisfying the certain condition
     */
    public static Publication findMax(BookShelf books, Supplier parameter) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0 && parameter != null) {
            int tempYear;
            tempYear = (int) parameter.get(books, 0);
            for (int i = 1; i < books.getSize(); i++) {
                if ((int) parameter.get(books, i) > tempYear) {
                    tempYear = (int) parameter.get(books, i);
                    foundPublication = books.get(i);
                }
            }
        }
        return foundPublication;
    }
}
