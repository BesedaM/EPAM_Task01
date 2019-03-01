package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.util.ArrayList;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 26/02/2019
 */
public class ValueFinderNGTest {

    public ValueFinderNGTest() {
    }

    @DataProvider(name = "Empty BookShelf")
    public static Object[][] provideData01() {
        BookShelf books = new BookShelf(5);
        return new Object[][]{{books}};
    }

    @DataProvider(name = "BookShelf with data")
    public static Object[][] provideData02() {
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

    @Test(dataProvider = "Empty BookShelf")
    public void testFinder01(BookShelf books) {
        ArrayList<Publication> list
                = ValueFinder.find(books,
                        ValueFinder.CLASS_NAME, "Dictionary");
        assertEquals(list.toString(), "[]");
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFinder02(BookShelf books) {
        ArrayList<Publication> list
                = ValueFinder.find(books,
                        ValueFinder.NAME, "How to");
        assertEquals(list.toString(), "[]");
    }

    @Test(dataProvider = "BookShelf with data")
    public void testFinder03(BookShelf books) {
        ArrayList<Publication> list
                = ValueFinder.find(books,
                        ValueFinder.CLASS_NAME, "FictionLiterature");
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        expected.add(new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208));
        assertEquals(list, expected);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testFinder04(BookShelf books) {
        ArrayList<Publication> list
                = ValueFinder.find(books,
                        ValueFinder.NUMBER_OF_PAGES, 1221);
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        assertEquals(list, expected);
    }
}
