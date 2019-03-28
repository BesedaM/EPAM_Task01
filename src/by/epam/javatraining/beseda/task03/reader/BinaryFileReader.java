package by.epam.javatraining.beseda.task03.reader;

import by.epam.javatraining.beseda.task03.exception.ReaderCreatorTechnicalException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Beseda
 * @version 1.0 24/03/2019
 */
public class BinaryFileReader {

    public static String readFile(String fileName) throws ReaderCreatorTechnicalException {
        byte[] arr;
        File file;
        String str = null;

        try (BufferedInputStream stream = new BufferedInputStream(
                new FileInputStream(file = new File(fileName)))) {
            arr = new byte[(int) file.length()];
            stream.read(arr);
            str = new String(arr, "UTF-8");
        } catch (IOException ex) {
            throw new ReaderCreatorTechnicalException(ex);
        }

        return str;
    }

}
