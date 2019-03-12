package by.epam.javatraining.beseda.task01.controller;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.calculator.PagesNumberCalculator;
import by.epam.javatraining.beseda.task01.model.logic.finder.CertainValueFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.OldestNewestDateFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.MinMaxPagesNumberFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter.ClassName;
import by.epam.javatraining.beseda.task01.model.logic.finder.certainparameter.Name;
import by.epam.javatraining.beseda.task01.model.logic.sorter.Sorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.ClassNameSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.NameSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.sortable.PagesNumberSorter;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
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
 //       size = UserInput.inputInt("Enter number of books you can put on a BookShelf: ");

        BookShelf books = (BookShelf)PublicationContainerCreator
                .createPublicationContainer(size,PublicationContainerCreator.Type.BOOKSHELF);

        try {
            PublicationContainerCreator.fillPublicationContainer(books);

            printer.print(books.allPublicationsToString());

            printer.print("Let's find the oldest publication: "
                    + OldestNewestDateFinder.findOldest(books));
            printer.print("The newest one: "
                    + OldestNewestDateFinder.findNewest(books));

            printer.print("Let's find the publication with maximum number of pages: "
                    + MinMaxPagesNumberFinder.findMax(books));
            printer.print("The publication with minimum number of pages: "
                    + MinMaxPagesNumberFinder.findMin(books));
            printer.print("");
            printer.print("Now we'll find all the publication by part of name"
                    + "(The Tower) :" + CertainValueFinder.find(books, new Name("The Tower")));
            printer.print("");
            printer.print("All the magazines in BookShelf: "
                    + CertainValueFinder.find(books, new ClassName("Magazine")));
            printer.print("");
            printer.print("We have a multivolume publication on a BookShelf "
                    + "The Dark Tower" + ", the total number of pages in the BookShelf is "
                    + PagesNumberCalculator.calculateMultivolume(books, "The Dark Tower"));
            printer.print("");

            printer.print("Now we'll try to sort publications in the BookShelf"
                    + " by different conditions...");
            printer.print("Sort by class name: ");
            Sorter.sort(books, new ClassNameSorter());
            printer.print(books.allPublicationsToString());

            printer.print("Sort by name: ");
            Sorter.sort(books, new NameSorter());
            printer.print(books.allPublicationsToString());
            printer.print("Sort by number of pages: ");
            Sorter.sort(books, new PagesNumberSorter());
            printer.print(books.allPublicationsToString());
            printer.print("Sort by publications name dividing the data into "
                    + "two parts (Periodical and NonPeriodical): ");
            Sorter.sortApartPeriodicalAndNonPeriodical(books, new NameSorter());
            printer.print(books.allPublicationsToString());
            printer.print("Sort by number of pages dividing the data into "
                    + "two parts (Periodical and NonPeriodical): ");
            Sorter.sortApartPeriodicalAndNonPeriodical(books, new PagesNumberSorter());
            printer.print(books.allPublicationsToString());
        } catch (PublicationContainerException e) {
            printer.print(e);
        }
    }
}
