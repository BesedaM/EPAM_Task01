package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;

/**
 * Class for finding the Publications by the specific class name
 *
 * @author Beseda
 * @version 1.1 23/02/2019
 */
public class PublicationByClassNameFinder {

    /**
     * Method returns the list of publications of the specific class
     *
     * @param books - Input BookShelf object
     * @param className - short string representation of class name
     * @return list, containing all the found publications
     */
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
