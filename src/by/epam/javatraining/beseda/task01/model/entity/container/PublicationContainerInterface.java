package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;

/**
 *
 * @author Beseda
 * @version 1.1 12/03/2019
 */
interface PublicationContainerInterface {

    /**
     *
     * @return the publications number in container
     */
    int publicationsNumber();

    /**
     *
     * @return the maximum capacity of container
     */
    int maximumCapacity();

    /**
     * Adds a publication to container
     *
     * @param p Publication to add
     * @return true if adding finished successfully, else returns false
     * @throws PublicationContainerException
     */
    boolean add(Publication p) throws PublicationContainerException;

    /**
     * Sets a publication at certain index in container
     *
     * @param index Index of publication in container
     * @param p Publication to set
     * @return true if operation finished successfully, else returns false
     * @throws PublicationContainerException
     */
    boolean set(int index, Publication p) throws PublicationContainerException;

    /**
     * Derives a Publication object from PublicationContainer
     *
     * @param index Index of publication
     * @return the publication object
     * @throws PublicationContainerException
     */
    Publication get(int index) throws PublicationContainerException;

    /**
     * Removes a certain Publication object from a container
     *
     * @param publication Publication object to remove
     * @return true if operation finished successfully, else returns false
     */
    boolean remove(Publication publication);

    /**
     * Finds out whether the container contains a certain Publication
     *
     * @param publication Publication to find
     * @return true if container contains the Publication, else false
     */
    boolean contains(Publication publication);

    /**
     * 
     * 
     * @return the number of Periodical Publications in container
     */
    int periodicalNumber();

    /**
     * 
     * @return the number of NonPeriodical publications in container
     */
    int nonPeriodicalNumber();

    /**
     * 
     * @return string representation of all the Publications in container
     */
    String allPublicationsToString();
}
