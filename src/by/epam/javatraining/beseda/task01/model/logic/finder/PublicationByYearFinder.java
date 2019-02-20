package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationByYearFinder {

    public static Publication findOldest(BookShelf books) {
        if (books != null && books.getSize() != 0) {
            int tempYear;
            int index = 0;
            tempYear = books.get(index).getYear();
            for (int i = 1; i < books.getSize(); i++) {
                if (books.get(i).getYear() < tempYear) {
                    tempYear = books.get(i).getYear();
                    index = i;
                }
            }
            return books.get(index);
        }
        return null;
    }

    public static Publication findNewest(BookShelf books) {
        if (books != null && books.getSize() != 0) {
            int tempYear;
            int index = 0;
            tempYear = books.get(index).getYear();
            for (int i = 1; i < books.getSize(); i++) {
                if (books.get(i).getYear() > tempYear) {
                    tempYear = books.get(i).getYear();
                    index = i;
                }
            }
            return books.get(index);
        }
        return null;
    }

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
