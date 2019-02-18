/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task01.view;

import java.io.PrintWriter;

/**
 *
 * @author Beseda
 * @version 1.0 16/02/2019
 */
public class ConsolePrinter implements Printer {

    private PrintWriter printer;

    ConsolePrinter(PrintWriter out) {
        printer = out;
    }

    @Override
    public void print(Object obj) {
        printer.println(obj.toString());
    }
}
