package by.epam.javatraining.beseda.task01.view;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 24/03/2019
 */
public class BinaryFilePrinter implements Printer {

    public static String FILE_NAME
            = "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_01\\BinaryFile.bin";

    BufferedOutputStream writer = null;

    public BinaryFilePrinter() {
        try {
            writer = new BufferedOutputStream(new FileOutputStream(FILE_NAME, true));
        } catch (IOException ex) {
            Logger.getLogger(BinaryFilePrinter.class).fatal(ex);
        }
    }

    @Override
    public void print(Object obj) {
        try {
            byte[] arr = obj.toString().getBytes();
            writer.write(arr);
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BinaryFilePrinter.class).fatal(ex);
        }
    }

    public void print(Publication obj) {
        try {
            byte[] arr = obj.writeAllData().getBytes();
            writer.write(arr);
            writer.flush();
        } catch (IOException ex) {
            Logger.getLogger(BinaryFilePrinter.class).fatal(ex);
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
