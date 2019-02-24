package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalPeriodicityException;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class NewspaperNGTest {

    Newspaper news;

    @Test(expectedExceptions = {IllegalPeriodicityException.class})
    public void testSetPeriodicity01()
            throws IllegalPeriodicityException {
        this.news = new Newspaper();
        this.news.setPeriodicity(null);
    }

    @Test
    public void testGetPeriodicity01() {
        this.news = new Newspaper(null, -10, -10, -10, null, null);
        Assert.assertEquals(this.news.getPeriodicity(), Newspaper.Periodicity.WEEKLY);
    }

    @Test
    public void testGetPeriodicity02() {
        this.news = new Newspaper(null, -10, -10, -10, null, null);
        Assert.assertNotEquals(this.news.getPeriodicity(), Magazine.Periodicity.WEEKLY);
    }
}
