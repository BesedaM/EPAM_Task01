package by.epam.javatraining.beseda.task01.model.logic.calculator;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;

/**
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class NonPeriodicalTotalNumberOfPagesCalculator {

    public static int calculate(BookShelf books, String name) {
        int pages = 0;
        if (books != null && name != null) {
            for (int i = 0; i < books.getSize(); i++) {
                if (books.get(i).getName().equals(name)
                        && (books.get(i) instanceof NonPeriodical)) {
                    NonPeriodical temp = (NonPeriodical) books.get(i);
                    pages += temp.getNumberOfPages();
                    if (!temp.isMultivolume()) {
                        break;
                    }
                }
            }
        }
        return pages;
    }
}
