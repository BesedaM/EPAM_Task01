package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalVolumesNumberException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalAuthorException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalVolumeNumberException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class NonPeriodical extends Publication {

    public static final int MINIMUM_VOLUMES_NUMBER = 2;
    public static final String DEFAULT_AUTHOR = "Unknown";

    protected String author;
    protected boolean multivolume;
    protected int volumeNumber = 1;
    protected int volumesNumber = 1;

    protected NonPeriodical() {
        super();
        this.author = DEFAULT_AUTHOR;
    }

    protected NonPeriodical(String author, String name, int year, int numberOfPages) {
        super(name, year, numberOfPages);
        if (author != null) {
            this.author = author;
        } else {
            this.author = DEFAULT_AUTHOR;
        }
    }

    protected NonPeriodical(String author, String name, int volumesNumber,
            int volumeNumber, int year, int pagesNumber) {
        super(name, year, pagesNumber);
        if (author != null) {
            this.author = author;
        } else {
            this.author = DEFAULT_AUTHOR;
        }
        if (volumesNumber >= MINIMUM_VOLUMES_NUMBER) {
            this.volumesNumber = volumesNumber;
            this.multivolume = true;
        }
        if (volumeNumber > 0) {
            this.volumeNumber = volumeNumber;
        }

    }

    protected NonPeriodical(Publication p, String author, int volumesNumber,
            int volumeNumber) {
        super(p);
        if (author != null) {
            this.author = author;
        } else {
            this.author = DEFAULT_AUTHOR;
        }
        if (volumeNumber > 0) {
            this.volumeNumber = volumeNumber;
        }
        if (volumesNumber >= MINIMUM_VOLUMES_NUMBER) {
            this.multivolume = true;
            this.volumesNumber = volumesNumber;
        }
    }

    protected NonPeriodical(NonPeriodical obj) {
        super(obj);
        this.author = obj.author;
        this.multivolume = obj.multivolume;
        this.volumesNumber = obj.volumesNumber;
        this.volumeNumber = obj.volumeNumber;
    }

    @Override
    public NonPeriodical clone() {
        return new NonPeriodical(this);
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

    public void setVolumesNumber(int volumesNumber) throws IllegalVolumesNumberException {
        if (volumesNumber >= MINIMUM_VOLUMES_NUMBER) {
            this.volumesNumber = volumesNumber;
            this.multivolume = true;
        } else {
            throw new IllegalVolumesNumberException();
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

    public int getVolumesNumber() {
        return volumesNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.author);
        hash = 19 * hash + (this.multivolume ? 1 : 0);
        hash = 19 * hash + this.volumeNumber;
        hash = 19 * hash + this.volumesNumber;
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
        if (this.volumesNumber != other.volumesNumber) {
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
                    + pagesNumber + " pages";
        } else {
            return author + ". " + name + ". Volume " + volumeNumber
                    + " of " + volumesNumber + ". " + year + ", "
                    + pagesNumber + " pages";
        }
    }

    @Override
    public String writeAllData() {
        return super.writeAllData() + author + ", " + volumesNumber + ", "
                + volumeNumber + ", ";
    }
}
