package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalAudienceException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNumberException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class PeriodicalNGTest {

    Periodical periodical;

    @BeforeGroups(groups = {"test setters"})
    public void createPeriodical() {
        this.periodical = new Periodical();
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalNumberException.class})
    public void testSetNumber01()
            throws IllegalNumberException {
        this.periodical.setNumber(-1);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalAudienceException.class})
    public void testSetAudience01()
            throws IllegalAudienceException {
        this.periodical.setAudience(null);
    }

    @BeforeGroups(groups = {"incorrect data in Constructor"})
    public void createPeriodicalIncorrect() {
        this.periodical = new Periodical(null, -10, -1, -1, null);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetName01() {
        Assert.assertEquals(this.periodical.getName(), "Unknown");
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetYear01() {
        Assert.assertEquals(this.periodical.getYear(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetNumberOfPages01() {
        Assert.assertEquals(this.periodical.getNumberOfPages(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetNumber01() {
        Assert.assertEquals(this.periodical.getNumber(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetAudience01() {
        Assert.assertEquals(this.periodical.getAudience(), Periodical.Audience.ANY);
    }
}
