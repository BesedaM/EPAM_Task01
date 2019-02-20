package by.epam.javatraining.beseda.task01.model.logic.sorter;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 * The aim of this class is to give the possibility to user to sort the
 * BookShelf object by different conditions
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class SorterBookShelf {

    /**
     * Inner functional interface containing method compare
     *
     * @param books - input BookShelf object
     * @param index - index of element in BookShelf container class
     */
    interface Sorter {

        boolean compare(BookShelf books, int index);
    }

    //Interface Sorter implementations for use
    public final Sorter CLASS_NAME_SORTER = (books, j)
            -> (books.get(j - 1).getClass().getSimpleName()
                    .compareTo(books.get(j).getClass().getSimpleName()) > 0);

    public final Sorter NUMBER_OF_PAGES_SORTER = (books, j)
            -> (books.get(j - 1).getNumberOfPages() > books.get(j).getNumberOfPages());

    public final Sorter YEAR_SORTER = (books, j) -> (books.get(j - 1).getYear()
            > books.get(j).getYear());

    public final Sorter NAME_SORTER = (books, j)
            -> (books.get(j - 1).getName().compareTo(books.get(j).getName()) > 0);

    public final Sorter BY_ORDER_OF_APPEARENCE_SORTER = (books, j) 
            -> (books.get(j - 1).getID() < books.get(j).getID());

    /**
     * Main Algorithm of sorting, using Sorter implementation
     *
     * @param books - input BookShelf object
     * @param sorter - functional interface implementation
     */
    public static void sort(BookShelf books, Sorter sorter) {
        if (books != null && sorter != null && books.getSize() > 1) {
            int length = books.getSize();
            Publication temp;

            for (int i = 0; i < length - 1; i++) {
                for (int j = 1; j < length - i; j++) {
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
