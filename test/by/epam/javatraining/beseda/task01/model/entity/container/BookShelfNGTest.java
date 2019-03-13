package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Newspaper;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
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
    public void testMaximumCapacity01() {
        Assert.assertEquals(badBooks.maximumCapacity(), 16);
    }

    @Test(groups = {"incorrect data"})
    public void testAdd01() throws NotEnoughSpaceException {
        Assert.assertTrue(badBooks.add(new Magazine()));
    }

    @Test(groups = {"incorrect data"})
    public void testDelete01() {
        Assert.assertFalse(badBooks.remove(new Dictionary()));
    }

    @DataProvider(name = "incorrect data")
    public Object[][] createIncorrectData() throws NotEnoughSpaceException {
        badBooks = new BookShelf(-10);
        return new Object[][]{{badBooks}};
    }

    @Test(groups = {"incorrect data"}, dataProvider = "incorrect data")
    public void testPublicationsNumber01(BookShelf books) {
        Assert.assertEquals(books.publicationsNumber(), 0);
    }

    @Test(groups = {"incorrect data"}, dataProvider = "incorrect data")
    public void testGetPeriodicalNumber01(BookShelf books) {
        Assert.assertEquals(books.periodicalNumber(), 0);
    }

    @Test(groups = {"incorrect data"}, dataProvider = "incorrect data")
    public void testGetNonPeriodicalNumber01(BookShelf books) {
        Assert.assertEquals(books.nonPeriodicalNumber(), 0);
    }

    @DataProvider(name = "correct data")
    public Object[][] createBookShelfCorrect() throws NotEnoughSpaceException {
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
        Assert.assertEquals(goodBooks.contains(
                new Magazine("", 0, 0, 0, null, null)), false);
    }

    @Test(dataProvider = "correct data")
    public void testGetPeriodicalNumber02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.periodicalNumber(), 1);
    }

    @Test(dataProvider = "correct data")
    public void testGetNonPeriodicalNumber02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.nonPeriodicalNumber(), 1);
    }

    @Test(dataProvider = "correct data")
    public void testMaximumCapacity02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.maximumCapacity(), 3);
    }

    @Test(dataProvider = "correct data")
    public void testGetSize02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.publicationsNumber(), 2);
    }

    @Test(dataProvider = "correct data")
    public void testSetGet02(BookShelf goodBooks) throws WrongIndexException {
        Assert.assertTrue(goodBooks.set(0, new Newspaper()));
        Assert.assertEquals(goodBooks.get(0), new Newspaper());
    }

    @Test(dataProvider = "correct data",
            expectedExceptions = {WrongIndexException.class})
    public void testSet03(BookShelf goodBooks) throws WrongIndexException {
        goodBooks.set(3, new Newspaper());
    }

    @Test(dataProvider = "correct data",
            expectedExceptions = {NotEnoughSpaceException.class})
    public void testAdd02(BookShelf goodBooks) throws NotEnoughSpaceException {
        goodBooks.add(new Magazine());
        goodBooks.add(new Magazine());
    }

    @Test(dataProvider = "correct data")
    public void testGetSize03(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.publicationsNumber(), 2);
    }

    @Test(dataProvider = "correct data")
    public void testDelete02(BookShelf goodBooks) {
        Assert.assertEquals(goodBooks.remove(new Magazine()), true);
    }

    @Test(dataProvider = "correct data",
            expectedExceptions = {WrongIndexException.class})
    public void testGet02(BookShelf goodBooks) throws WrongIndexException {
        goodBooks.get(3);
    }

    @Test(dataProvider = "correct data")
    public void testCopyConstructor(BookShelf books) {
        BookShelf copy = new BookShelf(books);
        Assert.assertTrue(copy.equals(books));
    }

}
