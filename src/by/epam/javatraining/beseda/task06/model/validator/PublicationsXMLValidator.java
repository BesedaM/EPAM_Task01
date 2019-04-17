package by.epam.javatraining.beseda.task06.model.validator;

import by.epam.javatraining.beseda.task06.controller.systemconfig.ProjectProperties;
import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.validation.Validator;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * The aim of the class is to supply functionality for defining whether the
 * input xml file, containing Publication objects, is valid
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class PublicationsXMLValidator {

    public static String fileWholePath = ProjectProperties.DEFAULT_PROJECT_LOCATION
            + ProjectProperties.DEFAULT_XML_FILE_LOCATION + ProjectProperties.DEFAULT_FILE_NAME;
    public static String schemaWholePath = ProjectProperties.DEFAULT_PROJECT_LOCATION
            + ProjectProperties.DEFAULT_XSD_SCHEMA_LOCATION + ProjectProperties.DEFAULT_XSD_SCHEMA_NAME;

    private static Logger log = Logger.getLogger(Validator.class.getSimpleName());

    public static boolean isValid(String fileName) {
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        File schemaLoc = new File(schemaWholePath);

        try {
            Schema schema = factory.newSchema(schemaLoc);
            Validator validator = schema.newValidator();
            Source source;
            if (fileName != null) {
                source = new StreamSource(fileName);
            } else {
                source = new StreamSource(fileWholePath);
            }
            validator.validate(source);
            log.info("Input file is valid");
            return true;
        } catch (SAXException ex) {
            log.warn("Input file is not valid because of\n" + ex.getMessage());
        } catch (IOException ex) {
            log.error(ex);
        }
        return false;
    }
}
