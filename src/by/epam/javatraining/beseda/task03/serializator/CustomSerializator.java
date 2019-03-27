package by.epam.javatraining.beseda.task03.serializator;

import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.PublicationLogicException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 27/03/2019
 */
public class CustomSerializator {

    public static final String FILE_NAME
            = "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_01\\Manuale.dat";

    public static void writeManale(Manuale manuale) {

        try (ObjectOutputStream oos
                = new ObjectOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(FILE_NAME)))) {

            oos.writeUTF(manuale.getAuthor());
            oos.writeUTF(manuale.getName());
            oos.writeInt(manuale.getYear());
            oos.writeInt(manuale.getPagesNumber());
            oos.writeUTF(manuale.getField());
            oos.writeUTF(manuale.getAudience().toString());

        } catch (IOException ex) {
            Logger.getLogger("CustomSerializator").error(ex);
        }

    }

    public static Manuale readManuale() {
        Manuale manuale = new Manuale();

        try (ObjectInputStream ois 
                = new ObjectInputStream(
                        new BufferedInputStream(
                                new FileInputStream(FILE_NAME)))) {

            manuale.setAuthor(ois.readUTF());
            manuale.setName(ois.readUTF());
            manuale.setYear(ois.readInt());
            manuale.setPagesNumber(ois.readInt());
            manuale.setField(ois.readUTF());
            manuale.setAudience(Manuale.Audience.valueOf(ois.readUTF()));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger("CustomSerializator").error(ex);
        } catch (IOException | PublicationLogicException ex) {
            Logger.getLogger("CustomSerializator").error(ex);
        }
        return manuale;
    }

}
