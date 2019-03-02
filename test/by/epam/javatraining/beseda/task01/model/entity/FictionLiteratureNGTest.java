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
    
    @Test(groups = {"test setters"})
    public void testSetGenre02() {
        this.book.setGenre("detective");
        Assert.assertEquals(this.book.getGenre(), "detective");
    }


    @Test
    public void testGetGenre01() {
        this.book = new FictionLiterature(null, null, null, -1, -1);
        Assert.assertEquals(this.book.getGenre(), "Unknown");
    }
}
