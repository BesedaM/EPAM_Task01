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

    private Periodical periodicalDefault;
    private Periodical incorrectData;

    @BeforeGroups(groups = {"test setters"})
    public void createPeriodical() {
        this.periodicalDefault = new Periodical();
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalNumberException.class})
    public void testSetNumber01() throws IllegalNumberException {
        this.periodicalDefault.setNumber(-1);
    }

    @Test(groups = {"test setters"})
    public void testSetNumber02() throws IllegalNumberException {
        this.periodicalDefault.setNumber(1);
        Assert.assertEquals(this.periodicalDefault.getNumber(), 1);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalAudienceException.class})
    public void testSetAudience01() throws IllegalAudienceException {
        this.periodicalDefault.setAudience(null);
    }

    @Test(groups = {"test setters"})
    public void testSetAudience02() throws IllegalAudienceException {
        this.periodicalDefault.setAudience(Periodical.Audience.CHILDREN);
        Assert.assertEquals(this.periodicalDefault.getAudience(),
                Periodical.Audience.CHILDREN);
    }

    @BeforeGroups(groups = {"incorrect data in Constructor"})
    public void createPeriodicalIncorrect() {
        this.incorrectData = new Periodical(null, -10, -1, -1, null);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetName01() {
        Assert.assertEquals(this.incorrectData.getName(), "Unknown");
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetYear01() {
        Assert.assertEquals(this.incorrectData.getYear(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetNumberOfPages01() {
        Assert.assertEquals(this.incorrectData.getPagesNumber(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetNumber01() {
        Assert.assertEquals(this.incorrectData.getNumber(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetAudience01() {
        Assert.assertEquals(this.incorrectData.getAudience(),
                Periodical.Audience.ANY);
    }

    @Test
    public void testClone() {
        Periodical newPeriodical = new Periodical("Periodical", 2018, 10, 150,
                Periodical.Audience.ADULTS);
        Periodical clone = new Periodical(newPeriodical);
        Assert.assertTrue(newPeriodical.equals(clone));
    }
}
