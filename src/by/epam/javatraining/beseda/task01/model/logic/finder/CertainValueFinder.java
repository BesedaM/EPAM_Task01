package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter.CertainValue;
import java.util.ArrayList;
import java.util.List;

/**
 * Finds the Publication object in PublicationContainer container by the
 * specific field of specific value
 *
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class CertainValueFinder {

    /**
     * Method for finding the specific value by the specific condition
     *
     * @param books Input PublicationContainer object
     * @param value Object, encapsulating the certain value, implementing the
     * CertainValue interface, can be in the next predefined classes:
     * <ul>
     * <li><code>ClassName(value)</code></li>
     * <li><code>Name(value)</code></li>
     * <li><code>Year(value)</code></li>
     * <li><code>NumberOfPages(value)</code></li>
     * </ul>
     * @return list of Publications satisfying the given condition
     * @throws WrongIndexException
     */
    public static List<Publication> find(PublicationContainer books,
            CertainValue value) throws WrongIndexException {
        ArrayList<Publication> list = new ArrayList<>();
        if (books != null && value != null) {
            for (int i = 0; i < books.publicationsNumber(); i++) {
                if (value.match(books, i)) {
                    list.add(books.get(i));
                }
            }
        }
        return list;
    }

}
