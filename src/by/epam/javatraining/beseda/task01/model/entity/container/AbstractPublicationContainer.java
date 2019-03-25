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
abstract public class AbstractPublicationContainer implements PublicationContainer{

    public static final int DEFAULT_SIZE = 16;

    protected int maxSize;
    protected Publication[] books;
    protected int publicationsNumber = 0;

    protected int periodicalNumber = 0;
    protected int nonPeriodicalNumber = 0;

    /**
     * Default constructor, creates a PublicationContainer of DEFAULT_SIZE
     */
    public AbstractPublicationContainer() {
        this.maxSize = DEFAULT_SIZE;
        this.books = new Publication[maxSize];
    }

    /**
     * Constructor with parameter size, specifying the maximum capacity of
     * container
     *
     * @param size Input size of PublicationContainer object
     */
    public AbstractPublicationContainer(int size) {
        if (size > 0) {
            this.maxSize = size;
        } else {
            this.maxSize = DEFAULT_SIZE;
        }
        this.books = new Publication[maxSize];
    }

    /**
     * Copy constructor
     *
     * @param books PublicationContainer to copy
     */
    public AbstractPublicationContainer(AbstractPublicationContainer books) {
        this.maxSize = books.maxSize;
        this.books = new Publication[maxSize];
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
        return maxSize;
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
        hash = 17 * hash + this.maxSize;
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
        final AbstractPublicationContainer other = (AbstractPublicationContainer) obj;
        if (this.maxSize != other.maxSize) {
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
