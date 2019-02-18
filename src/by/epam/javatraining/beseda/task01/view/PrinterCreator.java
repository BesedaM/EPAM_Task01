/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task01.view;

import java.io.PrintWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 16/02/2019
 */
public class PrinterCreator {

    public enum PrinterType {
        CONSOLE, LOGGER
    }

    private static Printer printer = null;      //Singleton pattern

    private PrinterCreator() {
    }

    public static Printer getPrinter(PrinterType type) {
        if (printer == null) {
            switch (type) {
                case CONSOLE:
                    printer = new ConsolePrinter(new PrintWriter(System.out, true));
                    break;
                case LOGGER:
                    printer = new LogPrinter(Logger.getRootLogger());
                    break;
            }
        }
        return printer;
    }
}
