package by.epam.javatraining.beseda.task01.controller;

import by.epam.javatraining.beseda.task01.model.entity.BookShelf;
import by.epam.javatraining.beseda.task01.model.logic.calculator.NumberOfPagesCalculator;
import by.epam.javatraining.beseda.task01.model.logic.finder.ClassNameFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.DateFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.NameFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.NumberOfPagesFinder;
import by.epam.javatraining.beseda.task01.model.logic.sorter.Sorter;
import by.epam.javatraining.beseda.task01.util.BookShelfCreator;
import by.epam.javatraining.beseda.task01.util.UserInput;
import by.epam.javatraining.beseda.task01.view.Printer;
import by.epam.javatraining.beseda.task01.view.PrinterCreator;

/**
 *
 * @author Beseda
 * @version 1.0 26/02/2019
 */
public class Controller {

    public static void main(String[] args) {

        Printer printer = PrinterCreator.getPrinter(PrinterCreator.PrinterType.CONSOLE);

        printer.print("First let's create a BookShelf of specific size "
                + "and put some books and magazines in it");
        int size;
        size = 30;
        size= UserInput.inputInt("Enter number of books you can put on a BookShelf: ");

        BookShelf books = BookShelfCreator.createBookShelf(size);
        BookShelfCreator.fillBookShelf(books);

        printer.print(books.getAllPublications());

        printer.print("Let's find the oldest publication: "
                + DateFinder.findOldest(books));
        printer.print("The newest one: "
                + DateFinder.findNewest(books));

        printer.print("Let's find the publication with maximum number of pages: "
                + NumberOfPagesFinder.findMax(books));
        printer.print("The publication with minimum number of pages: "
                + NumberOfPagesFinder.findMin(books));
        printer.print("");
        printer.print("Now we'll find all the publication by part of name"
                + "(The Tower) :" + NameFinder.find(books, "Dark Tower"));
        printer.print("");
        printer.print("All the magazines in BookShelf: "
                + ClassNameFinder.find(books, "Magazine"));
        printer.print("");
        printer.print("We have a multivolume publication on a BookShelf "
                + "The Dark Tower" + ", the total number of pages in the BookShelf is "
                + NumberOfPagesCalculator.calculateMultivolume(books, "The Dark Tower"));
        printer.print("");
        
        printer.print("Now we'll try to sort publications in the BookShelf"
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
