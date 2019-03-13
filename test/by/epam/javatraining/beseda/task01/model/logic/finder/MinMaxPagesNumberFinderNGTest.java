package by.epam.javatraining.beseda.task01.model.logic.finder;

import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import by.epam.javatraining.beseda.task01.model.logic.data.TestingData;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class MinMaxPagesNumberFinderNGTest {

    public MinMaxPagesNumberFinderNGTest() {
    }

    Publication expected;

    @Test
    public void testFindMax01() throws WrongIndexException {
        Assert.assertNull(MinMaxPagesNumberFinder.findMax(null));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindMax02(PublicationContainer books) throws WrongIndexException {
        Assert.assertNull(MinMaxPagesNumberFinder.findMax(books));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMax03(PublicationContainer books) throws WrongIndexException {
        expected = new FictionLiterature("historical novel", "Victor Hugo",
                "Les Miserables", 2013, 1221);
        Assert.assertEquals(MinMaxPagesNumberFinder.findMax(books), expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMax04(PublicationContainer books) throws WrongIndexException {
        expected = new Manuale("Ron White", "How Computers Work", 2007, 464,
                "information technology", Manuale.Audience.BEGINNER);
        Assert.assertEquals(MinMaxPagesNumberFinder.findMax(books), expected);
    }

    @Test
    public void testFindMin01() throws WrongIndexException {
        Assert.assertNull(MinMaxPagesNumberFinder.findMin(null));
    }

    @Test(dataProvider = "Empty BookShelf", dataProviderClass = TestingData.class)
    public void testFindMin02(PublicationContainer books) throws WrongIndexException {
        Assert.assertNull(MinMaxPagesNumberFinder.findMin(books));
    }

    @Test(dataProvider = "BookShelf with data01", dataProviderClass = TestingData.class)
    public void testFindMin03(PublicationContainer books) throws WrongIndexException {
        expected = new Magazine("National Geographic", 2018, 2, 158,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        Assert.assertEquals(MinMaxPagesNumberFinder.findMin(books), expected);
    }

    @Test(dataProvider = "BookShelf with data02", dataProviderClass = TestingData.class)
    public void testFindMin04(PublicationContainer books) throws WrongIndexException {
        expected = new Magazine("National Geographic", 2017, 8, 152,
                Periodical.Audience.ANY, Magazine.Periodicity.MONTHLY);
        Assert.assertEquals(MinMaxPagesNumberFinder.findMin(books), expected);
    }
}
