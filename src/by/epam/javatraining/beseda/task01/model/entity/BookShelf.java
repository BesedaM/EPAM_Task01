package by.epam.javatraining.beseda.task01.model.entity;

import java.util.Arrays;

/**
 * Container class having an array of specified size as a storage base
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class BookShelf {

    private final int MAX_SIZE;
    private Publication[] books;
    private int size = 0;

    private int numberOfPeriodical = 0;
    private int numberOfNonPeriodical = 0;

    public BookShelf(int size) {
        if (size > 0) {
            this.MAX_SIZE = size;
        } else {
            this.MAX_SIZE = 0;
        }
        this.books = new Publication[MAX_SIZE];
    }

    public BookShelf(BookShelf books) {
        this.MAX_SIZE = books.getMaximumSize();
        this.books = new Publication[MAX_SIZE];
        this.size = books.getSize();
        this.numberOfNonPeriodical = books.numberOfNonPeriodical;
        this.numberOfPeriodical = books.numberOfPeriodical;
        for (int i = 0; i < size; i++) {
            this.books[i] = books.get(i);
        }
    }

    public int getMaximumSize() {
        return MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

    public boolean add(Publication publication) {
        if (publication != null && !(this.size == this.books.length)) {
            this.addPeriodicalOrNonPeriodical(publication);
            this.books[this.size] = publication;
            this.size++;
            return true;
        } else {
            return false;
        }
    }

    public void set(int index, Publication publication) {
        if (index >= 0 && index < this.size && publication != null) {
            this.deletePeriodicalOrNonPeriodical(books[index]);
            this.addPeriodicalOrNonPeriodical(publication);
            books[index] = publication;
        }
    }

    public Publication get(int index) {
        if (index >= 0 && index < this.size) {
            return books[index];
        } else {
            return null;
        }
    }

    public boolean delete(int index) {
        if (index >= 0 && index < this.size) {
            this.deletePeriodicalOrNonPeriodical(books[index]);
            books[index] = books[this.size - 1];
            books[this.size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }

    private void addPeriodicalOrNonPeriodical(Publication publication) {
        if (publication instanceof Periodical) {
            this.numberOfPeriodical++;
        } else if (publication instanceof NonPeriodical) {
            this.numberOfNonPeriodical++;
        }
    }

    private void deletePeriodicalOrNonPeriodical(Publication publication) {
        if (publication instanceof Periodical) {
            this.numberOfPeriodical--;
        } else if (publication instanceof NonPeriodical) {
            this.numberOfNonPeriodical--;
        }
    }

    public int getNumberOfPeriodical() {
        return this.numberOfPeriodical;
    }

    public int getNumberOfNonPeriodical() {
        return this.numberOfNonPeriodical;
    }

    public String getAllPublications() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            string.append(books[i]).append("\n");
        }
        return string.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.MAX_SIZE;
        hash = 17 * hash + Arrays.deepHashCode(this.books);
        hash = 17 * hash + this.size;
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
        final BookShelf other = (BookShelf) obj;
        if (this.MAX_SIZE != other.MAX_SIZE) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        if (!Arrays.deepEquals(this.books, other.books)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bookshelf for " + MAX_SIZE
                + " publications, current number of publications - " + size;
    }

}
