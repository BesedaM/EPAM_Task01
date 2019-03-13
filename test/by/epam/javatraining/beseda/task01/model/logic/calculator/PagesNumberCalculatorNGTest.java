package by.epam.javatraining.beseda.task01.model.logic.calculator;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 27/02/2019
 */
public class PagesNumberCalculatorNGTest {

    public PagesNumberCalculatorNGTest() {
    }

    @DataProvider(name = "BookShelf with data")
    public static Object[][] provideData01() throws NotEnoughSpaceException {
        BookShelf books = new BookShelf(10);
        books.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        books.add(new FictionLiterature("dark fantasy", "Stephen King",
                "The Dark Tower", 5, 3, 2012, 670));
        books.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz",
                "", "Mandarin Chinese", 2007, 671));
        books.add(new FictionLiterature("dark fantasy", "Stephen King",
                "The Dark Tower", 5, 1, 2003, 336));
        books.add(new FictionLiterature("dark fantasy", "Stephen King",
                "The Dark Tower", 5, 2, 2006, 496));
        books.add(new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208));
        books.add(new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        books.add(new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        return new Object[][]{{books}};
    }

    @Test(dataProvider = "BookShelf with data")
    public void testCalculateMultivolume01(BookShelf books) throws WrongIndexException {
        books = new BookShelf(10);
        assertEquals(PagesNumberCalculator.calculateMultivolume(books, null), 0);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testCalculateMultivolume02(BookShelf books) throws WrongIndexException {
        books = new BookShelf(10);
        assertEquals(PagesNumberCalculator.calculateMultivolume(null,
                "The Dark Tower"), 0);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testCalculateMultivolume03(BookShelf books) throws WrongIndexException {
        assertEquals(PagesNumberCalculator.calculateMultivolume(books,
                "National Geographic"), 0);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testCalculateMultivolume04(BookShelf books) throws WrongIndexException {
        assertEquals(PagesNumberCalculator.calculateMultivolume(books,
                "The Dark Tower"), 1502);
    }

    @Test
    public void testCalculateMultivolume05() 
            throws NotEnoughSpaceException, WrongIndexException {
        BookShelf books = new BookShelf(10);
        books.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        books.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz",
                "", "Mandarin Chinese", 2, 1, 2007, 671));
        books.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz",
                "", "Mandarin Chinese", 2, 2, 2007, 671));
        
        assertEquals(PagesNumberCalculator.calculateMultivolume(books,
                "The Dark Tower"), 0);
        assertEquals(PagesNumberCalculator.calculateMultivolume(books,
                "Mandarin Chinese"), 671+671);
    }

}
