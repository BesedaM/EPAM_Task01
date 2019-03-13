package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Periodical;
import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.PublicationContainerException;
import by.epam.javatraining.beseda.task01.model.exception.WrongIndexException;
import java.util.Arrays;

/**
 * Abstract container class for Publication objects
 *
 * @author Beseda
 * @version 1.0 07/03/2019
 */
abstract public class PublicationContainer implements PublicationContainerInterface {

    public static final int DEFAULT_SIZE = 16;

    protected int MAX_SIZE;
    protected Publication[] books;
    protected int publicationsNumber = 0;

    protected int periodicalNumber = 0;
    protected int nonPeriodicalNumber = 0;

    /**
     * Default constructor, creates a PublicationContainer of DEFAULT_SIZE
     */
    public PublicationContainer() {
        this.MAX_SIZE = DEFAULT_SIZE;
        this.books = new Publication[MAX_SIZE];
    }

    /**
     * Constructor with parameter size, specifying the maximum capacity of
     * container
     *
     * @param size Input size of PublicationContainer
     */
    public PublicationContainer(int size) {
        if (size > 0) {
            this.MAX_SIZE = size;
        } else {
            this.MAX_SIZE = DEFAULT_SIZE;
        }
        this.books = new Publication[MAX_SIZE];
    }

    /**
     * Copy constructor
     *
     * @param books PublicationContainer to copy
     */
    public PublicationContainer(PublicationContainer books) {
        this.MAX_SIZE = books.MAX_SIZE;
        this.books = new Publication[MAX_SIZE];
        this.publicationsNumber = books.publicationsNumber;
        this.nonPeriodicalNumber = books.nonPeriodicalNumber;
        this.periodicalNumber = books.periodicalNumber;
        for (int i = 0; i < publicationsNumber; i++) {
            this.books[i] = books.books[i].clone();
        }
    }

    @Override
    public int publicationsNumber() {
        return publicationsNumber;
    }

    @Override
    public int maximumCapacity() {
        return MAX_SIZE;
    }

    @Override
    abstract public boolean add(Publication p) throws PublicationContainerException;

    @Override
    public boolean set(int index, Publication publication) throws WrongIndexException {
        if (publication != null) {
            if (index >= 0 && index < this.publicationsNumber) {
                this.deletePublicationType(books[index]);
                this.addPublicationType(publication);
                books[index] = publication;
                return true;
            } else {
                throw new WrongIndexException();
            }
        }
        return false;
    }

    @Override
    public boolean contains(Publication publication) {
        for (int i = 0; i < this.publicationsNumber; i++) {
            if (books[i].equals(publication)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Publication get(int index) throws WrongIndexException {
        if (index >= 0 && index < this.publicationsNumber) {
            return books[index];
        } else {
            throw new WrongIndexException();
        }
    }

    protected void addPublicationType(Publication publication) {
        if (publication instanceof Periodical) {
            this.periodicalNumber++;
        }
        this.nonPeriodicalNumber++;
    }

    protected void deletePublicationType(Publication publication) {
        if (publication instanceof Periodical) {
            this.periodicalNumber--;
        }
        this.nonPeriodicalNumber--;
    }

    @Override
    public boolean remove(Publication publication) {
        if (publication != null) {
            for (int i = 0; i < this.publicationsNumber; i++) {
                if (books[i].equals(publication)) {
                    this.deletePublicationType(publication);
                    books[i] = books[this.publicationsNumber - 1];
                    books[this.publicationsNumber - 1] = null;
                    publicationsNumber--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int periodicalNumber() {
        return this.periodicalNumber;
    }

    @Override
    public int nonPeriodicalNumber() {
        return this.nonPeriodicalNumber;
    }

    @Override
    public String allPublicationsToString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < this.publicationsNumber; i++) {
            string.append(books[i]).append("\n");
        }
        return string.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.MAX_SIZE;
        hash = 17 * hash + Arrays.deepHashCode(this.books);
        hash = 17 * hash + this.publicationsNumber;
        hash = 17 * hash + this.periodicalNumber;
        hash = 17 * hash + this.nonPeriodicalNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PublicationContainer other = (PublicationContainer) obj;
        if (this.MAX_SIZE != other.MAX_SIZE) {
            return false;
        }
        if (this.publicationsNumber != other.publicationsNumber) {
            return false;
        }
        if (this.periodicalNumber != other.periodicalNumber) {
            return false;
        }
        if (this.nonPeriodicalNumber != other.nonPeriodicalNumber) {
            return false;
        }
        if (!Arrays.deepEquals(this.books, other.books)) {
            return false;
        }
        return true;
    }

}