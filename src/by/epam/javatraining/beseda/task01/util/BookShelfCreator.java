package by.epam.javatraining.beseda.task01.util;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;

/**
 *
 * @author Beseda
 * @version 1.0 20.02.2019
 */
public class BookShelfCreator {

    public static BookShelf createBookShelf(int size) {
        if (size > 0) {
            return new BookShelf(size);
        } else {
            return null;
        }
    }

    public static void fillBookShelf(BookShelf shelf) {
        if (shelf != null) {
            shelf.add(new FictionLiterature("historical novel", "Victor Hugo", 
                    "Les Miserables", 2013, 1221));
            shelf.add(new FictionLiterature("historical fiction", 
                    "F.Scott Fitzgerald", "The Great Gatsby", 2016, 198));
            shelf.add(new FictionLiterature("science fiction", "Ray Bradbury", 
                    "Fahrenheit 451", 2004, 208));
            shelf.add(new FictionLiterature("dark fantasy", "Stephen King", 
                    "The Dark Tower ", 5, 1, 2003, 336));
            shelf.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz", 
                    "", "Mandarin Chinese ", 2007, 671));
            shelf.add(new Manuale("Paulina Christensen, Wendy Foster, Anne Fox", 
                    "German for dummies", 2000, 384, "linguistics", Manuale.Category.BEGINNER));
            shelf.add(new Manuale("Mark Frary, Stephen Pincock", 
                    "The Origins of the Universe for Dummies", 2012, 350, 
                    "astronomy", Manuale.Category.ANY));
            shelf.add(new Manuale("Ron White", "How Computers Work", 2007, 464, 
                    "information technology", Manuale.Category.BEGINNER));
            shelf.add(new Magazine("National Geographic", 2019, 3, 170, 
                    Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
            shelf.add(new Magazine("Digital Slr Photography", 2019, 1, 153, 
                    Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        }
    }

}
