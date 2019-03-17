package by.epam.javatraining.beseda.task01.model.logic.calculator;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.1 17/03/2019
 */
public class PagesNumberCalculatorNGTest {

    public PagesNumberCalculatorNGTest() {
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testCalculateMultivolume01(BookShelf books)
            throws PublicationContainerException {
        books = new BookShelf(10);
        assertEquals(PagesNumberCalculator.calculateMultivolume(books, null), 0);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testCalculateMultivolume02(BookShelf books)
            throws PublicationContainerException {
        books = new BookShelf(10);
        assertEquals(PagesNumberCalculator.calculateMultivolume(null,
                "The Dark Tower"), 0);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testCalculateMultivolume03(BookShelf books)
            throws PublicationContainerException {
        assertEquals(PagesNumberCalculator.calculateMultivolume(books,
                "National Geographic"), 0);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testCalculateMultivolume04(BookShelf books)
            throws PublicationContainerException {
        assertEquals(PagesNumberCalculator.calculateMultivolume(books,
                "Lord of"), 358+321);
    }

    @Test
    public void testCalculateMultivolume05()
            throws NotEnoughSpaceException, PublicationContainerException {
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
                "Mandarin Chinese"), 671 + 671);
    }

}
