package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalNameException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNumberOfPagesException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalYearException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19.02.2019
 */
public class Publication {

    public static int ID_COUNT = 1;

    protected int ID;
    protected String name;
    protected int year;
    protected int numberOfPages;

    protected Publication() {
        this.ID = ID_COUNT++;
    }

    protected Publication(String name, int year, int numberOfPages) {
        this.ID = ID_COUNT++;
        if (name != null) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
        if (year > 1900 || year <= (new GregorianCalendar().get(Calendar.YEAR))) {
            this.year = year;
        }
        this.numberOfPages = numberOfPages;
    }

    protected Publication(Publication otherPublication) {   //used in subclass's equals method
        this.ID = otherPublication.ID;
        this.name = otherPublication.name;
        this.year = otherPublication.year;
        this.numberOfPages = otherPublication.numberOfPages;
    }

    public void setName(String name) throws IllegalNameException {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalNameException();
        }
    }

    public void setDate(int year) throws IllegalYearException {
        if (year > 1900 || year <= (new GregorianCalendar().get(Calendar.YEAR))) {
            this.year = year;
        } else {
            throw new IllegalYearException();
        }
    }

    public void setNumberOfPages(int numberOfPages) throws IllegalNumberOfPagesException {
        if (numberOfPages > 0) {
            this.numberOfPages = numberOfPages;
        } else {
            throw new IllegalNumberOfPagesException();
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getDate() {
        return year;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.ID;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + this.year;
        hash = 19 * hash + this.numberOfPages;
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
        final Publication other = (Publication) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        if (this.numberOfPages != other.numberOfPages) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID " + ID + ". " + name;
    }

}
