package by.epam.javatraining.beseda.task01.model.entity.container;

import by.epam.javatraining.beseda.task01.model.entity.Publication;

/**
 *
 * @author Beseda
 * @version 1.0 07/03/2019
 */
public class HomeLibrary extends AbstractPublicationContainer{

    public HomeLibrary() {
        super();
    }

    public HomeLibrary(int size) {
        super(size);
    }

    public HomeLibrary(HomeLibrary books) {
        super(books);
    }


    @Override
    public boolean add(Publication publication){
        if (publication != null) {
            if (this.publicationsNumber == this.maxSize) {
                this.extendLibrary();
            }
            this.books[this.publicationsNumber] = publication;
            this.publicationsNumber++;
            return true;
        }
        return false;
    }

    private void extendLibrary() {
        this.maxSize = (int) (this.maxSize * (3.0 / 2));
        Publication[] newBooks = new Publication[this.maxSize];
        System.arraycopy(books, 0, newBooks, 0, this.publicationsNumber);
        this.books = newBooks;
    }

    @Override
    public String toString() {
        return "Home library can contain " + maxSize
                + " publications, current number of publications - " + publicationsNumber;
    }
    
}
