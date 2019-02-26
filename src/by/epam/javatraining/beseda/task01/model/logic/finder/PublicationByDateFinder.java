package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 * Class contains methods for finding Publication objects by year field
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationByDateFinder {

    /**
     * Method for finding the oldest Publication object
     *
     * @param books - Input BookShelf object
     * @return Publication with the minimum value year
     */
    public static Publication findOldest(BookShelf books) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0) {
            int tempYear;
            double days;
            double tempDays;
            foundPublication = books.get(0);
            tempYear = books.get(0).getYear();
            days = foundPublication.getDays();

            for (int i = 1; i < books.getSize(); i++) {
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
     * @param books - Input BookShelf object
     * @return Publication with the maximum value of year
     */
    public static Publication findNewest(BookShelf books) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0) {
            int year;
            double days;
            double tempDays;
            year = books.get(0).getYear();
            foundPublication = books.get(0);
            days = foundPublication.getDays();
            for (int i = 1; i < books.getSize(); i++) {
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

    /**
     * Method for finding the Publication objects by the year field of specific
     * value
     *
     * @param books - Input BookShelf object
     * @param year - the value of year field
     * @return ArrayList of Publication objects, corresponding the specific
     * value
     */
    public static ArrayList<Publication> findByYear(BookShelf books, int year) {
        ArrayList<Publication> list = new ArrayList<>();
        if (books != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getYear() == year) {
                    list.add(books.get(i));
                }
            }
        }
        return list;
    }
}
