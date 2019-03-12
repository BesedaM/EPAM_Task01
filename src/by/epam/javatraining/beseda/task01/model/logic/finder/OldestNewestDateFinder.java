package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;

/**
 * Class contains methods for finding Publication objects by date. For
 * NonPeriodical Publications is accepted that they were published at the
 * beginning of the year
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class OldestNewestDateFinder {

    /**
     * Method for finding the oldest Publication object
     *
     * @param books Input PublicationContainer object
     * @return Publication with the minimum value year
     * @throws WrongIndexException
     */
    public static Publication findOldest(PublicationContainer books)
            throws WrongIndexException {
        Publication foundPublication = null;
        if (books != null && books.publicationsNumber() != 0) {
            int tempYear;
            double days;
            double tempDays;
            foundPublication = books.get(0);
            tempYear = books.get(0).getYear();
            days = foundPublication.getDays();

            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (books.get(i).getYear() < tempYear) {
                    tempYear = books.get(i).getYear();
                    foundPublication = books.get(i);
                    days = foundPublication.getDays();
                } else if (books.get(i).getYear() == tempYear
                        && books.get(i) instanceof Periodical) {
                    tempDays = foundPublication.getDays();
                    if (tempDays < days) {
                        tempYear = books.get(i).getYear();
                        foundPublication = books.get(i);
                        days = tempDays;
                    }
                }
            }
        }
        return foundPublication;
    }

    /**
     * Method for finding the newest Publication object
     *
     * @param books Input PublicationContainer object
     * @return Publication with the maximum value of year
     * @throws WrongIndexException
     */
    public static Publication findNewest(PublicationContainer books)
            throws WrongIndexException {
        Publication foundPublication = null;
        if (books != null && books.publicationsNumber() != 0) {
            int year;
            double days;
            double tempDays;
            year = books.get(0).getYear();
            foundPublication = books.get(0);
            days = foundPublication.getDays();
            for (int i = 1; i < books.publicationsNumber(); i++) {
                if (books.get(i).getYear() > year) {
                    year = books.get(i).getYear();
                    foundPublication = books.get(i);
                    days = foundPublication.getDays();
                } else if (books.get(i).getYear() == year
                        && books.get(i) instanceof Periodical
                        && (tempDays = foundPublication.getDays()) > days) {
                    year = books.get(i).getYear();
                    foundPublication = books.get(i);
                    days = tempDays;
                }
            }
        }
        return foundPublication;
    }
}
