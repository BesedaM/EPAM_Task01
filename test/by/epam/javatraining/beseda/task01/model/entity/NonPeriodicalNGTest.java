package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalAuthorException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNameException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalVolumesNumberException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalVolumeNumberException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class NonPeriodicalNGTest {

    NonPeriodical bookDefault;
    NonPeriodical bookIncorrect;

    @BeforeGroups(groups = {"test setters"})
    public void createPeriodical() {
        this.bookDefault = new NonPeriodical();
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalNameException.class})
    public void testSetName01() throws IllegalNameException {
        this.bookDefault.setName(null);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalAuthorException.class})
    public void testSetAuthor01() throws IllegalAuthorException {
        this.bookDefault.setAuthor(null);
    }

    @Test(groups = {"test setters"})
    public void testSetAuthor02() throws IllegalAuthorException {
        this.bookDefault.setAuthor("ABC");
        Assert.assertEquals(this.bookDefault.getAuthor(), "ABC");
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalVolumeNumberException.class})
    public void testSetVolumeNumber01() throws IllegalVolumeNumberException {
        this.bookDefault.setVolumeNumber(0);
    }

    @Test(groups = {"test setters"})
    public void testSetVolumeNumber02() throws IllegalVolumeNumberException {
        this.bookDefault.setVolumeNumber(1);
        Assert.assertEquals(this.bookDefault.getVolumeNumber(), 1);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalVolumesNumberException.class})
    public void testSetVolumesNumber01() throws IllegalVolumesNumberException {
        this.bookDefault.setVolumesNumber(0);
    }

    @BeforeGroups(groups = {"incorrect data in Constructor"})
    public void createPeriodicalIncorrect() {
        this.bookIncorrect = new NonPeriodical(null, null, -1, -1, -1, -1);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetAuthor01() {
        Assert.assertEquals(this.bookIncorrect.getAuthor(), "Unknown");
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetVolumeNumber01() {
        Assert.assertEquals(this.bookIncorrect.getVolumeNumber(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetVolumesNumber01() {
        Assert.assertEquals(this.bookIncorrect.getVolumesNumber(), 0);
    }

    @Test
    public void testClone() {
        NonPeriodical newNonPeriodical = new NonPeriodical("Author", "Book", 2011, 300);
        NonPeriodical clone = new NonPeriodical(newNonPeriodical);
        Assert.assertTrue(clone.equals(newNonPeriodical));
    }
}
