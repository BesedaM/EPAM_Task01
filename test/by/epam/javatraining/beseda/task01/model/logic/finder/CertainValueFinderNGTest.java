package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter.ClassNameFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter.NameFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter.PagesNumberFinder;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 26/02/2019
 */
public class CertainValueFinderNGTest {

    public CertainValueFinderNGTest() {
    }

    
    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFinder01(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new ClassNameFinder("Dictionary"));
        assertEquals(list.toString(), "[]");
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFinder02(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new NameFinder("How to"));
        assertEquals(list.toString(), "[]");
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFinder03(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new ClassNameFinder("FictionLiterature"));
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        expected.add(new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208));
        assertEquals(list, expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFinder04(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new ClassNameFinder("Dictionary"));
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new Dictionary(Dictionary.Type.BILINGUAL, "Berlitz",
                "", "Mandarin Chinese", 2007, 671));
        assertEquals(list, expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFinder05(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new PagesNumberFinder(1221));
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221));
        assertEquals(list, expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFinder06(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new PagesNumberFinder(350));
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new Manuale("Mark Frary, Stephen Pincock",
                "The Origins of the Universe for Dummies", 2012, 350,
                "astronomy", Manuale.Audience.ANY));
        assertEquals(list, expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFinder07(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new NameFinder("How"));
        ArrayList<Publication> expected = new ArrayList<>();
        expected.add(new Manuale("Ron White", "How Computers Work", 2007, 464,
                "information technology", Manuale.Audience.BEGINNER));
        assertEquals(list, expected);
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFinder08(BookShelf books) throws WrongIndexException {
        List<Publication> list
                = CertainValueFinder.find(books, new NameFinder("to"));
        ArrayList<Publication> expected = new ArrayList<>();
        assertEquals(list, expected);
    }
}
