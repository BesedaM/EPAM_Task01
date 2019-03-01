package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalAudienceException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalScienceFieldException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class ManualeNGTest {

    Manuale book;

    @BeforeGroups(groups = {"test setters"})
    public void createManualeDefault() {
        this.book = new Manuale();
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalScienceFieldException.class})
    public void testSetField01()
            throws IllegalScienceFieldException {
        this.book.setField(null);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalAudienceException.class})
    public void testSetAudience01()
            throws IllegalAudienceException {
        this.book.setAudience(null);
    }

    @BeforeGroups(groups = {"incorrect data in constructor"})
    public void createManualeIncorrect() {
        this.book = new Manuale(null, null, -1, -1, null, null);
    }

    @Test(groups = {"incorrect data in constructor"})
    public void testGetField01() {
        Assert.assertEquals(this.book.getField(), "Unknown");
    }

    @Test(groups = {"incorrect data in constructor"})
    public void testGetAudience01() {
        Assert.assertEquals(this.book.getAudience(), Manuale.Audience.ANY);
    }
}