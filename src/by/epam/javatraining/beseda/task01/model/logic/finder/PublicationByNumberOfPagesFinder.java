package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationByNumberOfPagesFinder {

    public static Publication findMin(BookShelf books) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0) {
            int min;
            min = books.get(0).getNumberOfPages();
            foundPublication = books.get(0);
            for (int i = 1; i < books.getSize(); i++) {
                if (books.get(i).getNumberOfPages() < min) {
                    min = books.get(i).getNumberOfPages();
                    foundPublication = books.get(i);
                }
            }
        }
        return foundPublication;
    }

    public static Publication findMax(BookShelf books) {
        Publication foundPublication = null;
        if (books != null && books.getSize() != 0) {
            int max;
            max = books.get(0).getNumberOfPages();
            foundPublication = books.get(0);
            for (int i = 1; i < books.getSize(); i++) {
                if (books.get(i).getNumberOfPages() > max) {
                    max = books.get(i).getNumberOfPages();
                    foundPublication = books.get(i);
                }
            }
        }
        return foundPublication;
    }

}
