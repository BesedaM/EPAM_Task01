package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;

/**
 *
 * @author Beseda
 * @version 1.0 06/03/2019
 */
interface PublicationContainerInterface {
    
    int publicationsNumber();
    
    int maximumCapacity();
    
    boolean add(Publication p) throws PublicationContainerException;
    
    boolean set(int index, Publication p) throws PublicationContainerException;
    
    Publication get(int index) throws PublicationContainerException;
    
    boolean remove(Publication publication);
    
    boolean contains(Publication publication);
    
    int periodicalNumber();
    
    int nonPeriodicalNumber();
    
    String allPublicationsToString();
}
