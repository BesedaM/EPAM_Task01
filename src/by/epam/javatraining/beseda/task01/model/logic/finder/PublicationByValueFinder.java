package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 * This class is an attempt to unify several finders for finding the Publication
 * object in BookShelf container with field of certain value
 *
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationByValueFinder {

    /**
     * Inner functional interface containing method satisfy
     *
     * @param books - input BookShelf object
     * @param index - index of element in BookShelf container class
     */
    interface Condition {

        boolean satisfy(BookShelf books, int index, Object obj);

    }

    public final Condition YEAR = (books, index, year)
            -> (books.get(index).getYear() == (Integer) year);

    public final Condition NUMBER_OF_PAGES = (books, index, numberOfPages)
            -> (books.get(index).getNumberOfPages() == (Integer) numberOfPages);

    public final Condition NAME = (books, index, name)
            -> (books.get(index).getClass().getSimpleName().equals(name));

    /**
     * Method for finding the certain value by the certain condition
     *
     * @param books - input BookShelf object
     * @param condition - implementation of functional interface Condition
     * @param obj - object encapsulating the certain value
     * @return list of Publications satisfying the given condition
     */
    public static ArrayList<Publication> findByValue(BookShelf books,
            Condition condition, Object obj) {
        ArrayList<Publication> list = new ArrayList<>();
        if (books != null && condition != null && obj != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (condition.satisfy(books, i, obj)) {
                    list.add(books.get(i));
                }
            }
        }
        return list;
    }

}
