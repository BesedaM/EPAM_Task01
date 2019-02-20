package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalFictionGenreException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class FictionLiterature extends NonPeriodical {

    private String genre;

    public FictionLiterature() {
    }

    public FictionLiterature(String genre, String author, String name,
            int year, int numberOfPages) {
        super(author, name, year, numberOfPages);
        if (genre != null) {
            this.genre = genre;
        } else {
            this.genre = "Unknown";
        }
    }

    public FictionLiterature(String genre, String author, String name,
            int numberOfVolumes, int volumeNumber, int year, int numberOfPages) {
        super(author, name, numberOfVolumes, volumeNumber, year, numberOfPages);
        if (genre != null) {
            this.genre = genre;
        } else {
            this.genre = "Unknown";
        }
    }

    public void setGenre(String genre) throws IllegalFictionGenreException {
        if (genre != null) {
            this.genre = genre;
        } else {
           throw new IllegalFictionGenreException();
        }
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.genre);
        hash = 11 * hash + super.hashCode() / 2;
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
        final FictionLiterature other = (FictionLiterature) obj;
        if (!super.equals(new NonPeriodical(other))) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " " + genre;
    }

}
