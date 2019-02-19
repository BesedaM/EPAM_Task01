package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalScienceFieldException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19.02.2019
 */
public class Manuale extends NonPeriodical {

    public enum Category {
        BEGINNER, AMATEUR, PROFESSIONAL, ANY
    }

    private String field;
    private Category audience;

    public Manuale() {
    }

    public Manuale(String author, String name, int year, int numberOfPages,
            String field, Category audience) {
        super(author, name, year, numberOfPages);
        if (field != null) {
            this.field = field;
        } else {
            this.field = "Unknown";
        }
        this.audience = audience;
    }

    public Manuale(String author, String name, int numberOfVolumes,
            int volumeNumber, int date, int numberOfPages,
            String field, Category audience) {
        super(author, name, numberOfVolumes, volumeNumber, date, numberOfPages);
        if (field != null) {
            this.field = field;
        } else {
            this.field = "Unknown";
        }
        this.audience = audience;
    }

    public void setField(String field) throws IllegalScienceFieldException {
        if (field != null) {
            this.field = field;
        } else {
            throw new IllegalScienceFieldException();
        }
    }

    public void setAudience(Category audience) {
        this.audience = audience;
    }

    public String getField() {
        return field;
    }

    public Category getAudience() {
        return audience;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.field);
        hash = 29 * hash + Objects.hashCode(this.audience);
        hash = 29 * hash + super.hashCode() / 2;
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
        final Manuale other = (Manuale) obj;
        if (!super.equals(new NonPeriodical(other))) {      //!!!!
            return false;
        }
        if (!Objects.equals(this.field, other.field)) {
            return false;
        }
        if (this.audience != other.audience) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " for " + audience.name() + "S";
    }

}
