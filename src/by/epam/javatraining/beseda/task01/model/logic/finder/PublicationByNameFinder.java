package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationByNameFinder {

    public static ArrayList<Publication> find(BookShelf books, String className) {
        ArrayList<Publication> list = new ArrayList();
        if (books != null && className != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getClass().getSimpleName().equals(className)) {
                    list.add(books.get(i));
                }
            }
        }
        return list;
    }

    
}
