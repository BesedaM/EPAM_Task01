package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Class for finding Publication object in PublicationContainer with minimum and
 * maximum number of pages
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class MinMaxPagesNumberFinder {

    /**
     * Finds Publication object with minimum number of pages in
     * PublicationContainer
     *
     * @param books Input PublicationContainer object
     * @return Publication with minimum number of pages in PublicationContainer
     * @throws WrongIndexException
     */
    public static Publication findMin(PublicationContainer books)
            throws WrongIndexException {
        Publication foundPublication = null;
        if (books != null && books.publicationsNumber() != 0) {
            foundPublication = books.get(0);
            int min = foundPublication.getPagesNumber();
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (books.get(i).getPagesNumber() < min) {
                    foundPublication = books.get(i);
                    min = foundPublication.getPagesNumber();

                }
            }
        }
        return foundPublication;
    }

    /**
     * Finds Publication object with maximum number of pages in
     * PublicationContainer
     *
     * @param books Input PublicationContainer object
     * @return Publication object with maximum number of pages in
     * PublicationContainer
     * @throws WrongIndexException
     */
    public static Publication findMax(PublicationContainer books)
            throws WrongIndexException {
        Publication foundPublication = null;
        if (books != null && books.publicationsNumber() != 0) {
            foundPublication = books.get(0);
            int max = foundPublication.getPagesNumber();
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (books.get(i).getPagesNumber() > max) {
                    foundPublication = books.get(i);
                    max = foundPublication.getPagesNumber();
                }
            }
        }
        return foundPublication;
    }

}
