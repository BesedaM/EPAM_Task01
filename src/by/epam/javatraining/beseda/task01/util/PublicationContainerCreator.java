package by.epam.javatraining.beseda.task01.util;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.container.AbstractPublicationContainer;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.container.HomeLibrary;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;

/**
 * Utility class for creating and filling the PublicationContainer object with
 * some Publications
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class PublicationContainerCreator {

    public enum Type {
        BOOKSHELF, HOME_LIBRARY
    }

    /**
     * Method for creating a new PublicationContainer object of specific size
     *
     * @param size Maximum number of Publications you can put in
     * PublicationContainer
     * @param type Type of PublicationContainer, must be in:
     * <ul>
     * <li><code>BOOKSHELF</code></li>
     * <li><code>HOME_LIBRARY</code></li>
     * </ul>
     * @return PublicationContainer object of specific size
     */
    public static AbstractPublicationContainer 
        createPublicationContainer(int size, Type type) {
        AbstractPublicationContainer container = null;
        if (size > 0 && type != null) {
            if (type == Type.BOOKSHELF) {
                container = new BookShelf(size);
            } else if (type == Type.HOME_LIBRARY) {
                container = new HomeLibrary(size);
            }
        }
        return container;
    }

    /**
     * Method for filling the container PublicationContainer object with some
     * Publications
     *
     * @param books - Input PublicationContainer object
     * @throws PublicationContainerException
     */
    public static void fillPublicationContainer(AbstractPublicationContainer books) 
            throws PublicationContainerException {
        if (books != null) {
            books.add(new FictionLiterature("historical novel", "Victor Hugo",
                    "Les Miserables", 2013, 1221));
            books.add(new FictionLiterature("historical fiction",
                    "F.Scott Fitzgerald", "The Great Gatsby", 2016, 198));
            books.add(new FictionLiterature("science fiction", "Ray Bradbury",
                    "Fahrenheit 451", 2004, 208));
            books.add(new Magazine("National Geographic", 2018, 2, 158,
                    Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
            books.add(new FictionLiterature("dark fantasy", "Stephen King",
                    "The Dark Tower", 5, 1, 2003, 336));
            books.add(new FictionLiterature("dark fantasy", "Stephen King",
                    "The Dark Tower", 5, 2, 2006, 496));
            books.add(new FictionLiterature("dark fantasy", "Stephen King",
                    "The Dark Tower", 5, 3, 2012, 670));
            books.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz",
                    "", "Mandarin Chinese ", 2007, 671));
            books.add(new Magazine("National Geographic", 2018, 12, 165,
                    Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
            books.add(new Magazine("Psychologies", 2019, 3, 132,
                    Periodical.Audience.ADULTS, Magazine.Periodicity.MONTHLY));
            books.add(new Manuale("Paulina Christensen, Wendy Foster, Anne Fox",
                    "German for dummies", 2000, 384, "linguistics",
                    Manuale.Audience.BEGINNER));
            books.add(new Manuale("Mark Frary, Stephen Pincock",
                    "The Origins of the Universe for Dummies", 2012, 350,
                    "astronomy", Manuale.Audience.ANY));
            books.add(new Manuale("Ron White", "How Computers Work", 2007, 464,
                    "information technology", Manuale.Audience.BEGINNER));
            books.add(new Magazine("National Geographic", 2019, 3, 170,
                    Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
            books.add(new Magazine("Digital Photography", 2019, 1, 153,
                    Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        }
    }

}
