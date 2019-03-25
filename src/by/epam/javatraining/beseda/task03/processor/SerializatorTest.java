package by.epam.javatraining.beseda.task03.processor;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task03.exception.ReaderCreatorException;
import by.epam.javatraining.beseda.task03.reader.ObjectsReader;
import by.epam.javatraining.beseda.task03.serializator.SerializableWriter;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class SerializatorTest {

    public static void main(String[] args) throws ReaderCreatorException {

        PublicationContainer serializedBooks;
        PublicationContainer books;
        try {
            books = PublicationContainerCreator
                    .createPublicationContainer(8,
                            PublicationContainerCreator.Type.BOOKSHELF);

            PublicationContainerCreator.fillPublicationContainer(books);
        } catch (PublicationContainerException ex) {
            throw new ReaderCreatorException();
        }

        SerializableWriter.writeData(books);
        serializedBooks = ObjectsReader.readData(null);
        
        Logger.getLogger("SerializatorTest").info(serializedBooks.allPublicationsToString());

    }
}
