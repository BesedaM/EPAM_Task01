package by.epam.javatraining.beseda.task03.reader;

import by.epam.javatraining.beseda.task03.exception.ReaderCreatorTechnicalException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Beseda
 * @version 1.0 23/03/2019
 */
public class TextFileReader {

    public static String readFile(String fileName) throws ReaderCreatorTechnicalException {
        String temp;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((temp = reader.readLine()) != null) {
                sb.append(temp);
            }
        } catch (IOException ex) {
            throw new ReaderCreatorTechnicalException(ex);
        }

        return sb.toString();
    }

}
