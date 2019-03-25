package by.epam.javatraining.beseda.task03.processor;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task03.exception.ReaderCreatorException;
import by.epam.javatraining.beseda.task03.reader.BinaryFileReader;
import by.epam.javatraining.beseda.task03.util.FilesCreator;
import by.epam.javatraining.beseda.task03.validator.ValidatorCreator;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class Processor {

    public static void main(String[] args) throws PublicationContainerException {

        try {
            //creating files for processing
            FilesCreator.createFiles();

            //read one of the created files
            String data = BinaryFileReader.readFile(
                    "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_01\\BinaryFile.bin");

            //process inputData
            PublicationContainer container = ValidatorCreator.processData(data);

            Logger.getLogger("Processor").info(container.allPublicationsToString());

        } catch (ReaderCreatorException ex) {
            Logger.getLogger(Processor.class.getSimpleName()).fatal(ex);
        }

    }
}
