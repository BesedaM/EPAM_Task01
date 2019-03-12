package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Publication;
import by.epam.javatraining.beseda.task01.model.exception.NotEnoughSpaceException;

/**
 * Container class of fixed maximum size having an array of specified size as a
 * storage base
 *
 * @author Beseda
 * @version 1.1 08/03/2019
 */
public class BookShelf extends PublicationContainer{

    public BookShelf() {
        super();
    }

    public BookShelf(int size) {
        super(size);
    }

    public BookShelf(BookShelf books) {
        super(books);
    }


    @Override
    public boolean add(Publication publication) throws NotEnoughSpaceException {
        if (publication != null) {
            if (this.publicationsNumber < this.MAX_SIZE) {
                this.addPublicationType(publication);
                this.books[this.publicationsNumber] = publication;
                this.publicationsNumber++;
                return true;
            } else {
                throw new NotEnoughSpaceException();
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Bookshelf for " + MAX_SIZE
                + " publications, current number of publications - " + publicationsNumber;
    }

}
