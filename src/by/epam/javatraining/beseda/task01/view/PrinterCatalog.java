package by.epam.javatraining.beseda.task01.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Container class for all used printers in program
 *
 * @author Beseda
 * @version 1.0 14/03/2019
 */
public class PrinterCatalog {

    private static List<Printer> catalog = null;

    PrinterCatalog() {
        catalog = new ArrayList<>();
    }

    /**
     * Sets a main command to print to all the catalog. Notifies all the
     * printers about the print command
     *
     * @param obj Input object to print
     */
    public void print(Object obj) {
        notifyAllPrinters(obj);
    }

    /**
     * Adds a new printer to catalog
     *
     * @param printer Input printer type
     */
    public void addPrinter(PrinterType printer) {
        if (!catalog.contains(printer.getPrinter())) {
            catalog.add(printer.getPrinter());
        }
    }

    /**
     * Sets a command to all the printers to print
     *
     * @param obj Object to print
     */
    public void notifyAllPrinters(Object obj) {
        for (Printer printer : catalog) {
            printer.print(obj);
        }
    }

}
