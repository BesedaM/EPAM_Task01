package by.epam.javatraining.beseda.task06.model.builder.sax.handler;

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
import by.epam.javatraining.beseda.task01.model.exception.PublicationLogicException;
import by.epam.javatraining.beseda.task01.util.PublicationContainerCreator;
import by.epam.javatraining.beseda.task06.model.builder.util.PublicationFieldEnum;
import by.epam.javatraining.beseda.task06.model.builder.util.PublicationType;
import java.util.EnumSet;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class PublicationSAXHandler extends DefaultHandler implements PublicationType {

    private static Logger log = Logger.getLogger(PublicationSAXHandler.class.getSimpleName());
    private static PublicationSAXHandler instance = null;

    private PublicationContainer container;
    private Publication publication = null;
    private PublicationFieldEnum currentEnum = null;
    private EnumSet<PublicationFieldEnum> fields;

    private PublicationSAXHandler() {
        this.container = PublicationContainerCreator.createPublicationContainer(
                10, PublicationContainerCreator.Type.HOME_LIBRARY);
        fields = EnumSet.allOf(PublicationFieldEnum.class);
    }

    public static PublicationSAXHandler getParser() {
        if (instance == null) {
            instance = new PublicationSAXHandler();
        }
        return instance;
    }

    public PublicationContainer getPublicationContainer() {
        return container;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {

        try {
            switch (localName) {
                case DICTIONARY:
                    publication = new Dictionary();
                    publication.setId(Integer.parseInt(attrs.getValue(0)));
                    break;
                case FICTION_LITERATURE:
                    publication = new FictionLiterature();                   
                    publication.setId(Integer.parseInt(attrs.getValue(0)));
                    break;
                case MANUALE:
                    publication = new Manuale();
                    publication.setId(Integer.parseInt(attrs.getValue(0)));
                    break;
                case NEWSPAPER:
                    publication = new Newspaper();
                    publication.setId(Integer.parseInt(attrs.getValue(0)));
                    break;
                case MAGAZINE:
                    publication = new Magazine();
                    publication.setId(Integer.parseInt(attrs.getValue(0)));
                    break;
                default:
                    if (!localName.equals(PUBLICATION_CONTAINER)) {
                        PublicationFieldEnum temp = PublicationFieldEnum.valueOf(localName.toUpperCase());
                        if (fields.contains(temp)) {
                            currentEnum = temp;
                        }
                    }
                    break;
            }
        } catch (IllegalIDException ex) {
            log.error("Exception was thrown parsing the XMLdocument " + ex);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        try {
            switch (localName) {
                case DICTIONARY:
                case FICTION_LITERATURE:
                case MANUALE:
                case NEWSPAPER:
                case MAGAZINE:
                    container.add(publication);
            }
        } catch (PublicationContainerException ex) {
            log.error(ex);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            try {
                switch (currentEnum) {
                    case NAME:
                        publication.setName(s);
                        break;
                    case PAGESNUMBER:
                        publication.setPagesNumber(Integer.parseInt(s));
                        break;
                    case YEAR:
                        publication.setYear(Integer.parseInt(s));
                        break;
                    case AUTHOR:
                        ((NonPeriodical) publication).setAuthor(s);
                        break;
                    case VOLUMESNUMBER:
                        ((NonPeriodical) publication).setVolumesNumber(Integer.parseInt(s));
                        break;
                    case VOLUMENUMBER:
                        ((NonPeriodical) publication).setVolumeNumber(Integer.parseInt(s));
                        break;
                    case NUMBER:
                        ((Periodical) publication).setNumber(Integer.parseInt(s));
                        break;
                    case TYPE:
                        ((Dictionary) publication).setType(Dictionary.Type.valueOf(s));
                        break;
                    case PUBLISHERS:
                        ((Dictionary) publication).setPublishers(s);
                        break;
                    case GENRE:
                        ((FictionLiterature) publication).setGenre(s);
                        break;
                    case AUDIENCE:
                        if (publication instanceof Newspaper) {
                            ((Newspaper) publication).setAudience(Newspaper.Audience.valueOf(s));
                        } else if (publication instanceof Magazine) {
                            ((Magazine) publication).setAudience(Magazine.Audience.valueOf(s));
                        } else {
                            ((Manuale) publication).setAudience(Manuale.Audience.valueOf(s));
                        }
                        break;
                    case FIELD:
                        ((Manuale) publication).setField(s);
                        break;
                    case PERIODICITY:
                        if (publication instanceof Newspaper) {
                            ((Newspaper) publication).setPeriodicity(Newspaper.Periodicity.valueOf(s));
                        } else {
                            ((Magazine) publication).setPeriodicity(Magazine.Periodicity.valueOf(s));
                        }
                        break;
                }
                currentEnum = null;
            } catch (PublicationLogicException ex) {
                log.error(ex);
            }
        }
    }
}
