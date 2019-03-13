package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author User
 */
public class HomeLibraryNGTest {

    public HomeLibraryNGTest() {
    }

    HomeLibrary library = new HomeLibrary(3);

    @Test(priority = 1)
    public void testAdd() {
        Assert.assertTrue(library.add(new Magazine()));
        Assert.assertTrue(library.add(new Dictionary()));
        Assert.assertTrue(library.add(new FictionLiterature()));
    }

    @Test(priority = 1)
    public void testMaximumCapacity() {
        Assert.assertEquals(library.maximumCapacity(), 3);
    }

    @Test(priority = 2)
    public void testPublicationsNumber() {
        Assert.assertEquals(library.publicationsNumber(), 3);
    }
    
    @Test(priority = 3)
    public void testExtendLibrary() throws WrongIndexException {
        Assert.assertTrue(library.add(new FictionLiterature()));
        Assert.assertTrue(library.maximumCapacity() > 3);
        Assert.assertEquals(library.get(0), new Magazine());
        Assert.assertEquals(library.get(1), new Dictionary());
    }
}
