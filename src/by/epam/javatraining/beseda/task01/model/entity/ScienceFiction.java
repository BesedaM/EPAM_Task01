package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalScienceFieldException;
import java.util.Objects;

/**
 *
 * @author User
 */
public class ScienceFiction extends NonPeriodical {

    private String field;

    public ScienceFiction() {
    }

    public ScienceFiction(String author, String name,
            int year, int numberOfPages, String field) {
        super(author, name, year, numberOfPages);
        if (field != null) {
            this.field = field;
        } else {
            this.field = "Unknown";
        }
    }

    public ScienceFiction(String author, String name, String field,
            int numberOfVolumes, int volumeNumber, int date, int numberOfPages) {
        super(author, name, numberOfVolumes, volumeNumber, date, numberOfPages);
        if (field != null) {
            this.field = field;
        } else {
            this.field = "Unknown";
        }
    }

    public void setField(String field) throws IllegalScienceFieldException {
        if (field != null) {
            this.field = field;
        } else {
            throw new IllegalScienceFieldException();
        }
    }

    public String getField() {
        return field;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.field);
        hash = 13 * hash + super.hashCode() / 2;
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
        final ScienceFiction other = (ScienceFiction) obj;
        if (!super.equals(new NonPeriodical(other))) {  //!!!!
            return false;
        }
        if (!Objects.equals(this.field, other.field)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
