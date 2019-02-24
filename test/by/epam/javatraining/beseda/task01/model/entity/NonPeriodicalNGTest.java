package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalAuthorException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNameException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNumberOfVolumesException;
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

    NonPeriodical book;

    @BeforeGroups(groups = {"test setters"})
    public void createPeriodical() {
        this.book = new NonPeriodical();
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalNameException.class})
    public void testSetName01()
            throws IllegalNameException {
        this.book.setName(null);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalAuthorException.class})
    public void testSetAuthor01()
            throws IllegalAuthorException {
        this.book.setAuthor(null);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalVolumeNumberException.class})
    public void testSetVolumeNumber01()
            throws IllegalVolumeNumberException {
        this.book.setVolumeNumber(0);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalNumberOfVolumesException.class})
    public void testSetNumberOfVolumes01()
            throws IllegalNumberOfVolumesException {
        this.book.setNumberOfVolumes(0);
    }

    @BeforeGroups(groups = {"incorrect data in Constructor"})
    public void createPeriodicalIncorrect() {
        this.book = new NonPeriodical(null, null, -1, -1, -1, -1);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetAuthor01() {
        Assert.assertEquals(this.book.getAuthor(), "Unknown");
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetVolumeNumber01() {
        Assert.assertEquals(this.book.getVolumeNumber(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetNumberOfVolumes01() {
        Assert.assertEquals(this.book.getNumberOfVolumes(), 0);
    }
}
