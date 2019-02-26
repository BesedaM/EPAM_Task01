package by.epam.javatraining.beseda.task01.model.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
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
    BookShelf goodBooks;

    @BeforeGroups(groups = {"incorrect data"})
    public void createBookShelfIncorrect() {
        badBooks = new BookShelf(-10);
    }

    @Test(groups = {"incorrect data"})
    public void testGetMaximumSize01() {
        Assert.assertEquals(badBooks.getMaximumSize(), 0);
    }

    @Test(groups = {"incorrect data"})
    public void testGetSize01() {
        Assert.assertEquals(badBooks.getSize(), 0);
    }

    @Test(groups = {"incorrect data"})
    public void testAdd01() {
        Assert.assertEquals(badBooks.add(new Magazine()), false);
    }

    @Test(groups = {"incorrect data"})
    public void testDelete01() {
        Assert.assertEquals(badBooks.delete(0), false);
    }

    @Test(groups = {"incorrect data"})
    public void testGetNumberOfPeriodical01() {
        Assert.assertEquals(badBooks.getNumberOfPeriodical(), 0);
    }

    @Test(groups = {"incorrect data"})
    public void testGetNumberOfNonPeriodical01() {
        Assert.assertEquals(badBooks.getNumberOfNonPeriodical(), 0);
    }

    @BeforeGroups(groups = {"correct data"})
    public void createBookShelfCorrect() {
        goodBooks = new BookShelf(3);
        goodBooks.add(new Dictionary());
        goodBooks.add(new Magazine());
    }

    @Test(groups = {"correct data"}, priority = 1)
    public void testGetNumberOfPeriodical02() {
        Assert.assertEquals(goodBooks.getNumberOfPeriodical(), 1);
    }

    @Test(groups = {"correct data"}, priority = 1)
    public void testGetNumberOfNonPeriodical02() {
        Assert.assertEquals(goodBooks.getNumberOfNonPeriodical(), 1);
    }

    @Test(groups = {"correct data"}, priority = 2)
    public void testGetMaximumSize02() {
        Assert.assertEquals(goodBooks.getMaximumSize(), 3);
    }

    @Test(groups = {"correct data"}, priority = 2)
    public void testGetSize02() {
        Assert.assertEquals(goodBooks.getSize(), 2);
    }

    @Test(groups = {"correct data"}, priority = 3)
    public void testSetGet02() {
        goodBooks.set(0, new Newspaper());
        Assert.assertEquals(goodBooks.get(0), new Newspaper());
    }

    @Test(groups = {"correct data"}, priority = 3)
    public void testSetGet03() {
        goodBooks.set(3, new Newspaper());
        Assert.assertEquals(goodBooks.get(3), null);
    }

    @Test(groups = {"correct data"}, priority = 4)
    public void testAdd02() {
        Assert.assertEquals(goodBooks.add(new Magazine()), true);
        Assert.assertEquals(goodBooks.add(new Magazine()), false);
    }

    @Test(groups = {"correct data"}, priority = 5)
    public void testGetSize03() {
        Assert.assertEquals(goodBooks.getSize(), 3);
    }

    @Test(groups = {"correct data"}, priority = 6)
    public void testDelete02() {
        Assert.assertEquals(goodBooks.delete(2), true);
    }

    @Test(groups = {"correct data"}, priority = 6)
    public void testGet02() {
        Assert.assertEquals(goodBooks.get(3), null);
    }

}
