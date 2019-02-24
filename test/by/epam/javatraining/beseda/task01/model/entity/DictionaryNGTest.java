package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalTypeException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


/**
 *
 * @author Beseda
 * @version 1.0 25/02/2019
 */
public class DictionaryNGTest {

    Dictionary book;

    @BeforeGroups(groups = {"test setters"})
    public void createDictionaryDefault() {
        this.book = new Dictionary();
    }

    @Test(groups = {"test setters"}, expectedExceptions = {IllegalTypeException.class})
    public void testSetType01()
            throws IllegalTypeException {
        this.book.setType(null);
    }

    @Test(groups = {"test setters"})
    public void testSetPublishers01() {
        this.book.setPublishers(null);
        Assert.assertEquals(this.book.getPublishers(), "Unknown");
    }

    @BeforeGroups(groups = {"incorrect data in constructor"})
    public void createDictionaryIncorrect() {
        this.book = new Dictionary(null, null, null, null, -1, -1);
    }

    @Test(groups = {"incorrect data in constructor"})
    public void testGetType01() {
        Assert.assertEquals(this.book.getType(), Dictionary.Type.BILINGUAL);
    }

    @Test(groups = {"incorrect data in constructor"})
    public void testGetPublishers01() {
        Assert.assertEquals(this.book.getPublishers(), "Unknown");
    }
}
