package by.epam.javatraining.beseda.task03.serializator;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task03.exception.ReaderCreatorTechnicalException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Beseda
 * @version 1.0 24/03/2019
 */
public class SerializableWriter {

    public static final String FILE_NAME 
            = "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_01\\SerializedData.dat";

    public static File writeData(PublicationContainer c) throws ReaderCreatorTechnicalException {
        File myFile = null;
        if (c != null) {
            myFile = new File(FILE_NAME);
            try (ObjectOutputStream stream = new ObjectOutputStream(
                    new FileOutputStream(myFile))) {
                for (int i = 0; i < c.publicationsNumber(); i++) {
                    if (c.get(i) != null) {
                        stream.writeObject(c.get(i));
                    }
                }
            } catch (IOException | PublicationContainerException ex) {
                throw new ReaderCreatorTechnicalException(ex);
            }
        }
        return myFile;
    }
}
