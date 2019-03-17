package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter.ConcreteValue;
import java.util.ArrayList;
import java.util.List;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;

/**
 * Finds the Publication object in PublicationContainer container by the
 * specific field of specific value
 *
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class ConcreteValuePublicationFinder {

    /**
     * Method for finding Publication objects by the specific condition
     *
     * @param books Input object, implementing PublicationContainer
     * @param value Object, encapsulating the certain value, implementing the
     * ConcreteValue interface, can be in the next predefined classes:
     * <ul>
     * <li><code>ConcreteClassName(value)</code></li>
     * <li><code>ConcreteName(value)</code></li>
     * <li><code>ConcreteYear(value)</code></li>
     * <li><code>ConcreteNumberOfPages(value)</code></li>
     * </ul>
     * @return list of Publications satisfying the given condition
     * @throws PublicationContainerException
     */
    public static List<Publication> find(PublicationContainer books,
            ConcreteValue value) throws PublicationContainerException {
        ArrayList<Publication> list = new ArrayList<>();
        if (books != null && value != null && books.publicationsNumber() > 0) {
            for (int i = 0; i < books.publicationsNumber(); i++) {
                if (value.matches(books, i)) {
                    list.add(books.get(i));
                }
            }
        }
        return list;
    }

}
