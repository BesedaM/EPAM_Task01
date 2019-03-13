package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class OldestNewestDateFinderNGTest {

    public OldestNewestDateFinderNGTest() {
    }

    Publication expected;

    @Test
    public void testFindOldest01() throws Exception {
        expected = null;
        Assert.assertNull(OldestNewestDateFinder.findOldest(null));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindOldest02(PublicationContainer books) throws Exception {
        Assert.assertNull(OldestNewestDateFinder.findOldest(null));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindOldest03(PublicationContainer books) throws Exception {
        expected = new FictionLiterature("science fiction", "Ray Bradbury",
                "Fahrenheit 451", 2004, 208);
        Assert.assertEquals(OldestNewestDateFinder.findOldest(books), expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindOldest04(PublicationContainer books) throws Exception {
        expected = new FictionLiterature("", "J.K.Rowling",
                "Harry Potter and the Philosopher's stone", 2001, 310);
        Assert.assertEquals(OldestNewestDateFinder.findOldest(books), expected);
    }

    @Test
    public void testFindNewest01() throws Exception {
        expected = null;
        Assert.assertNull(OldestNewestDateFinder.findNewest(null));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindNewest02(PublicationContainer books) throws Exception {
        expected = null;
        Assert.assertNull(OldestNewestDateFinder.findNewest(books));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindNewest03(PublicationContainer books) throws Exception {
        expected = new Magazine("National Geographic", 2019, 3, 170,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        Assert.assertEquals(OldestNewestDateFinder.findNewest(books), expected);
    }
    
    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindNewest04(PublicationContainer books) throws Exception {
        expected = new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        Assert.assertEquals(OldestNewestDateFinder.findNewest(books), expected);
    }
    
}
