package by.epam.javatraining.beseda.task06.controller;

import by.epam.javatraining.beseda.task01.model.entity.container.PublicationContainer;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.logic.calculator.PagesNumberCalculator;
import by.epam.javatraining.beseda.task01.model.logic.finder.ConcreteValuePublicationFinder;
import by.epam.javatraining.beseda.task01.model.logic.finder.concreteparameter.ConcreteName;
import by.epam.javatraining.beseda.task06.model.builder.PublicationContainerBuilder;
import by.epam.javatraining.beseda.task06.model.factory.PublicationBuilderFactory;
import by.epam.javatraining.beseda.task06.model.validator.PublicationsXMLValidator;
import by.epam.javatraining.beseda.task06.xmlcreator.PublicationsXMLCreator;
import org.apache.log4j.Logger;

/**
 *
 * @author Beseda
 * @version 1.0 17/04/2019
 */
public class Controller {

    public static void main(String[] args) {

        Logger log = Logger.getLogger(Controller.class.getSimpleName());

        log.info("First we'll create the XML file");
        PublicationsXMLCreator.createXML(null);
        log.info("Next we'll check whether it is valid. If it is valid, we'll continue working...\n");
        PublicationContainerBuilder builder = null;

        if (PublicationsXMLValidator.isValid(null)) {
            log.info("The XML file is valid");
            log.info("Creating a " + ProjectProperties.PARSER_TYPE + "parser...");
            PublicationBuilderFactory.ParserType parserType
                    = PublicationBuilderFactory.ParserType.valueOf(ProjectProperties.PARSER_TYPE);
            builder = PublicationBuilderFactory.createBuilder(parserType);
            log.info("Creating a publication container...");
            builder.buildPublicationContainer(null);
            log.info("Print out the result of parsing ...\n");
            log.info(builder.getContainer().allPublicationsToString());
        }

        log.info("The parser is Ok, let's check whether we can process the result...\n");
        PublicationContainer container = builder.getContainer();
        try {
            log.info("Calculate the number of pages of multivolume publication: "
                    + PagesNumberCalculator.calculateMultivolume(container, "Tower"));
            log.info("Find all the National Geographic magazines: \n"
                    + ConcreteValuePublicationFinder.find(container, new ConcreteName("National")));
        } catch (PublicationContainerException ex) {
            log.error(ex);
        }
    }
}
