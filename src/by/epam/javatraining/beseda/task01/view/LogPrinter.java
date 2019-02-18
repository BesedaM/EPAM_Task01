/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task01.view;

import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 16/02/2019
 */
public class LogPrinter implements Printer {

    private Logger logger;

    LogPrinter(Logger log) {
        logger = log;
    }

    @Override
    public void print(Object obj) {
        logger.info(obj.toString());
    }
}
