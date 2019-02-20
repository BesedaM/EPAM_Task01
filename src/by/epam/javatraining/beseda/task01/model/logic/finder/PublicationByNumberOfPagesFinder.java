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
        if (books != null && books.getSize() != 0) {
            int min;
            int index = 0;
            min = books.get(index).getNumberOfPages();
            for (int i = 1; i < books.getSize(); i++) {
                if (books.get(i).getNumberOfPages() < min) {
                    min = books.get(i).getNumberOfPages();
                    index = i;
                }
            }
            return books.get(index);
        }
        return null;
    }

    public static Publication findMax(BookShelf books) {
        if (books != null && books.getSize() != 0) {
            int max;
            int index = 0;
            max = books.get(index).getNumberOfPages();
            for (int i = 1; i < books.getSize(); i++) {
                if (books.get(i).getNumberOfPages() > max) {
                    max = books.get(i).getNumberOfPages();
                    index = i;
                }
            }
            return books.get(index);
        }
        return null;
    }

}
