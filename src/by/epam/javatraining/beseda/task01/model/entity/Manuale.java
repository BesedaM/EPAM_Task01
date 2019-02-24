package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalAudienceException;
import by.epam.javatraining.beseda.task01.model.exception.IllegalScienceFieldException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class Manuale extends NonPeriodical {

    public enum Audience {
        BEGINNER("beginners"), AMATEUR("amauters"),
        PROFESSIONAL("professionals"), ANY("any");

        private String name;

        Audience(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private String field;
    private Audience audience;

    public Manuale() {
    }

    public Manuale(String author, String name, int year, int numberOfPages,
            String field, Audience audience) {
        super(author, name, year, numberOfPages);
        if (field != null) {
            this.field = field;
        } else {
            this.field = "Unknown";
        }
        if (audience != null) {
            this.audience = audience;
        } else {
            this.audience = Audience.ANY;
        }
    }

    public Manuale(String author, String name, int numberOfVolumes,
            int volumeNumber, int date, int numberOfPages,
            String field, Audience audience) {
        super(author, name, numberOfVolumes, volumeNumber, date, numberOfPages);
        if (field != null) {
            this.field = field;
        } else {
            this.field = "Unknown";
        }
        if (audience != null) {
            this.audience = audience;
        } else {
            this.audience = Audience.ANY;
        }
    }

    public void setField(String field) throws IllegalScienceFieldException {
        if (field != null) {
            this.field = field;
        } else {
            throw new IllegalScienceFieldException();
        }
    }

    public void setAudience(Audience audience) throws IllegalAudienceException {
        if (audience != null) {
            this.audience = audience;
        } else {
            throw new IllegalAudienceException();
        }
    }

    public String getField() {
        return field;
    }

    public Audience getAudience() {
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
        return super.toString() + " for " + audience.getName();
    }

}
