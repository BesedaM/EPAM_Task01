package by.epam.javatraining.beseda.task03.creator;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Newspaper;
import by.epam.javatraining.beseda.task01.model.entity.NullPublication;
import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task03.parser.PublicationParser;
import by.epam.javatraining.beseda.task03.validator.PublicationTypeWithRegularExpression;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class PublicationFactory {

    public static Publication createPublication(
            PublicationTypeWithRegularExpression type, String data) {
        Publication publication = new NullPublication();
        if (type != null && data != null) {
            String[] pData = PublicationParser.parse(data);
            Publication part
                    = new Publication(pData[0], Integer.parseInt(pData[1]),
                            Integer.parseInt(pData[2]));
            switch (type) {
                case FICTION_LITERATURE: {
                    publication = new FictionLiterature(part, pData[3],
                            Integer.parseInt(pData[4]), Integer.parseInt(pData[5]),
                            pData[6]);
                    break;
                }
                case DICTIONARY: {
                    publication = new Dictionary(part, pData[3],
                            Integer.parseInt(pData[4]), Integer.parseInt(pData[5]),
                            Dictionary.Type.valueOf(pData[6]), pData[7]);
                    break;
                }
                case MANUALE: {
                    publication = new Manuale(part, pData[3],
                            Integer.parseInt(pData[4]), Integer.parseInt(pData[5]),
                            pData[6], Manuale.Audience.valueOf(pData[7]));
                    break;
                }
                case MAGAZINE: {
                    publication = new Magazine(part, Integer.parseInt(pData[3]),
                            Periodical.Audience.valueOf(pData[4]),
                            Magazine.Periodicity.valueOf(pData[5]));
                    break;
                }
                case NEWSPAPER: {
                    publication = new Newspaper(part, Integer.parseInt(pData[3]),
                            Periodical.Audience.valueOf(pData[4]),
                            Newspaper.Periodicity.valueOf(pData[5]));
                    break;
                }
            }
        }
        return publication;
    }

}
