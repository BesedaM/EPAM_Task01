package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class OldestNewestYearFinderNGTest {

    public OldestNewestYearFinderNGTest() {
    }

    List<Publication> expected = new ArrayList<>();

    @Test
    public void testFindNewest01() throws WrongIndexException {
        expected.clear();
        Assert.assertTrue(OldestNewestYearFinder.findNewest(null).containsAll(expected));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindNewest02(PublicationContainer books) throws WrongIndexException {
        expected.clear();
        Assert.assertTrue(OldestNewestYearFinder.findNewest(books).containsAll(expected));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindNewest03(PublicationContainer books) throws WrongIndexException {
        expected.clear();
        expected.add(new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        Assert.assertTrue(OldestNewestYearFinder.findNewest(books).containsAll(expected));
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindNewest04(PublicationContainer books) throws WrongIndexException {
        expected.clear();
        expected.add(new Magazine("National Geographic", 2018, 1, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        expected.add(new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY));
        Assert.assertTrue(OldestNewestYearFinder.findNewest(books).containsAll(expected));
    }

    @Test
    public void testFindOldest01() throws WrongIndexException {
        expected.clear();
        Assert.assertTrue(OldestNewestYearFinder.findOldest(null).containsAll(expected));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindOldest02(PublicationContainer books) throws WrongIndexException {
        expected.clear();
        Assert.assertTrue(OldestNewestYearFinder.findOldest(books).containsAll(expected));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindOldest03(PublicationContainer books) throws WrongIndexException {
        expected.clear();
        expected.add(new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208));
        Assert.assertTrue(OldestNewestYearFinder.findOldest(books).containsAll(expected));
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindOldest04(PublicationContainer books) throws WrongIndexException {
        expected.clear();
        expected.add(new FictionLiterature("", "J.K.Rowling",
                "Harry Potter and the Philosopher's stone", 2001, 310));
        Assert.assertTrue(OldestNewestYearFinder.findOldest(books).addAll(expected));
    }

}
