package by.epam.javatraining.beseda.task03.processor;

import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.container.BookShelf;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task03.model.exception.ReaderCreatorException;
import by.epam.javatraining.beseda.task03.model.exception.ReaderCreatorTechnicalException;
import by.epam.javatraining.beseda.task03.model.reader.SerializableReader;
import by.epam.javatraining.beseda.task03.model.serializator.CustomSerializator;
import by.epam.javatraining.beseda.task03.model.serializator.SerializableWriter;
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
            throw new ReaderCreatorTechnicalException(ex);
        }

        SerializableWriter.writeData(books, null);
        serializedBooks = SerializableReader.readData(null);

        Logger.getLogger("SerializatorTest").info(serializedBooks.allPublicationsToString());

        //Now we'll try to serialize and deserialize one book (Manuale) with custom object serialization
        PublicationContainer dManuale;
        PublicationContainer books2 = new BookShelf(5);
        try {
            books2.add(new Manuale("Paulina Christensen, Wendy Foster, Anne Fox",
                    "German for dummies", 2000, 384, "linguistics", Manuale.Audience.BEGINNER));
        } catch (PublicationContainerException ex) {
            throw new ReaderCreatorTechnicalException(ex);
        }

        SerializableWriter.writeData(books2, "SerializedManuale.dat");
        dManuale = SerializableReader.readData("SerializedManuale.dat");

        Logger.getLogger("SerializatorTest").info(books2.allPublicationsToString()
                + "\n" + dManuale.allPublicationsToString());

        //test CustomSerializator
        Manuale manuale = new Manuale("Paulina Christensen, Wendy Foster, Anne Fox",
                "German for dummies", 2000, 384, "linguistics", Manuale.Audience.BEGINNER);
        Manuale temp;
        CustomSerializator.writeManale(manuale);
        temp = CustomSerializator.readManuale();
        
        Logger.getLogger("SerializatorTest").info(manuale.equals(temp));
    }
}
