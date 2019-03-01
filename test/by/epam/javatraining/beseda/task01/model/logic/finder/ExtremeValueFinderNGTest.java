package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 26/02/2019
 */
public class ExtremeValueFinderNGTest {

    public ExtremeValueFinderNGTest() {
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
        books.add(new Magazine("National Geographic", 2019, 1, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        return new Object[][]{{books}};
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMin01(BookShelf books) {
        assertNull(ExtremeValueFinder.findMin(books, ExtremeValueFinder.YEAR));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMin02(BookShelf books) {
        assertNull(ExtremeValueFinder.findMin(books, ExtremeValueFinder.NUMBER_OF_PAGES));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMin03(BookShelf books) {
        assertNull(ExtremeValueFinder.findMin(books, null));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMin04(BookShelf books) {
        assertNull(ExtremeValueFinder.findMin(null, ExtremeValueFinder.YEAR));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMax01(BookShelf books) {
        assertNull(ExtremeValueFinder.findMax(books, ExtremeValueFinder.YEAR));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMax02(BookShelf books) {
        assertNull(ExtremeValueFinder.findMax(books, ExtremeValueFinder.NUMBER_OF_PAGES));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMax03(BookShelf books) {
        assertNull(ExtremeValueFinder.findMax(books, null));
    }

    @Test(dataProvider = "Empty BookShelf")
    public void testFindMax04(BookShelf books) {
        assertNull(ExtremeValueFinder.findMax(null, ExtremeValueFinder.YEAR));
    }

    @Test(dataProvider = "BookShelf with data")
    public void testFindMin05(BookShelf books) {
        assertEquals(ExtremeValueFinder.findMin(books, ExtremeValueFinder.YEAR),
                new FictionLiterature("science fiction", "Ray Bradbury",
                        "Fahrenheit 451", 2004, 208));
    }

    @Test(dataProvider = "BookShelf with data")
    public void testFindMin06(BookShelf books) {
        assertEquals(ExtremeValueFinder.findMin(books, ExtremeValueFinder.NUMBER_OF_PAGES),
                new Magazine("National Geographic", 2018, 2, 158,
                        Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
    }

    @Test(dataProvider = "BookShelf with data")
    public void testFindMax05(BookShelf books) {
        assertEquals(ExtremeValueFinder.findMax(books, ExtremeValueFinder.YEAR),
                new Magazine("National Geographic", 2019, 3, 170,
                        Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
    }

    @Test(dataProvider = "BookShelf with data")
    public void testFindMax06(BookShelf books) {
        assertEquals(ExtremeValueFinder.findMax(books, ExtremeValueFinder.NUMBER_OF_PAGES),
                new FictionLiterature("historical novel", "Victor Hugo",
                        "Les Miserables", 2013, 1221));
    }

}
