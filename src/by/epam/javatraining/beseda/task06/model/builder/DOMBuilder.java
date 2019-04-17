package by.epam.javatraining.beseda.task06.model.builder;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Newspaper;
import by.epam.javatraining.beseda.task01.model.entity.NonPeriodical;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.exception.PublicationLogicException;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task06.model.builder.util.PublicationFieldEnum;
import by.epam.javatraining.beseda.task06.xmlcreator.PublicationsXMLCreator;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class DOMBuilder extends PublicationContainerBuilder {

    private static Logger log = Logger.getLogger(DOMBuilder.class.getSimpleName());
    private static DOMBuilder instance = null;

    private DocumentBuilder docBuilder;

    private DOMBuilder() {
        super();
        container = PublicationContainerCreator.createPublicationContainer(
                10, PublicationContainerCreator.Type.HOME_LIBRARY);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            log.error("Parser configuration exception: " + ex);
        }
    }

    public static DOMBuilder getBuilder() {
        if (instance == null) {
            instance = new DOMBuilder();
        }
        return instance;
    }

    @Override
    public void buildPublicationContainer(String fileName) {
        try {
            Document doc;
            if (fileName != null) {
                doc = docBuilder.parse(fileName);
            } else {
                doc = docBuilder.parse(PublicationsXMLCreator.fileWholePath);
            }
            Element root = doc.getDocumentElement();
            NodeList publications = root.getChildNodes();
            for (int i = 0; i < publications.getLength(); i++) {
                Publication pub = buildPublication((Element) publications.item(i));
                container.add(pub);
            }
        } catch (SAXException ex) {
            log.error("Parsing failure: " + ex);
        } catch (IOException ex) {
            log.error("File error or IO error: " + ex);
        } catch (PublicationContainerException ex) {
            log.error("Error adding a publication to container: " + ex);
        }
    }

    private Publication buildPublication(Element element) {
        Publication pub = null;
        switch (element.getTagName()) {
            case DICTIONARY:
                pub = new Dictionary();
                break;
            case FICTION_LITERATURE:
                pub = new FictionLiterature();
                break;
            case MANUALE:
                pub = new Manuale();
                break;
            case MAGAZINE:
                pub = new Magazine();
                break;
            case NEWSPAPER:
                pub = new Newspaper();
                break;
        }

        try {
            pub.setId(Integer.parseInt(element.getAttribute(PublicationFieldEnum.ID.getValue())));
            pub.setName(getElementTextContent(element, PublicationFieldEnum.NAME.getValue()));
            pub.setPagesNumber(getElementIntegerContent(element, PublicationFieldEnum.PAGESNUMBER.getValue()));
            pub.setYear(getElementIntegerContent(element, PublicationFieldEnum.YEAR.getValue()));

            if (pub instanceof Periodical) {
                ((Periodical) pub).setAudience(Periodical.Audience.valueOf(
                        getElementTextContent(element, PublicationFieldEnum.AUDIENCE.getValue())));
                ((Periodical) pub).setNumber(getElementIntegerContent(
                        element, PublicationFieldEnum.NUMBER.getValue()));
            } else {
                ((NonPeriodical) pub).setAuthor(getElementTextContent(
                        element, PublicationFieldEnum.AUTHOR.getValue()));
                if (element.getElementsByTagName(PublicationFieldEnum.VOLUMESNUMBER.getValue()).getLength() > 0) {
                    ((NonPeriodical) pub).setVolumesNumber(getElementIntegerContent(
                            element, PublicationFieldEnum.VOLUMESNUMBER.getValue()));
                    ((NonPeriodical) pub).setVolumeNumber(getElementIntegerContent(
                            element, PublicationFieldEnum.VOLUMENUMBER.getValue()));
                }
            }

            if (pub instanceof Dictionary) {
                ((Dictionary) pub).setType(Dictionary.Type.valueOf(
                        getElementTextContent(element, PublicationFieldEnum.TYPE.getValue())));
                ((Dictionary) pub).setPublishers(getElementTextContent(
                        element, PublicationFieldEnum.PUBLISHERS.getValue()));
            } else if (pub instanceof FictionLiterature) {
                ((FictionLiterature) pub).setGenre(getElementTextContent(
                        element, PublicationFieldEnum.GENRE.getValue()));
            } else if (pub instanceof Manuale) {
                ((Manuale) pub).setAudience(Manuale.Audience.valueOf(getElementTextContent(
                        element, PublicationFieldEnum.AUDIENCE.getValue())));
                ((Manuale) pub).setField(getElementTextContent(
                        element, PublicationFieldEnum.FIELD.getValue()));
            } else if (pub instanceof Newspaper) {
                ((Newspaper) pub).setPeriodicity(Newspaper.Periodicity.valueOf(
                        getElementTextContent(element, PublicationFieldEnum.PERIODICITY.getValue())));
            } else {
                ((Magazine) pub).setPeriodicity(Magazine.Periodicity.valueOf(
                        getElementTextContent(element, PublicationFieldEnum.PERIODICITY.getValue())));
            }
        } catch (PublicationLogicException ex) {
            log.error("Error setting values to publication fields: " + ex);
        }

        return pub;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList list = element.getElementsByTagName(elementName);
        Node node = list.item(0);
        return node.getTextContent();
    }

    private int getElementIntegerContent(Element element, String elementName) {
        return Integer.parseInt(getElementTextContent(element, elementName));
    }
}
