package by.epam.javatraining.beseda.task01.model.logic.sorter;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * The aim of this class is to give the possibility to user to sort the
 * BookShelf object by different conditions
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class Sorter {

    /**
     * Inner functional interface containing method compare
     */
    public interface Sortable {

        /**
         * Abstract method for comparing two Publication objects
         *
         * @param books - Input BookShelf object
         * @param index - index of the Publication object in the BookShelf
         * container
         * @return true or false
         */
        boolean compare(BookShelf books, int index);
    }

    //Interface Sortable implementations for use
    public static final Sortable CLASS_NAME_SORTER = (books, j)
            -> (books.get(j - 1).getClass().getSimpleName()
                    .compareTo(books.get(j).getClass().getSimpleName()) > 0);

    public static final Sortable NUMBER_OF_PAGES_SORTER = (books, j)
            -> (books.get(j - 1).getNumberOfPages() > books.get(j).getNumberOfPages());

    public static final Sortable YEAR_SORTER = (books, j) -> (books.get(j - 1).getYear()
            > books.get(j).getYear());

    public static final Sortable NAME_SORTER = (books, j)
            -> (books.get(j - 1).getName().compareTo(books.get(j).getName()) > 0);

    public static final Sortable ORDER_OF_APPEARENCE_SORTER = (books, j)
            -> (books.get(j - 1).getID() < books.get(j).getID());

    /**
     * Algorithm of sorting, using <code>Sorter</code> interface implementation
     *
     * @param books - input BookShelf object;
     * @param sorter - functional interface Sortable implementation, must be in
     * the next predefined values:
     * <ul>
     * <li><code>CLASS_NAME_SORTER</code></li>
     * <li><code>NUMBER_OF_PAGES_SORTER</code></li>
     * <li><code>YEAR_SORTER</code></li>
     * <li><code>NAME_SORTER</code></li>
     * <li><code>ORDER_OF_APPEARENCE_SORTER</code></li>
     * </ul>
     */
    public static void sort(BookShelf books, Sortable sorter) {
        if (books != null && sorter != null && books.getSize() > 1) {
            int length = books.getSize();

            sortPart(books, sorter, 0, length - 1);
        }
    }

    /**
     * Method for sorting apart Periodical and NonPeriodical publications using
     *
     * @param books - Input BookShelf object;
     * @param sorter - functional interface Sortable implementation, must be in
     * the next predefined values:
     * <ul>
     * <li><code>CLASS_NAME_SORTER</code></li>
     * <li><code>NUMBER_OF_PAGES_SORTER</code></li>
     * <li><code>YEAR_SORTER</code></li>
     * <li><code>NAME_SORTER</code></li>
     * <li><code>ORDER_OF_APPEARENCE_SORTER</code></li>
     * </ul>
     * When <code>sorter</code> is null the container will be divided into two
     * parts, remaining the random data
     */
    public static void sortApartPeriodicalAndNonPeriodical(BookShelf books,
            Sortable sorter) {
        if (books != null && books.getSize() > 1) {

            dividePeriodicalFromNonPeriodical(books);
            int length = books.getSize();
            int nonPeriodicalPartLength = books.getNumberOfNonPeriodical();

            sortPart(books, sorter, 0, nonPeriodicalPartLength - 1);
            sortPart(books, sorter, nonPeriodicalPartLength, length - 1);
        }
    }

    /**
     * Private method for dividing in BookShelf Periodical publications from
     * NonPeriodical
     *
     * @param books - Input BookShelf object
     */
    private static void dividePeriodicalFromNonPeriodical(BookShelf books) {
        int length = books.getSize();
        Publication temp;

        for (int i = 0; i < length; i++) {
            if (books.get(i) instanceof Periodical) {
                for (int j = length - 1; j > i; j--) {
                    if (books.get(j) instanceof NonPeriodical) {
                        temp = books.get(i);
                        books.set(i, books.get(j));
                        books.set(j, temp);
                    }
                }
            }
        }
    }

    /**
     * Method for sorting part of the BookShelf Publications
     *
     * @param books - Input BookShelf object
     * @param sorter - functional interface Sortable implementation, must be in
     * the next predefined values:
     * <ul>
     * <li><code>CLASS_NAME_SORTER</code></li>
     * <li><code>NUMBER_OF_PAGES_SORTER</code></li>
     * <li><code>YEAR_SORTER</code></li>
     * <li><code>NAME_SORTER</code></li>
     * <li><code>ORDER_OF_APPEARENCE_SORTER</code></li>
     * </ul>
     * @param start - index of first element to start sort with
     * @param end - index of the last element to sort
     */
    private static void sortPart(BookShelf books, Sortable sorter,
            int start, int end) {
        if (sorter != null) {
            Publication temp;
            for (int i = start; i <= end; i++) {
                for (int j = start + 1; j <= end; j++) {
                    if (sorter.compare(books, j)) {
                        temp = books.get(j - 1);
                        books.set(j - 1, books.get(j));
                        books.set(j, temp);
                    }
                }
            }
        }
    }

}
