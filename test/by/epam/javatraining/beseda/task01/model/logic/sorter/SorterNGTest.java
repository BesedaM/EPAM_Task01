package by.epam.javatraining.beseda.task01.model.logic.sorter;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.ClassNameSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.DateSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.NameSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.PagesNumberSorter;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @versin 1.0 26/02/2019
 */
public class SorterNGTest {

    public SorterNGTest() {
    }

    @Test
    public void testSort01() throws WrongIndexException {
        Sorter.sort(null, new ClassNameSorter());
    }

    @Test
    public void testSort02() throws WrongIndexException {
        Sorter.sort(new BookShelf(5), null);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSort03(BookShelf books) throws WrongIndexException {
        Sorter.sort(books, new ClassNameSorter());
        assertEquals(books.get(0).getClass(), Dictionary.class);
        assertEquals(books.get(1).getClass(), FictionLiterature.class);
        assertEquals(books.get(2).getClass(), FictionLiterature.class);
        assertEquals(books.get(3).getClass(), Magazine.class);
        assertEquals(books.get(4).getClass(), Magazine.class);
        assertEquals(books.get(5).getClass(), Manuale.class);
        assertEquals(books.get(6).getClass(), Manuale.class);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSort04(BookShelf books) throws WrongIndexException {
        Sorter.sort(books, new NameSorter());
        assertTrue(books.get(0).getName().compareTo(books.get(1).getName()) <= 0);
        assertTrue(books.get(1).getName().compareTo(books.get(2).getName()) <= 0);
        assertTrue(books.get(2).getName().compareTo(books.get(3).getName()) <= 0);
        assertTrue(books.get(3).getName().compareTo(books.get(4).getName()) <= 0);
        assertTrue(books.get(4).getName().compareTo(books.get(5).getName()) <= 0);
        assertTrue(books.get(5).getName().compareTo(books.get(6).getName()) <= 0);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSort05(BookShelf books) throws WrongIndexException {
        Sorter.sort(books, new PagesNumberSorter());
        assertTrue(books.get(0).getPagesNumber() <= books.get(1).getPagesNumber());
        assertTrue(books.get(1).getPagesNumber() <= books.get(2).getPagesNumber());
        assertTrue(books.get(2).getPagesNumber() <= books.get(3).getPagesNumber());
        assertTrue(books.get(3).getPagesNumber() <= books.get(4).getPagesNumber());
        assertTrue(books.get(4).getPagesNumber() <= books.get(5).getPagesNumber());
        assertTrue(books.get(5).getPagesNumber() <= books.get(6).getPagesNumber());
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSort06(BookShelf books) throws WrongIndexException {
        Sorter.sort(books, new DateSorter());
        assertEquals(books.get(0).getYear() <= books.get(1).getYear(), true);
        assertEquals(books.get(1).getYear() <= books.get(2).getYear(), true);
        assertEquals(books.get(2).getYear() <= books.get(3).getYear(), true);
        assertEquals(books.get(3).getYear() <= books.get(4).getYear(), true);
        assertEquals(books.get(4).getYear() <= books.get(5).getYear(), true);
        assertEquals(books.get(5).getYear() <= books.get(6).getYear(), true);
    }

    public void testSort07() throws NotEnoughSpaceException, WrongIndexException {
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

        Sorter.sort(booksLocal, new DateSorter());

        assertEquals(booksLocal.get(0).getName(), "How Computers Work");
        assertEquals(booksLocal.get(1).getName(), "National Geographic");
        assertEquals(booksLocal.get(2).getName(), "Digital Photography");
        assertEquals(booksLocal.get(3).getName(), "National Geographic");
        assertEquals(booksLocal.get(4).getName(), "National Geographic");
    }

    @Test
    public void testSortApartPerAndNonPer01() throws WrongIndexException {
        Sorter.sortApartPeriodicalAndNonPeriodical(null, new NameSorter());
    }

    @Test
    public void testSortApartPerAndNonPer02() throws WrongIndexException {
        Sorter.sortApartPeriodicalAndNonPeriodical(new BookShelf(5), null);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSortApartPerAndNonPer03(BookShelf books) throws WrongIndexException {
        Sorter.sortApartPeriodicalAndNonPeriodical(books, new ClassNameSorter());
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

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSortApartPerAndNonPer04(BookShelf books) throws WrongIndexException {
        Sorter.sortApartPeriodicalAndNonPeriodical(books, new NameSorter());
        assertTrue(books.get(0) instanceof NonPeriodical);

        assertTrue(books.get(0).getName().compareTo(books.get(1).getName()) <= 0);
        assertTrue(books.get(1).getName().compareTo(books.get(2).getName()) <= 0);
        assertTrue(books.get(2).getName().compareTo(books.get(3).getName()) <= 0);
        assertTrue(books.get(3).getName().compareTo(books.get(4).getName()) <= 0);

        assertTrue(books.get(5) instanceof Periodical);       
        assertTrue(books.get(5).getName().compareTo(books.get(6).getName()) <= 0);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testSortApartPerAndNonPer05(BookShelf books) throws WrongIndexException {
        Sorter.sortApartPeriodicalAndNonPeriodical(books, new PagesNumberSorter());

        assertTrue(books.get(0) instanceof NonPeriodical);
        assertTrue(books.get(0).getPagesNumber() <= books.get(1).getPagesNumber());
        assertTrue(books.get(1).getPagesNumber() <= books.get(2).getPagesNumber());
        assertTrue(books.get(2).getPagesNumber() <= books.get(3).getPagesNumber());
        assertTrue(books.get(3).getPagesNumber() <= books.get(4).getPagesNumber());

        assertTrue(books.get(5) instanceof Periodical);
        assertTrue(books.get(5).getPagesNumber() <= books.get(6).getPagesNumber());
    }

}
