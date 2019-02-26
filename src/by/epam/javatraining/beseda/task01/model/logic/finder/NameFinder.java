package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 * Class for finding the Publication by it's name or part of name
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class NameFinder {

    /**
     * Finds all the Publications with the specified name
     *
     * @param books Input BookShelf object
     * @param name Name or part of name of the publication
     * @return list object containing Publications with such a name or part a of
     * name
     */
    public static ArrayList<Publication> find(BookShelf books, String name) {
        ArrayList<Publication> list = new ArrayList();
        if (books != null && name != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                    list.add(books.get(i));
                }
            }
        }
        return list;
    }
}
