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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class StAXBuilder extends PublicationContainerBuilder {

    private static StAXBuilder instance = null;
    private static Logger log = Logger.getLogger(StAXBuilder.class.getSimpleName());

    private XMLInputFactory inputFactory;

    public StAXBuilder() {
        container = PublicationContainerCreator.createPublicationContainer(
                10, PublicationContainerCreator.Type.HOME_LIBRARY);
        inputFactory = XMLInputFactory.newInstance();
    }

    public static StAXBuilder getBuilder() {
        if (instance == null) {
            instance = new StAXBuilder();
        }
        return instance;
    }

    @Override
    public void buildPublicationContainer(String fileName) {

        FileInputStream is = null;
        XMLStreamReader reader = null;
        String name;

        try {
            if (fileName != null) {
                is = new FileInputStream(new File(fileName));
            } else {
                is = new FileInputStream(new File(PublicationsXMLCreator.fileWholePath));
            }
            reader = inputFactory.createXMLStreamReader(is);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    switch (name) {
                        case DICTIONARY:
                        case FICTION_LITERATURE:
                        case MANUALE:
                        case MAGAZINE:
                        case NEWSPAPER:
                            Publication pub = buildPublication(reader);
                            container.add(pub);
                            break;
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            log.error(ex);
        } catch (XMLStreamException ex) {
            log.error("StAX parsing error " + ex);
        } catch (PublicationContainerException ex) {
            log.error("Error adding Publication object to contaimner " + ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    log.error(ex);
                }
            }
        }
    }

    private Publication buildPublication(XMLStreamReader reader) throws XMLStreamException {

        Publication publication = null;

        switch (reader.getLocalName()) {
            case DICTIONARY:
                publication = new Dictionary();
                break;
            case FICTION_LITERATURE:
                publication = new FictionLiterature();
                break;
            case MANUALE:
                publication = new Manuale();
                break;
            case MAGAZINE:
                publication = new Magazine();
                break;
            case NEWSPAPER:
                publication = new Newspaper();
                break;
        }

        try {
            publication.setId(Integer.parseInt(
                    reader.getAttributeValue(null, PublicationFieldEnum.ID.getValue())));
            String name;
            while (reader.hasNext()) {
                int type = reader.next();
                name = reader.getLocalName();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        switch (PublicationFieldEnum.valueOf(name.toUpperCase())) {
                            case NAME:
                                publication.setName(getXMLText(reader));
                                break;
                            case PAGESNUMBER:
                                publication.setPagesNumber(Integer.parseInt(getXMLText(reader)));
                                break;
                            case YEAR:
                                publication.setYear(Integer.parseInt(getXMLText(reader)));
                                break;
                            case AUTHOR:
                                ((NonPeriodical) publication).setAuthor(getXMLText(reader));
                                break;
                            case VOLUMESNUMBER:
                                ((NonPeriodical) publication).setVolumesNumber(
                                        Integer.parseInt(getXMLText(reader)));
                                break;
                            case VOLUMENUMBER:
                                ((NonPeriodical) publication).setVolumeNumber(
                                        Integer.parseInt(getXMLText(reader)));
                                break;
                            case NUMBER:
                                ((Periodical) publication).setNumber(
                                        Integer.parseInt(getXMLText(reader)));
                                break;
                            case TYPE:
                                ((Dictionary) publication).setType(
                                        Dictionary.Type.valueOf(getXMLText(reader)));
                                break;
                            case PUBLISHERS:
                                ((Dictionary) publication).setPublishers(getXMLText(reader));
                                break;
                            case GENRE:
                                ((FictionLiterature) publication).setGenre(getXMLText(reader));
                                break;
                            case AUDIENCE:
                                if (publication instanceof Newspaper) {
                                    ((Newspaper) publication).setAudience(
                                            Newspaper.Audience.valueOf(getXMLText(reader)));
                                } else if (publication instanceof Magazine) {
                                    ((Magazine) publication).setAudience(
                                            Magazine.Audience.valueOf(getXMLText(reader)));
                                } else {
                                    ((Manuale) publication).setAudience(
                                            Manuale.Audience.valueOf(getXMLText(reader)));
                                }
                                break;
                            case FIELD:
                                ((Manuale) publication).setField(getXMLText(reader));
                                break;
                            case PERIODICITY:
                                if (publication instanceof Newspaper) {
                                    ((Newspaper) publication).setPeriodicity(
                                            Newspaper.Periodicity.valueOf(getXMLText(reader)));
                                } else {
                                    ((Magazine) publication).setPeriodicity(
                                            Magazine.Periodicity.valueOf(getXMLText(reader)));
                                }
                                break;
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        switch (name) {
                            case DICTIONARY:
                            case FICTION_LITERATURE:
                            case MANUALE:
                            case NEWSPAPER:
                            case MAGAZINE:
                                return publication;
                        }
                        break;
                }
            }
        } catch (PublicationLogicException ex) {
            log.error("Error while setting data to object: " + ex);
        } catch (XMLStreamException ex) {
            log.error("Unknown element in tag: " + ex);
        }
        throw new XMLStreamException("Unknown element in tag");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            if (reader.hasText()) {
                text = reader.getText();
            } else {
                text = "";
            }
        }
        return text;
    }

}
