/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task03.util;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task01.view.Printer;
import by.epam.javatraining.beseda.task01.view.PrinterCreator;
import by.epam.javatraining.beseda.task01.view.PrinterType;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class FilesCreator {

    public static void createFiles() throws PublicationContainerException {

        PublicationContainer books
                = PublicationContainerCreator
                        .createPublicationContainer(8,
                                PublicationContainerCreator.Type.BOOKSHELF);

        PublicationContainerCreator.fillPublicationContainer(books);

        Printer bPrinter = PrinterCreator.getPrinter(PrinterType.BINARY_FILE);
        Printer fPrinter = PrinterCreator.getPrinter(PrinterType.TEXT_FILE);

        for (int i = 0; i < books.publicationsNumber(); i++) {
            fPrinter.print(books.get(i).writeAllData());
            bPrinter.print(books.get(i).writeAllData());
        }

    }
}
