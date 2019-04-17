package by.epam.javatraining.beseda.task06.model.builder;

import by.epam.javatraining.beseda.task06.model.builder.sax.handler.PublicationSAXHandler;
import by.epam.javatraining.beseda.task06.xmlcreator.PublicationsXMLCreator;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class SAXBuilder extends PublicationContainerBuilder {

    private static Logger log = Logger.getLogger(SAXBuilder.class.getSimpleName());
    private static SAXBuilder instance = null;

    private PublicationSAXHandler parser;
    private XMLReader reader;

    private SAXBuilder() {
        super();
        parser = PublicationSAXHandler.getParser();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(parser);
        } catch (SAXException ex) {
            log.error("Error creating XML reader using SAX parser: " + ex);
        }
    }

    public static SAXBuilder getBuilder() {
        if (instance == null) {
            instance = new SAXBuilder();
        }
        return instance;
    }

    @Override
    public void buildPublicationContainer(String fileName) {
        try {
            if (fileName != null) {
                reader.parse(fileName);
            } else {
                reader.parse(PublicationsXMLCreator.fileWholePath);
            }
        } catch (IOException ex) {
            log.error("Error parsing file" + fileName + ": " + ex);
        } catch (SAXException ex) {
            log.error("Error parsing file" + fileName + ": " + ex);
        }
        container = parser.getPublicationContainer();
    }
}
