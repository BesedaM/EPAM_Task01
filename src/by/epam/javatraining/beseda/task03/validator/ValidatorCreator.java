package by.epam.javatraining.beseda.task03.validator;

import by.epam.javatraining.beseda.task01.model.entity.container.HomeLibrary;
import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task03.creator.PublicationFactory;
import by.epam.javatraining.beseda.task03.exception.ReaderCreatorTechnicalException;
import by.epam.javatraining.beseda.task03.parser.StringToArrayParser;

/**
 *
 * @author Beseda
 * @version 1.0 24/03/2019
 */
public class ValidatorCreator {

    public static PublicationContainer processData(String data)
            throws ReaderCreatorTechnicalException {
        String[] objects = StringToArrayParser.getStringArray(data);

        PublicationTypeWithRegularExpression[] types
                = PublicationTypeWithRegularExpression.values();
        PublicationContainer container = new HomeLibrary();
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                for (int j = 0; j < types.length; j++) {
                    if (objects[i].trim().matches(types[j].getRegex())) {
                        try {
                            container.add(PublicationFactory.createPublication(
                                    types[j], objects[i]));
                        } catch (PublicationContainerException ex) {
                            throw new ReaderCreatorTechnicalException(ex);
                        }
                        break;
                    }
                }
            }
        }
        return container;
    }

}
