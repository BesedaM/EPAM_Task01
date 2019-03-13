package by.epam.javatraining.beseda.task01.view;

/**
 * Class for creating printers
 *
 * @author Beseda
 * @version 1.0 14/03/2019
 */
public class PrinterCreator {

    private static PrinterCatalog catalog = null;

    /**
     * Creates a PrinterCatalog instance, allowing to add different printers
     *
     * @return PrinterCatalog instance
     */
    public static PrinterCatalog getPrinters() {
        if (catalog == null) {
            catalog = new PrinterCatalog();
        }
        return catalog;
    }

    /**
     * Creates a single printer
     * 
     * @param type Printer type
     * @return a printer single instance
     */
    public static Printer getSinglePrinter(PrinterType type) {
        return type.getPrinter();
    }

}
