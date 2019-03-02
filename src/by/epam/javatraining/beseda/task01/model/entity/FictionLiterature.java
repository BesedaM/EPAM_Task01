package by.epam.javatraining.beseda.task01.model.entity;

import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class FictionLiterature extends NonPeriodical {

    private String genre;

    public static final String DEFAULT_GENRE = "Unknown";
    
    public FictionLiterature() {
        super();
        this.genre = DEFAULT_GENRE;
    }

    public FictionLiterature(String genre, String author, String name,
            int year, int numberOfPages) {
        super(author, name, year, numberOfPages);
        if (genre != null) {
            this.genre = genre;
        } else {
            this.genre = DEFAULT_GENRE;
        }
    }

    public FictionLiterature(String genre, String author, String name,
            int numberOfVolumes, int volumeNumber, int year, int numberOfPages) {
        super(author, name, numberOfVolumes, volumeNumber, year, numberOfPages);
        if (genre != null) {
            this.genre = genre;
        } else {
            this.genre = DEFAULT_GENRE;
        }
    }

    public void setGenre(String genre){
        if (genre != null) {
            this.genre = genre;
        } else {
           this.genre = DEFAULT_GENRE;
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
        if (!super.equals(obj)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
