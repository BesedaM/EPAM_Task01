package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalPublishersException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalTypeException;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.DataProvider;
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
    public void testSetType01() throws IllegalTypeException {
        this.book.setType(null);
    }

    @Test(groups = {"test setters"}, expectedExceptions = IllegalPublishersException.class)
    public void testSetPublishers01() throws IllegalPublishersException {
        this.book.setPublishers(null);
    }

    @Test(groups = {"test setters"})
    public void testSetPublishers02() throws IllegalPublishersException {
        this.book.setPublishers("word");
        Assert.assertEquals(this.book.getPublishers(), "word");
    }

    @DataProvider(name = "incorrect data in constructor")
    public Object[][] createDictionaryIncorrect() {
        return new Object[][]{{new Dictionary(null, null, null, null, -1, -1)}};
    }

    @Test(dataProvider = "incorrect data in constructor")
    public void testGetType01(Dictionary dictionary) {
        Assert.assertEquals(dictionary.getType(), Dictionary.Type.BILINGUAL);
    }

    @Test(dataProvider = "incorrect data in constructor")
    public void testGetPublishers01(Dictionary dictionary) {
        Assert.assertEquals(dictionary.getPublishers(), "Unknown");
    }
}
