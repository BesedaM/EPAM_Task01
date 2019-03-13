package by.epam.javatraining.beseda.task01.model.logic.data;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;
import org.testng.annotations.DataProvider;

/**
 * Class provides data for testing
 *
 * @author Beseda
 * @version 1.0 13/03/2019
 */
public class TestingData {

    @DataProvider(name = "Empty BookShelf")
    public static Object[][] provideData01() {
        BookShelf books = new BookShelf(5);
        return new Object[][]{{books}};
    }

    @DataProvider(name = "BookShelf with data01")
    public static Object[][] provideData02() throws NotEnoughSpaceException {
        BookShelf books = new BookShelf(10);
        books.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        books.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz",
                "", "Mandarin Chinese", 2007, 671));
        books.add(new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208));
        books.add(new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        books.add(new Manuale("Mark Frary, Stephen Pincock",
                "The Origins of the Universe for Dummies", 2012, 350,
                "astronomy", Manuale.Audience.ANY));
        books.add(new Manuale("Ron White", "How Computers Work", 2007, 464,
                "information technology", Manuale.Audience.BEGINNER));
        books.add(new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        return new Object[][]{{books}};
    }

    @DataProvider(name = "BookShelf with data02")
    public static Object[][] provideData03() throws NotEnoughSpaceException {
        BookShelf books = new BookShelf(10);
        books.add(new FictionLiterature("", "Pushkin", "Best poems", 2013, 254));
        books.add(new Dictionary(Dictionary.Type.BILINGUAL, "Harvest",
                "", "Russian-English", 2013, 356));
        books.add(new FictionLiterature("", "J.K.Rowling",
                "Harry Potter and the Philosopher's stone", 2001, 310));
        books.add(new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        books.add(new FictionLiterature("", "J.R.R.Tolkien",
                "Lord of the Rings", 3, 1, 2007, 358));
        books.add(new Magazine("National Geographic", 2017, 8, 152,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        books.add(new FictionLiterature("", "J.R.R.Tolkien",
                "Lord of the Rings", 3, 2, 2008, 321));
        books.add(new Manuale("Ron White", "How Computers Work", 2007, 464,
                "information technology", Manuale.Audience.BEGINNER));
        books.add(new Magazine("National Geographic", 2018, 1, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        return new Object[][]{{books}};
    }

}
