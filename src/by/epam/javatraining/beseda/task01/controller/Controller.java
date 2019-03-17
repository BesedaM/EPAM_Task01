package by.epam.javatraining.beseda.task01.controller;

import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.calculator.PagesNumberCalculator;
import by.epam.javatraining.beseda.task01.model.logic.finder.ConcreteValuePublicationFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.ExtremeValuePublicationFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter.ConcreteClassName;
import by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter.ConcreteName;
import by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter.PagesNumberField;
import by.epam.javatraining.beseda.task01.model.logic.finder.extremeparameter.YearField;
import by.epam.javatraining.beseda.task01.model.logic.sorter.Sorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.parameter.ClassNameSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.parameter.NameSorter;
import by.epam.javatraining.beseda.task01.model.logic.sorter.parameter.PagesNumberSorter;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task01.view.PrinterCatalog;
import by.epam.javatraining.beseda.task01.view.PrinterCreator;
import by.epam.javatraining.beseda.task01.view.PrinterType;

/**
 *
 * @author Beseda
 * @version 1.0 26/02/2019
 */
public class Controller {

    public static void main(String[] args) {

        PrinterCatalog printer = PrinterCreator.getPrinters();
        printer.addPrinter(PrinterType.CONSOLE);
        printer.addPrinter(PrinterType.LOGGER);

//        Printer printer = PrinterCatalog.getSinglePrinter(PrinterCatalog.PrinterType.CONSOLE);
        printer.print("First let's create a BookShelf of specific size "
                + "and put some books and magazines in it");
        int size;
        size = 30;
        //       size = UserInput.inputInt("Enter number of books you can put on a BookShelf: ");

        BookShelf books = (BookShelf) PublicationContainerCreator
                .createPublicationContainer(size, PublicationContainerCreator.Type.BOOKSHELF);

        try {
            PublicationContainerCreator.fillPublicationContainer(books);

            printer.print(books.allPublicationsToString());

            printer.print("Let's find the oldest publication: "
                    + ExtremeValuePublicationFinder.findMin(books, new YearField()));
            printer.print("The newest one: "
                    + ExtremeValuePublicationFinder.findMax(books, new YearField()));

            printer.print("Let's find the publication with maximum number of pages: "
                    + ExtremeValuePublicationFinder.findMax(books, new PagesNumberField()));
            printer.print("The publication with minimum number of pages: "
                    + ExtremeValuePublicationFinder.findMin(books, new PagesNumberField()));
            printer.print("");
            printer.print("Now we'll find all the publication by part of name"
                    + "(The Tower) :" + ConcreteValuePublicationFinder.find(books, new ConcreteName("The Tower")));
            printer.print("");
            printer.print("All the magazines in BookShelf: "
                    + ConcreteValuePublicationFinder.find(books, new ConcreteClassName("Magazine")));
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
