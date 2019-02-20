package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;

/**
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class NumberOfSpecifiedPublicationsFinder {

    public static int findByName(BookShelf books, String className) {
        int count = 0;
        if (books != null && className != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getClass().getSimpleName().equals(className)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    
}
