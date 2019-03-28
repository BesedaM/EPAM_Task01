package by.epam.javatraining.beseda.task03.model.reader;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.HomeLibrary;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task03.model.exception.ReaderCreatorTechnicalException;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class SerializableReader {

    public static final String FILE_PATH
            = "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_01";
    public static final String FILE_NAME = "SerializedData.dat";

    public static PublicationContainer readData(String fileName) 
            throws ReaderCreatorTechnicalException {
        File file;
        if (fileName != null) {
            file = new File(FILE_PATH, fileName);
        } else {
            file = new File(FILE_PATH, FILE_NAME);
        }
        PublicationContainer container = new HomeLibrary();
        Publication obj;

        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(file)))) {
            while (ois != null) {
                obj = (Publication) ois.readObject();
                if (obj != null) {
                    container.add(obj);
                }
            }
        } catch (EOFException ex) {
        } catch (IOException | ClassNotFoundException | PublicationContainerException ex) {
            throw new ReaderCreatorTechnicalException(ex);
        }
        return container;
    }

}
