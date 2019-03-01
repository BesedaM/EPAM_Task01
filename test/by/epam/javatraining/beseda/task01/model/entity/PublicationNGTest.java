package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalNameException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNumberOfPagesException;
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

    Publication publication;
    Publication correctData;

    @BeforeGroups(groups = {"test setters"})
    public void createPublicationDefault() {
        this.publication = new Publication();
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalNameException.class})
    public void testSetName01()
            throws IllegalNameException {
        this.publication.setName(null);
    }

    @Test(groups = {"test setters"})
    public void testSetName02()
            throws IllegalNameException {
        this.publication.setName("any name");
        Assert.assertEquals(publication.getName(), "any name");
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalYearException.class})
    public void testSetYear01()
            throws IllegalYearException {
        this.publication.setYear(1898);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalYearException.class})
    public void testSetYear02()
            throws IllegalYearException {
        this.publication.setYear(1899);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalYearException.class})
    public void testSetYear03()
            throws IllegalYearException {
        this.publication.setYear(2020);
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalYearException.class})
    public void testSetYear04()
            throws IllegalYearException {
        this.publication.setYear(2031);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalNumberOfPagesException.class})
    public void testSetNumberOfPages01()
            throws IllegalNumberOfPagesException {
        this.publication.setNumberOfPages(0);
    }

    @Test(groups = {"test setters"},
            expectedExceptions = {IllegalNumberOfPagesException.class})
    public void testSetNumberOfPages02()
            throws IllegalNumberOfPagesException {
        this.publication.setNumberOfPages(-1);
    }

    @Test(groups = {"test setters"})
    public void testSetNumberOfPages03()
            throws IllegalNumberOfPagesException {
        this.publication.setNumberOfPages(1);
        Assert.assertEquals(publication.getNumberOfPages(), 1);
    }

    @Test(groups = {"test setters"})
    public void testSetNumberOfPages04()
            throws IllegalNumberOfPagesException {
        this.publication.setNumberOfPages(10);
        Assert.assertEquals(publication.getNumberOfPages(), 10);
    }

    @BeforeGroups(groups = {"incorrect data in Constructor"})
    public void createPublicationIncorrect() {
        this.publication = new Publication(null, -10, -1);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetName01() {
        Assert.assertEquals(this.publication.getName(), "Unknown");
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetYear01() {
        Assert.assertEquals(this.publication.getYear(), 0);
    }

    @Test(groups = {"incorrect data in Constructor"})
    public void testGetNumberOfPages01() {
        Assert.assertEquals(this.publication.getNumberOfPages(), 0);
    }

    @BeforeGroups(groups = {"correct data in Constructor"})
    public void createPublicationCorrect() {
        this.correctData = new Publication("New publication", 1990, 20);
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
    public void testGetNumberOfPages02() {
        Assert.assertEquals(this.correctData.getNumberOfPages(), 20);
    }

}
