package by.epam.javatraining.beseda.task01.model.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class FictionLiteratureNGTest {

    FictionLiterature book;

    @BeforeGroups(groups = {"test setters"})
    public void createFictionLiteratureDefault() {
        this.book = new FictionLiterature();
    }

    @Test(groups = {"test setters"})
    public void testSetGenre01() {
        this.book.setGenre(null);
        Assert.assertEquals(this.book.getGenre(), "Unknown");
    }

    @BeforeGroups(groups = {"incorrect data in constructor"})
    public void createFictionLiteratureIncorrect() {
        this.book = new FictionLiterature(null, null, null, -1, -1);
    }

    @Test(groups = {"incorrect data in constructor"})
    public void testGetGenre01() {
        Assert.assertEquals(this.book.getGenre(), "Unknown");
    }
}
