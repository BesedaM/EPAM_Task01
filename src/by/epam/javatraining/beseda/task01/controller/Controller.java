package by.epam.javatraining.beseda.task01.controller;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.logic.calculator.MultivolumeTotalNumberOfPagesCalculator;
import by.epam.javatraining.beseda.task01.model.logic.finder.PublicationByClassNameFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.PublicationByDateFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.PublicationByExtremeValueFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.PublicationByNameFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.PublicationByNumberOfPagesFinder;
import by.epam.javatraining.beseda.task01.model.logic.sorter.Sorter;
import by.epam.javatraining.beseda.task01.util.BookShelfCreator;
import by.epam.javatraining.beseda.task01.util.UserInput;
import by.epam.javatraining.beseda.task01.view.Printer;
import by.epam.javatraining.beseda.task01.view.PrinterCreator;

/**
 *
 * @author Beseda
 * @version 1.0 22/02/2019
 */
public class Controller {

    public static void main(String[] args) {

        Printer printer = PrinterCreator.getPrinter(PrinterCreator.PrinterType.CONSOLE);

        printer.print("First let's create a BookShelf of specific size "
                + "and put some books and magazines in it");
        int size;
        size = 30;
//                size= UserInput.inputInt("Enter number of books you can put on a BookShelf: ");

        BookShelf books = BookShelfCreator.createBookShelf(size);
        BookShelfCreator.fillBookShelf(books);

        printer.print(books.getAllPublications());

        printer.print("Let's find the oldest publication: "
                + PublicationByDateFinder.findOldest(books));
        printer.print("The newest one: "
                + PublicationByDateFinder.findNewest(books));

        printer.print("Let's find the publication with maximum number of pages: "
                + PublicationByNumberOfPagesFinder.findMax(books));
        printer.print("The publication with minimum number of pages: "
                + PublicationByNumberOfPagesFinder.findMin(books));

        printer.print("Let's find the first publication we put on the shelf: "
                + PublicationByExtremeValueFinder.findMin(books,
                        PublicationByExtremeValueFinder.ORDER_OF_APPEARENCE));
        printer.print("The last publication we put on the shelf: "
                + PublicationByExtremeValueFinder.findMax(books,
                        PublicationByExtremeValueFinder.ORDER_OF_APPEARENCE));

        printer.print("Now we'll find all the publication by part of name"
                + "(The Tower) :" + PublicationByNameFinder.find(books, "Dark Tower"));

        printer.print("All the magazines in BookShelf: "
                + PublicationByClassNameFinder.find(books, "Magazine"));

        printer.print("We have a multivolume publication on a BookShelf "
                + "The Dark Tower" + ", the total number of pages in the BookShelf is "
                + MultivolumeTotalNumberOfPagesCalculator.calculate(books, "The Dark Tower"));

        printer.print("\nNow we'll try to sort publications in the BookShelf"
                + " by different conditions...");
        printer.print("Sort by class name: ");
        Sorter.sort(books, Sorter.CLASS_NAME_SORTER);
        printer.print(books.getAllPublications());

        printer.print("Sort by name: ");
        Sorter.sort(books, Sorter.NAME_SORTER);
        printer.print(books.getAllPublications());
        printer.print("Sort by name: ");
        Sorter.sort(books, Sorter.NAME_SORTER);
        printer.print(books.getAllPublications());
        printer.print("Sort by publications name dividing the data into "
                + "two parts (Periodical and NonPeriodical): ");
        Sorter.sortApartPeriodicalAndNonPeriodical(books, Sorter.NAME_SORTER);
        printer.print(books.getAllPublications());
        printer.print("Sort by number of pages dividing the data into "
                + "two parts (Periodical and NonPeriodical): ");
        Sorter.sortApartPeriodicalAndNonPeriodical(books, Sorter.NUMBER_OF_PAGES_SORTER);
        printer.print(books.getAllPublications());

    }
}
