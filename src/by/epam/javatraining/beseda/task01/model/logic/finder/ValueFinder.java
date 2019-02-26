package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 * This class represents a finder for Publication object in BookShelf container
 * by the specific field of specific value
 *
 * But I'm still not sure whether I should do it
 *
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class ValueFinder {

    /**
     * Inner functional interface containing method satisfy
     */
    public interface Condition {

        boolean satisfy(BookShelf books, int index, Object obj);

    }

    public static final Condition CLASS_NAME = (books, index, className)
            -> (books.get(index).getClass().getSimpleName().toLowerCase()
                    .contains(((String) className).toLowerCase()));

    public static final Condition NAME = (books, index, name)
            -> (books.get(index).getName().equals(name));

    public final Condition YEAR = (books, index, year)
            -> (books.get(index).getYear() == (Integer) year);

    public static final Condition NUMBER_OF_PAGES = (books, index, numberOfPages)
            -> (books.get(index).getNumberOfPages() == (Integer) numberOfPages);

    /**
     * Method for finding the specific value by the specific condition
     *
     * @param books Input BookShelf object
     * @param condition Parameter of searching, must be in the next predefined
     * values:
     * <ul>
     * <li><code>CLASS_NAME</code></li>
     * <li><code>NAME</code></li>
     * <li><code>YEAR</code></li>
     * <li><code>NUMBER_OF_PAGES</code></li>
     * </ul>
     * @param obj Object encapsulating the specific value
     * @return list of Publications satisfying the given condition
     */
    public static ArrayList<Publication> find(BookShelf books,
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
