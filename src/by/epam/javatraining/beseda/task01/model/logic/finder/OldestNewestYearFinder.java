package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.finder.parameter.CertainYear;
import java.util.List;

/**
 * Class represents a finder for newest or oldest Publication objects in
 * PublicationContainer by the year field
 *
 * @author Beseda
 * @version 1.1 09/03/2019
 */
public class OldestNewestYearFinder {

    /**
     * Method for finding the Publication with minimum value of parameter
     *
     *
     * @param books Input PublicationContainer object
     * @return List<> object, satisfying the specific condition
     * @throws WrongIndexException
     */
    public static List<Publication> findOldest(PublicationContainer books)
            throws WrongIndexException {
        int minYear = 0;
        if (books != null && books.publicationsNumber() != 0) {
            minYear = books.get(0).getYear();
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (books.get(i).getYear() < minYear) {
                    minYear = books.get(i).getYear();
                }
            }
        }
        return CertainValueFinder.find(books, new CertainYear(minYear));
    }

    /**
     * Method for finding the Publication with maximum value of parameter
     *
     * @param books Input PublicationContainer object
     * @return List<> object, satisfying the specific condition
     * @throws WrongIndexException
     */
    public static List<Publication> findNewest(PublicationContainer books)
            throws WrongIndexException {
        int maxYear = 0;
        if (books != null && books.publicationsNumber() != 0) {
            maxYear = books.get(0).getYear();
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (books.get(i).getYear() > maxYear) {
                    maxYear = books.get(i).getYear();
                }
            }
        }
        return CertainValueFinder.find(books, new CertainYear(maxYear));
    }
}
