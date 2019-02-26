package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalAudienceException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalNumberException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class Periodical extends Publication {

    public enum Audience {
        CHILDREN, TEENAGERS, ADULTS, ANY
    }

    protected Audience audience;
    protected int number;

    protected Periodical() {
        super();
        this.audience = Audience.ANY;
    }

    protected Periodical(String name, int year, int number, int numberOfPages,
            Audience audience) {
        super(name, year, numberOfPages);
        if (audience != null) {
            this.audience = audience;
        } else {
            this.audience = Audience.ANY;
        }
        if (number > 0) {
            this.number = number;
        }
    }

    public void setAudience(Audience audience) throws IllegalAudienceException {
        if (audience != null) {
            this.audience = audience;
        } else {
            throw new IllegalAudienceException();
        }

    }

    public void setNumber(int number) throws IllegalNumberException {
        if (number > 0) {
            this.number = number;
        } else {
            throw new IllegalNumberException();
        }
    }

    public Audience getAudience() {
        return audience;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public double getDays() {
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hash(this.audience);
        hash = 17 * hash + this.number;
        hash += super.hashCode() / 2;
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
        if (!super.equals(obj)) {    //checking of parent's fields
            return false;
        }
        final Periodical other = (Periodical) obj;
        if (!this.audience.equals(other.audience)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ". " + year + ", " + number + ", " + numberOfPages + " pages";
    }
}
