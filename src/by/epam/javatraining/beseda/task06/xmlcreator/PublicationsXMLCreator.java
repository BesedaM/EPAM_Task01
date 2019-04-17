package by.epam.javatraining.beseda.task06.xmlcreator;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Newspaper;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.IllegalIDException;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task06.systemconfig.ProjectProperties;
import by.epam.javatraining.beseda.task06.model.builder.util.PublicationFieldEnum;
import by.epam.javatraining.beseda.task06.model.builder.util.PublicationType;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Creates xml file, containing pre-defined publications from
 * PublicationContainer object
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class PublicationsXMLCreator {

    public static String fileWholePath = ProjectProperties.DEFAULT_PROJECT_LOCATION
            + ProjectProperties.DEFAULT_XML_FILE_LOCATION + ProjectProperties.DEFAULT_FILE_NAME;

    public static String XML_SCHEMA_DEFAULT_ATTR = "xmlns:xs";
    public static String XML_CURRENT_SCHEMA_ATTR = "xmlns";
    public static String XML_SCHEMA_DEFAULT_ELEMENTS = "http://www.w3.org/2001/XMLSchema";
    public static String XML_CURRENT_SCHEMA = "http://www.example.com/publications";

    private static Logger log = null;

    static {
        log = Logger.getLogger(PublicationsXMLCreator.class.getSimpleName());
    }

    public static void createXML(String fileName) {
        DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
        DocumentBuilder dB = null;

        try {
            dB = dBF.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            log.error(ex);
        }

        Document document = dB.newDocument();
        String root = PublicationType.PUBLICATION_CONTAINER;
        Element rootElement = document.createElement(root);
        rootElement.setAttribute(XML_SCHEMA_DEFAULT_ATTR, XML_SCHEMA_DEFAULT_ELEMENTS);
        rootElement.setAttribute(XML_CURRENT_SCHEMA_ATTR, XML_CURRENT_SCHEMA);
        document.appendChild(rootElement);

        PublicationContainer container
                = PublicationContainerCreator.createPublicationContainer(
                        ProjectProperties.XML_PUBLICATIONS_NUMBER, PublicationContainerCreator.Type.BOOKSHELF);
        try {
            PublicationContainerCreator.fillPublicationContainer(container);
        } catch (PublicationContainerException ex) {
            log.error("Error in creating publication container object " + ex);
        }

        for (int i = 0; i < container.publicationsNumber(); i++) {
            Publication pub = null;
            try {
                pub = container.get(i);
                pub.setId(i + 1);
                Element publicationName = document.createElement(pub.getClass().getSimpleName());
                publicationName.setAttribute(PublicationFieldEnum.ID.getValue(), pub.getId() + "");
                rootElement.appendChild(publicationName);

                Element name = document.createElement(PublicationFieldEnum.NAME.getValue());
                name.appendChild(document.createTextNode(pub.getName()));
                publicationName.appendChild(name);

                Element year = document.createElement(PublicationFieldEnum.YEAR.getValue());
                year.appendChild(document.createTextNode(pub.getYear() + ""));
                publicationName.appendChild(year);

                Element pagesNumber = document.createElement(PublicationFieldEnum.PAGESNUMBER.getValue());
                pagesNumber.appendChild(document.createTextNode(pub.getPagesNumber() + ""));
                publicationName.appendChild(pagesNumber);

                if (pub instanceof Periodical) {
                    Element audience = document.createElement(PublicationFieldEnum.AUDIENCE.getValue());
                    audience.appendChild(document.createTextNode(((Periodical) pub).getAudience().name() + ""));
                    publicationName.appendChild(audience);

                    Element number = document.createElement(PublicationFieldEnum.NUMBER.getValue());
                    number.appendChild(document.createTextNode(((Periodical) pub).getNumber() + ""));
                    publicationName.appendChild(number);

                    Element periodicity = document.createElement(PublicationFieldEnum.PERIODICITY.getValue());
                    if (pub instanceof Newspaper) {
                        periodicity.appendChild(document.createTextNode(
                                ((Newspaper) pub).getPeriodicity().name()));
                    } else {
                        periodicity.appendChild(document.createTextNode(((Magazine) pub).getPeriodicity().name()));
                    }
                    publicationName.appendChild(periodicity);

                } else {
                    Element author = document.createElement(PublicationFieldEnum.AUTHOR.getValue());
                    author.appendChild(document.createTextNode(((NonPeriodical) pub).getAuthor()));
                    publicationName.appendChild(author);

                    if (((NonPeriodical) pub).isMultivolume()) {
                        Element volsNumber = document.createElement(PublicationFieldEnum.VOLUMESNUMBER.getValue());
                        volsNumber.appendChild(document.createTextNode(((NonPeriodical) pub).getVolumesNumber() + ""));
                        publicationName.appendChild(volsNumber);

                        Element volNumber = document.createElement(PublicationFieldEnum.VOLUMENUMBER.getValue());
                        volNumber.appendChild(document.createTextNode(((NonPeriodical) pub).getVolumeNumber() + ""));
                        publicationName.appendChild(volNumber);
                    }

                    if (pub instanceof Dictionary) {
                        Element type = document.createElement(PublicationFieldEnum.TYPE.getValue());
                        type.appendChild(document.createTextNode(((Dictionary) pub).getType().name()));
                        publicationName.appendChild(type);

                        Element publishers = document.createElement(PublicationFieldEnum.PUBLISHERS.getValue());
                        publishers.appendChild(document.createTextNode(((Dictionary) pub).getPublishers()));
                        publicationName.appendChild(publishers);

                    } else if (pub instanceof FictionLiterature) {
                        Element genre = document.createElement(PublicationFieldEnum.GENRE.getValue());
                        genre.appendChild(document.createTextNode(((FictionLiterature) pub).getGenre()));
                        publicationName.appendChild(genre);

                    } else {
                        Element field = document.createElement(PublicationFieldEnum.FIELD.getValue());
                        field.appendChild(document.createTextNode(((Manuale) pub).getField()));
                        publicationName.appendChild(field);

                        Element audience = document.createElement(PublicationFieldEnum.AUDIENCE.getValue());
                        audience.appendChild(document.createTextNode(((Manuale) pub).getAudience().name()));
                        publicationName.appendChild(audience);
                    }
                }

            } catch (PublicationContainerException ex) {
                log.error(ex);
            } catch (IllegalIDException ex) {
                log.error(ex);
            }

        }
        TransformerFactory tF = TransformerFactory.newInstance();

        try {
            Transformer transformer = tF.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result;
            if (fileName != null) {
                result = new StreamResult(
                        new FileWriter(fileName));
            } else {
                result = new StreamResult(
                        new FileWriter(fileWholePath));
            }

            transformer.transform(source, result);

        } catch (TransformerConfigurationException ex) {
            log.error(ex);
        } catch (IOException ex) {
            log.error(ex);
        } catch (TransformerException ex) {
            log.error(ex);
        }

    }
}
