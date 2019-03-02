package by.epam.javatraining.beseda.task01.model.logic.sorter;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @versin 1.0 26/02/2019
 */
public class SorterNGTest {

    public SorterNGTest() {
    }

    @DataProvider(name = "BookShelf with data")
    public static Object[][] provideData01() {
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

    @Test
    public void testSort01() {
        Sorter.sort(null, Sorter.NAME_SORTER);
    }

    @Test
    public void testSort02() {
        Sorter.sort(new BookShelf(5), null);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSort03(BookShelf books) {
        Sorter.sort(books, Sorter.CLASS_NAME_SORTER);
        assertEquals(books.get(0).getClass(), Dictionary.class);
        assertEquals(books.get(1).getClass(), FictionLiterature.class);
        assertEquals(books.get(2).getClass(), FictionLiterature.class);
        assertEquals(books.get(3).getClass(), Magazine.class);
        assertEquals(books.get(4).getClass(), Magazine.class);
        assertEquals(books.get(5).getClass(), Manuale.class);
        assertEquals(books.get(6).getClass(), Manuale.class);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSort04(BookShelf books) {
        Sorter.sort(books, Sorter.NAME_SORTER);
        assertEquals(books.get(0).getName(), "Fahrenheit 451");
        assertEquals(books.get(1).getName(), "How Computers Work");
        assertEquals(books.get(2).getName(), "Les Miserables");
        assertEquals(books.get(3).getName(), "Mandarin Chinese");
        assertEquals(books.get(4).getName(), "National Geographic");
        assertEquals(books.get(5).getName(), "National Geographic");
        assertEquals(books.get(6).getName(), "The Origins of the Universe for Dummies");
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSort05(BookShelf books) {
        Sorter.sort(books, Sorter.NUMBER_OF_PAGES_SORTER);
        assertEquals(books.get(0).getName(), "National Geographic");
        assertEquals(books.get(1).getName(), "National Geographic");
        assertEquals(books.get(2).getName(), "Fahrenheit 451");
        assertEquals(books.get(3).getName(), "The Origins of the Universe for Dummies");
        assertEquals(books.get(4).getName(), "How Computers Work");
        assertEquals(books.get(5).getName(), "Mandarin Chinese");
        assertEquals(books.get(6).getName(), "Les Miserables");
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSort06(BookShelf books) {
        Sorter.sort(books, Sorter.DATE_SORTER);
        assertEquals(books.get(0).getYear() <= books.get(1).getYear(), true);
        assertEquals(books.get(1).getYear() <= books.get(2).getYear(), true);
        assertEquals(books.get(2).getYear() <= books.get(3).getYear(), true);
        assertEquals(books.get(3).getYear() <= books.get(4).getYear(), true);
        assertEquals(books.get(4).getYear() <= books.get(5).getYear(), true);
        assertEquals(books.get(5).getYear() <= books.get(6).getYear(), true);
    }

    public void testSort07() {
        BookShelf booksLocal = new BookShelf(5);
        booksLocal.add(new Manuale("Ron White", "How Computers Work", 2007, 464,
                "information technology", Manuale.Audience.BEGINNER));
        booksLocal.add(new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        booksLocal.add(new Magazine("Digital Photography", 2019, 1, 153,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        booksLocal.add(new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        booksLocal.add(new Magazine("National Geographic", 2019, 2, 152,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        
        Sorter.sort(booksLocal, Sorter.DATE_SORTER);

        assertEquals(booksLocal.get(0).getName(), "How Computers Work");
        assertEquals(booksLocal.get(1).getName(), "National Geographic");
        assertEquals(booksLocal.get(2).getName(), "Digital Photography");
        assertEquals(booksLocal.get(3).getName(), "National Geographic");
        assertEquals(booksLocal.get(4).getName(), "National Geographic");
    }

    @Test
    public void testSortApartPerAndNonPer01() {
        Sorter.sortApartPeriodicalAndNonPeriodical(null, Sorter.NAME_SORTER);
    }

    @Test
    public void testSortApartPerAndNonPer02() {
        Sorter.sortApartPeriodicalAndNonPeriodical(new BookShelf(5), null);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSortApartPerAndNonPer03(BookShelf books) {
        Sorter.sortApartPeriodicalAndNonPeriodical(books, Sorter.CLASS_NAME_SORTER);
        assertTrue(books.get(0) instanceof NonPeriodical);
        assertEquals(books.get(0).getClass(), Dictionary.class);
        assertEquals(books.get(1).getClass(), FictionLiterature.class);
        assertEquals(books.get(2).getClass(), FictionLiterature.class);
        assertEquals(books.get(3).getClass(), Manuale.class);
        assertEquals(books.get(4).getClass(), Manuale.class);
        
        assertTrue(books.get(5) instanceof Periodical);
        assertEquals(books.get(5).getClass(), Magazine.class);
        assertEquals(books.get(6).getClass(), Magazine.class);
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSortApartPerAndNonPer04(BookShelf books) {
        Sorter.sortApartPeriodicalAndNonPeriodical(books, Sorter.NAME_SORTER);
        assertTrue(books.get(0) instanceof NonPeriodical);
        assertEquals(books.get(0).getName(), "Fahrenheit 451");
        assertEquals(books.get(1).getName(), "How Computers Work");
        assertEquals(books.get(2).getName(), "Les Miserables");
        assertEquals(books.get(3).getName(), "Mandarin Chinese");
        assertEquals(books.get(4).getName(), "The Origins of the Universe for Dummies");
        
        assertTrue(books.get(5) instanceof Periodical);
        assertEquals(books.get(5).getName(), "National Geographic");
        assertEquals(books.get(6).getName(), "National Geographic");
    }

    @Test(dataProvider = "BookShelf with data")
    public void testSortApartPerAndNonPer05(BookShelf books) {
        Sorter.sortApartPeriodicalAndNonPeriodical(books, Sorter.NUMBER_OF_PAGES_SORTER);
        
        assertTrue(books.get(0) instanceof NonPeriodical);
        assertTrue(books.get(0).getNumberOfPages() < books.get(1).getNumberOfPages());
        assertTrue(books.get(1).getNumberOfPages() < books.get(2).getNumberOfPages());
        assertTrue(books.get(2).getNumberOfPages() < books.get(3).getNumberOfPages());
        assertTrue(books.get(3).getNumberOfPages() < books.get(4).getNumberOfPages());
        
        assertTrue(books.get(5) instanceof Periodical);
        assertTrue(books.get(5).getNumberOfPages() < books.get(6).getNumberOfPages());
    }

}
