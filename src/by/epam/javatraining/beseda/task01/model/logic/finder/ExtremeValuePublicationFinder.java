package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.NullPublication;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter.FieldValue;

/**
 * Finds the Publication object in PublicationContainer container by the
 * specific field of specific value
 *
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class ExtremeValuePublicationFinder {

    /**
     * Finds Publication object with minimum specific value in
     * PublicationContainer
     *
     * @param books Input object, implementing PublicationContainer
     * @param field Object, encapsulating the certain field, implementing the
     * FieldValue interface, can be in the next predefined classes:
     * <ul>
     * <li><code>DateField</code></li>
     * <li><code>PagesNumberField</code></li>
     * <li><code>YearField</code></li>
     * </ul>
     * @return Publication object with minimum minimum specific value in
     * PublicationContainer
     * @throws PublicationContainerException
     */
    public static Publication findMin(PublicationContainer books, FieldValue field)
            throws PublicationContainerException {
        Publication foundPublication = new NullPublication();
        if (books != null && field != null && books.publicationsNumber() > 0) {
            foundPublication = books.get(0);
            int min = field.getValue(foundPublication);
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (field.getValue(books.get(i)) < min) {
                    foundPublication = books.get(i);
                    min = field.getValue(books.get(i));
                }
            }
        }
        return foundPublication;
    }

    /**
     * Finds Publication object with maximum number of pages in
     * PublicationContainer
     *
     * @param books Input object, implementing PublicationContainer
     * @param field Object, encapsulating the certain field, implementing the
     * FieldValue interface, can be in the next predefined classes:
     * <ul>
     * <li><code>DateField</code></li>
     * <li><code>PagesNumberField</code></li>
     * <li><code>YearField</code></li>
     * </ul>
     * @return Publication object with maximum number of pages in
     * PublicationContainer
     * @throws PublicationContainerException
     */
    public static Publication findMax(PublicationContainer books, FieldValue field)
            throws PublicationContainerException {
        Publication foundPublication = new NullPublication();
        if (books != null && field != null && books.publicationsNumber() > 0) {
            foundPublication = books.get(0);
            int max = field.getValue(foundPublication);
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (field.getValue(books.get(i)) > max) {
                    foundPublication = books.get(i);
                    max = field.getValue(foundPublication);
                }
            }
        }
        return foundPublication;
    }

}
