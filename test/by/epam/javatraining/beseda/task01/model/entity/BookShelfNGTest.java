package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class BookShelfNGTest {

    public BookShelfNGTest() {
    }

    BookShelf badBooks;
   
    @BeforeGroups(groups = {"incorrect data"})
    public void createBookShelfIncorrect() {
        badBooks = new BookShelf(-10);
    }

    @Test(groups = {"incorrect data"})
    public void testGetMaximumSize01() {
        Assert.assertEquals(badBooks.maximumCapacity(), 0);
    }

    @Test(groups = {"incorrect data"})
    public void testGetSize01() {
        Assert.assertEquals(badBooks.publicationsNumber(), 0);
    }

    @Test(groups = {"incorrect data"})
    public void testAdd01() throws NotEnoughSpaceException {
        Assert.assertEquals(badBooks.add(new Magazine()), false);
    }

    @Test(groups = {"incorrect data"})
    public void testDelete01() {
        Assert.assertEquals(badBooks.remove(new Dictionary()), false);
    }

    @Test(groups = {"incorrect data"})
    public void testGetNumberOfPeriodical01() {
        Assert.assertEquals(badBooks.periodicalNumber(), 0);
    }

    @Test(groups = {"incorrect data"})
    public void testGetNumberOfNonPeriodical01() {
        Assert.assertEquals(badBooks.nonPeriodicalNumber(), 0);
    }

    @DataProvider(name = "correct data")
    public Object[][] createBookShelfCorrect() {
        BookShelf goodBooks = new BookShelf(3);
        goodBooks.add(new Dictionary());
        goodBooks.add(new Magazine());
        return new Object[][]{{goodBooks}};
    }

    @Test(dataProvider = "correct data")
    public void testContains01(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.contains(new Magazine()), true);
    }

    @Test(dataProvider = "correct data")
    public void testContains02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.contains(new Magazine("", 0, 0, 0, null, null)), false);
    }

    @Test(dataProvider = "correct data")
    public void testGetNumberOfPeriodical02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.periodicalNumber(), 1);
    }

    @Test(dataProvider = "correct data")
    public void testGetNumberOfNonPeriodical02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.nonPeriodicalNumber(), 1);
    }

    @Test(dataProvider = "correct data")
    public void testGetMaximumSize02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.maximumCapacity(), 3);
    }

    @Test(dataProvider = "correct data")
    public void testGetSize02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.numberOfPublications(), 2);
    }

    @Test(dataProvider = "correct data")
    public void testSetGet02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.set(0, new Newspaper()),true);
        Assert.assertEquals(goodBooks.get(0), new Newspaper());
    }

    @Test(dataProvider = "correct data")
    public void testSet03(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.set(3, new Newspaper()),false);
    }

    @Test(dataProvider = "correct data")
    public void testAdd02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.add(new Magazine()), true);
        Assert.assertEquals(goodBooks.add(new Magazine()), false);
    }

    @Test(dataProvider = "correct data")
    public void testGetSize03(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.numberOfPublications(), 2);
    }

    @Test(dataProvider = "correct data")
    public void testDelete02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.remove(0), true);
    }

    @Test(dataProvider = "correct data")
    public void testGet02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.get(3), null);
    }

}
