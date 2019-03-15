package by.epam.javatraining.beseda.task01.model.logic.sorter;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.sorter.parameter.Sortable;

/**
 * The aim of this class is to give the possibility to user to sort the
 * PublicationContainer object by different conditions
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class Sorter {

    /**
     * Algorithm, applying <code>Sorter</code> interface implementation for
     * sorting
     *
     * @param books Input PublicationContainer object;
     * @param sorter Object, implementing the Sorter interface, can be in the
     * next predefined values:
     * <ul>
     * <li><code>ClassNameSorter</code></li>
     * <li><code>PagesNumberSorter</code></li>
     * <li><code>DateSorter</code></li>
     * <li><code>NameSorter</code></li>
     * </ul>
     * @throws WrongIndexException
     */
    public static void sort(PublicationContainer books, Sortable sorter)
            throws WrongIndexException {
        if (books != null && sorter != null && books.publicationsNumber() > 1) {
            int length = books.publicationsNumber();

            sortPart(books, sorter, 0, length - 1);
        }
    }

    /**
     * Method for sorting apart Periodical and NonPeriodical publications
     *
     * @param books Input PublicationContainer object;
     * @param sorter Object, implementing the Sorter interface, can be in the
     * next predefined values:
     * <ul>
     * <li><code>ClassNameSorter</code></li>
     * <li><code>PagesNumberSorter</code></li>
     * <li><code>DateSorter</code></li>
     * <li><code>NameSorter</code></li>
     * </ul>
     * When <code>sorter</code> is null the container will be divided into two
     * parts without any sorting
     * @throws WrongIndexException
     */
    public static void sortApartPeriodicalAndNonPeriodical(PublicationContainer books,
            Sortable sorter) throws WrongIndexException {
        if (books != null && books.publicationsNumber() > 1) {

            dividePeriodicalFromNonPeriodical(books);
            int length = books.publicationsNumber();
            int nonPeriodicalPartLength = books.nonPeriodicalNumber();

            sortPart(books, sorter, 0, nonPeriodicalPartLength - 1);
            sortPart(books, sorter, nonPeriodicalPartLength, length - 1);
        }
    }

    /**
     * Private method for dividing PublicationContainer into two parts:
     * Periodical and NonPeriodical
     *
     * @param books Input PublicationContainer object
     * @throws WrongIndexException
     */
    private static void dividePeriodicalFromNonPeriodical(PublicationContainer books)
            throws WrongIndexException {
        int length = books.publicationsNumber();
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
     * Method for sorting part of the PublicationContainer object
     *
     * @param books Input PublicationContainer object
     * @param sorter Object, implementing the Sorter interface, can be in the
     * next predefined values:
     * <ul>
     * <li><code>ClassNameSorter</code></li>
     * <li><code>PagesNumberSorter</code></li>
     * <li><code>DateSorter</code></li>
     * <li><code>NameSorter</code></li>
     * </ul>
     * @param start Index of first element to start sort with
     * @param end Index of the last element to sort
     * @throws WrongIndexException
     */
    private static void sortPart(PublicationContainer books, Sortable sorter,
            int start, int end) throws WrongIndexException {
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
