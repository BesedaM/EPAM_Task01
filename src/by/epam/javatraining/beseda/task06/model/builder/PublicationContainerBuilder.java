package by.epam.javatraining.beseda.task06.model.builder;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task06.model.builder.util.PublicationType;

/**
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public abstract class PublicationContainerBuilder implements PublicationType {

    protected PublicationContainer container;

    public PublicationContainerBuilder() {
    }

    public PublicationContainer getContainer() {
        return container;
    }

    public abstract void buildPublicationContainer(String fileName);
}
