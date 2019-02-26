package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalNumberOfVolumesException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalAuthorException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalVolumeNumberException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class NonPeriodical extends Publication {

    protected String author;
    protected boolean multivolume;
    protected int volumeNumber;
    protected int numberOfVolumes;

    protected NonPeriodical() {
        super();
        this.author = "Unknown";
    }

    protected NonPeriodical(String author, String name, int year, int numberOfPages) {
        super(name, year, numberOfPages);
        if (author != null) {
            this.author = author;
        } else {
            this.author = "Unknown";
        }
    }

    protected NonPeriodical(String author, String name,
            int numberOfVolumes, int volumeNumber, int date, int numberOfPages) {
        super(name, date, numberOfPages);
        if (author != null) {
            this.author = author;
        } else {
            this.author = "Unknown";
        }
        this.multivolume = true;
        if (volumeNumber > 0) {
            this.volumeNumber = volumeNumber;
        }
        if (numberOfVolumes > 1) {
            this.numberOfVolumes = numberOfVolumes;
        }
    }

    public void setAuthor(String author) throws IllegalAuthorException {
        if (author != null) {
            this.author = author;
        } else {
            throw new IllegalAuthorException();
        }
    }

    public void setMultivolume(boolean multivolume) {
        this.multivolume = multivolume;
    }

    public void setVolumeNumber(int volumeNumber) throws IllegalVolumeNumberException {
        if (volumeNumber > 0) {
            this.volumeNumber = volumeNumber;
        } else {
            throw new IllegalVolumeNumberException();
        }
    }

    public void setNumberOfVolumes(int numberOfVolumes) throws IllegalNumberOfVolumesException {
        if (numberOfVolumes > 1) {
            this.numberOfVolumes = numberOfVolumes;
        } else {
            throw new IllegalNumberOfVolumesException();
        }
    }

    public String getAuthor() {
        return author;
    }

    public boolean isMultivolume() {
        return multivolume;
    }

    public int getVolumeNumber() {
        return volumeNumber;
    }

    public int getNumberOfVolumes() {
        return numberOfVolumes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.author);
        hash = 19 * hash + (this.multivolume ? 1 : 0);
        hash = 19 * hash + this.volumeNumber;
        hash = 19 * hash + this.numberOfVolumes;
        hash = 19 * hash + super.hashCode() / 2;
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
        if (!super.equals(obj)) {       
            return false;                        
        }
        final NonPeriodical other = (NonPeriodical) obj;
        if (this.multivolume != other.multivolume) {
            return false;
        }
        if (this.volumeNumber != other.volumeNumber) {
            return false;
        }
        if (this.numberOfVolumes != other.numberOfVolumes) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.multivolume == false) {
            return author + ". " + name + ". " + year + ", " 
                    + numberOfPages + " pages";
        } else {
            return author + ". " + name + ". Volume " + volumeNumber
                    + " of " + numberOfVolumes + ". " + year + ", " 
                    + numberOfPages + " pages";
        }
    }

}
