package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalNameException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalPagesNumberException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalYearException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class PublicationNGTest {

    private Publication defaultData;
    private Publication correctData;
    private Publication incorrectData;

    @BeforeGroups(groups = {"test setters"})
    public void createPublicationDefault() {
        this.defaultData = new Publication();
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalNameException.class})
    public void testSetName01() throws IllegalNameException {
        this.defaultData.setName(null);
    }

    @Test(groups = {"test setters"})
    public void testSetName02() throws IllegalNameException {
        this.defaultData.setName("any name");
        Assert.assertEquals(defaultData.getName(), "any name");
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalYearException.class})
    public void testSetYear01()
            throws IllegalYearException {
        this.defaultData.setYear(1898);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalYearException.class})
    public void testSetYear02() throws IllegalYearException {
        this.defaultData.setYear(1899);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalYearException.class})
    public void testSetYear03() throws IllegalYearException {
        this.defaultData.setYear(2020);
    }

    @Test(groups = {"test setters"})
    public void testSetYear04() throws IllegalYearException {
        this.defaultData.setYear(2010);
        Assert.assertEquals(defaultData.getYear(), 2010);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalPagesNumberException.class})
    public void testSetNumberOfPages01() throws IllegalPagesNumberException {
        this.defaultData.setPagesNumber(0);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalPagesNumberException.class})
    public void testSetPagesNumber02() throws IllegalPagesNumberException {
        this.defaultData.setPagesNumber(-1);
    }

    @Test(groups = {"test setters"})
    public void testSetPagesNumber03() throws IllegalPagesNumberException {
        this.defaultData.setPagesNumber(1);
        Assert.assertEquals(defaultData.getPagesNumber(), 1);
    }

    @Test(groups = {"test setters"})
    public void testSetPagesNumber04() throws IllegalPagesNumberException {
        this.defaultData.setPagesNumber(10);
        Assert.assertEquals(defaultData.getPagesNumber(), 10);
    }

    @BeforeGroups(groups = {"incorrect data in Constructor"})
    public void createPublicationIncorrect() {
        this.incorrectData = new Publication(null, -10, -1);
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
    public void testGetPagesNumber01() {
        Assert.assertEquals(this.incorrectData.getPagesNumber(), 0);
    }

    @BeforeGroups(groups = {"correct data in Constructor"})
    public void createPublicationCorrect() {
        this.correctData = new Publication("New publication", 1990, 200);
    }

    @Test(groups = {"correct data in Constructor"})
    public void testGetName02() {
        Assert.assertEquals(this.correctData.getName(), "New publication");
    }

    @Test(groups = {"correct data in Constructor"})
    public void testGetYear02() {
        Assert.assertEquals(this.correctData.getYear(), 1990);
    }

    @Test(groups = {"correct data in Constructor"})
    public void testGetPagesNumber02() {
        Assert.assertEquals(this.correctData.getPagesNumber(), 200);
    }

    @Test(groups = {"correct data in Constructor"})
    public void testClone() {
        Publication clone = new Publication(correctData);
        Assert.assertTrue(clone.equals(correctData));
    }

}
