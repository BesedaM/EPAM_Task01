package by.epam.javatraining.beseda.task01.model.entity;

import java.util.Arrays;

/**
 *
 * @author Beseda
 * @version 1.0 19.02.2019
 */
public class BookShelf {

    private final int MAX_SIZE;
    private Publication[] shelf;
    private int size = 0;

    public BookShelf(int size) {
        this.MAX_SIZE = size;
        this.shelf = new Publication[MAX_SIZE];
    }

    public int getMaximumSize() {
        return MAX_SIZE;
    }

    public int getSize() {
        return size;
    }

    public boolean add(Publication publication) {
        if (publication != null) {
            if (!(this.size == this.shelf.length)) {
                this.shelf[this.size] = publication;
                this.size++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Publication get(int index) {
        if (index >= 0 && index < this.size) {
            return shelf[index];
        } else {
            return null;
        }
    }

    public boolean delete(int index) {
        if (index >= 0 && index < this.size) {
            shelf[index] = shelf[this.size - 1];
            shelf[this.size - 1] = null;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public String getAllPublications() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < this.size; i++) {
            string.append(shelf[i]).append("\n");
        }
        return string.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.MAX_SIZE;
        hash = 17 * hash + Arrays.deepHashCode(this.shelf);
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
        if (!Arrays.deepEquals(this.shelf, other.shelf)) {
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
