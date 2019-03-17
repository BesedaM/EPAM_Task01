package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter.DateField;
import by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter.PagesNumberField;
import by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter.YearField;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class ExtremeValuePublicationFinderNGTest {

    public ExtremeValuePublicationFinderNGTest() {
    }

    Publication expected;

    @Test
    public void testFindMax01() throws PublicationContainerException {
        assertNull(ExtremeValuePublicationFinder.findMax(null, new YearField()));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindMax02(BookShelf books) throws PublicationContainerException {
        assertNull(ExtremeValuePublicationFinder.findMax(books, null));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindMax03(BookShelf books) throws PublicationContainerException {
        assertNull(ExtremeValuePublicationFinder.findMax(books, new YearField()));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMax04(BookShelf books) throws PublicationContainerException {
        expected = new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        assertEquals(ExtremeValuePublicationFinder.findMax(books, new YearField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMax05(BookShelf books) throws PublicationContainerException {
        expected = new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        assertEquals(ExtremeValuePublicationFinder.findMax(books, new YearField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMax06(BookShelf books) throws PublicationContainerException {
        expected = new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221);
        assertEquals(ExtremeValuePublicationFinder.findMax(books, new PagesNumberField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMax07(BookShelf books) throws PublicationContainerException {
        expected = new Manuale("Ron White", "How Computers Work", 2007, 464,
                "information technology", Manuale.Audience.BEGINNER);
        assertEquals(ExtremeValuePublicationFinder.findMax(books, new PagesNumberField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMax08(BookShelf books) throws PublicationContainerException {
        expected = new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        assertEquals(ExtremeValuePublicationFinder.findMax(books, new DateField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMax09(BookShelf books) throws PublicationContainerException {
        expected = new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        assertEquals(ExtremeValuePublicationFinder.findMax(books, new DateField()),
                expected);
    }

    @Test
    public void testFindMin01() throws PublicationContainerException {
        assertNull(ExtremeValuePublicationFinder.findMin(null, new YearField()));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindMin02(BookShelf books) throws PublicationContainerException {
        assertNull(ExtremeValuePublicationFinder.findMin(books, null));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindMin03(BookShelf books) throws PublicationContainerException {
        assertNull(ExtremeValuePublicationFinder.findMin(books, new YearField()));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMin04(BookShelf books) throws PublicationContainerException {
        expected = new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208);
        assertEquals(ExtremeValuePublicationFinder.findMin(books, new YearField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMin05(BookShelf books) throws PublicationContainerException {
        expected = new FictionLiterature("", "J.K.Rowling",
                "Harry Potter and the Philosopher's stone", 2001, 310);
        assertEquals(ExtremeValuePublicationFinder.findMin(books, new YearField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMin06(BookShelf books) throws PublicationContainerException {
        expected = new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        assertEquals(ExtremeValuePublicationFinder.findMin(books, new PagesNumberField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMin07(BookShelf books) throws PublicationContainerException {
        expected = new Magazine("National Geographic", 2017, 8, 152,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        assertEquals(ExtremeValuePublicationFinder.findMin(books, new PagesNumberField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMin08(BookShelf books) throws PublicationContainerException {
        expected = new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208);
        assertEquals(ExtremeValuePublicationFinder.findMin(books, new DateField()),
                expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMin09(BookShelf books) throws PublicationContainerException {
        expected = new FictionLiterature("", "J.K.Rowling",
                "Harry Potter and the Philosopher's stone", 2001, 310);
        assertEquals(ExtremeValuePublicationFinder.findMin(books, new DateField()),
                expected);
    }
}
