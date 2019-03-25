/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task01.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 19/03/2019
 */
public class FilePrinter implements Printer {

    public static String FILE_NAME 
            = "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_01\\SimpleText.txt";
    
    BufferedWriter writer = null;

    public FilePrinter() {
        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
        } catch (IOException ex) {
            Logger.getLogger(FilePrinter.class).fatal(ex);
        }
    }

    @Override
    public void print(Object obj) {
        try {
            writer.write(obj.toString());
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(FilePrinter.class).fatal(ex);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (writer != null) {
            writer.close();
        }
    }

}
