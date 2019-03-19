package by.epam.javatraining.beseda.task01.view;

import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 * Enumeration encapsulating different printer types
 *
 * @author Beseda
 * @version 1.0 14/03/2019
 */
public enum PrinterType {

    CONSOLE(new ConsolePrinter(new PrintWriter(System.out, true))),
    LOGGER(new LogPrinter(Logger.getRootLogger())),
    FILE(new FilePrinter());

    private Printer printer;

    private PrinterType(Printer printer) {
        this.printer = printer;
    }

    /**
     * Returns a printer, encapsulated under constant
     *
     * @return Printer object
     */
    public Printer getPrinter() {
        return this.printer;
    }
}
