package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalIDException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNameException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalPagesNumberException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalYearException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class Publication {

    public static final int PUBLICATION_MINIMUM_YEAR = 1900;
    public static final int DAYS_IN_YEAR_PASSED_FROM_PUBLICATION = 0;
    public static final String DEFAULT_NAME = "Unknown";

    protected int ID;
    protected String name;
    protected int year;
    protected int pagesNumber;

    protected Publication() {
        this.name = DEFAULT_NAME;
    }

    protected Publication(String name, int year, int numberOfPages) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = DEFAULT_NAME;
        }
        if (year >= PUBLICATION_MINIMUM_YEAR
                && year <= (new GregorianCalendar().get(Calendar.YEAR))) {
            this.year = year;
        }
        if (numberOfPages > 0) {
            this.pagesNumber = numberOfPages;
        }
    }

    protected Publication(Publication obj) {    //copy constructor
        this.name = obj.name;
        this.year = obj.year;
        this.pagesNumber = obj.pagesNumber;
    }

    @Override
    public Publication clone() {
        return new Publication(this);
    }

    public void setID(int ID) throws IllegalIDException {
        if (ID > 0) {
            this.ID = ID;
        } else {
            throw new IllegalIDException();
        }
    }

    public void setName(String name) throws IllegalNameException {
        if (name != null) {
            this.name = name;
        } else {
            throw new IllegalNameException();
        }
    }

    public void setYear(int year) throws IllegalYearException {
        if (year >= PUBLICATION_MINIMUM_YEAR
                && year <= (new GregorianCalendar().get(Calendar.YEAR))) {
            this.year = year;
        } else {
            throw new IllegalYearException();
        }
    }

    public void setPagesNumber(int pagesNumber) throws IllegalPagesNumberException {
        if (pagesNumber > 0) {
            this.pagesNumber = pagesNumber;
        } else {
            throw new IllegalPagesNumberException();
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public double getDays() {
        return DAYS_IN_YEAR_PASSED_FROM_PUBLICATION;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + this.year;
        hash = 19 * hash + this.pagesNumber;
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
        if (this.year != other.year) {
            return false;
        }
        if (this.pagesNumber != other.pagesNumber) {
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
