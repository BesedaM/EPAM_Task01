package by.epam.javatraining.beseda.task06.controller.systemconfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * Class, referencing default system configurating properties
 *
 * @author Beseda
 * @version 1.0 17/04/2019
 */
public class ProjectProperties {

    private static final Properties PROP;
    public static int XML_PUBLICATIONS_NUMBER;
    public static String PARSER_TYPE;
    public static String DEFAULT_PROJECT_LOCATION;
    public static String DEFAULT_XML_FILE_LOCATION;
    public static String DEFAULT_FILE_NAME;
    public static String DEFAULT_XSD_SCHEMA_LOCATION;
    public static String DEFAULT_XSD_SCHEMA_NAME;

    static {
        PROP = new Properties();
        loadProperties();
        XML_PUBLICATIONS_NUMBER = Integer.parseInt(PROP.getProperty("XMLPublicationsNumber").trim());
        PARSER_TYPE = PROP.getProperty("parserType").trim();
        DEFAULT_PROJECT_LOCATION = PROP.getProperty("defaultProjectLocation").trim();
        DEFAULT_XML_FILE_LOCATION = PROP.getProperty("defaultFileLocation").trim();
        DEFAULT_FILE_NAME = PROP.getProperty("defaultFileName").trim();
        DEFAULT_XSD_SCHEMA_LOCATION = PROP.getProperty("defaultSchemaLocation").trim();
        DEFAULT_XSD_SCHEMA_NAME = PROP.getProperty("defaultSchemaName").trim();
    }

    private static void loadProperties() {
        try {
            PROP.load(new FileInputStream(
                    "src\\by\\epam\\javatraining\\beseda\\task06\\controller\\projectproperties.properties"));
        } catch (IOException ex) {
            Logger.getLogger(ProjectProperties.class.getSimpleName()).error(ex);
        }

    }
}
