package by.epam.javatraining.beseda.task06.model.factory;

import by.epam.javatraining.beseda.task06.model.builder.DOMBuilder;
import by.epam.javatraining.beseda.task06.model.builder.PublicationContainerBuilder;
import by.epam.javatraining.beseda.task06.model.builder.SAXBuilder;
import by.epam.javatraining.beseda.task06.model.builder.StAXBuilder;

/**
 * Factory, creating parser
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public class PublicationBuilderFactory {

    public enum ParserType {
        DOM, SAX, StAX
    }

    public static PublicationContainerBuilder createBuilder(ParserType type) {
        PublicationContainerBuilder builder = null;
        switch (type) {
            case DOM:
                builder = DOMBuilder.getBuilder();
                break;
            case SAX:
                builder = SAXBuilder.getBuilder();
                break;
            case StAX:
                builder = StAXBuilder.getBuilder();
                break;
        }
        return builder;
    }

}
