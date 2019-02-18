package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalFictionKindException;
import java.util.Objects;

/**
 *
 * @author User
 */
public class FictionLiterature extends NonPeriodical {

    private String kind;

    public FictionLiterature() {
    }

    public FictionLiterature(String kind, String author, String name,
            int year, int numberOfPages) {
        super(author, name, year, numberOfPages);
        if (kind != null) {
            this.kind = kind;
        } else {
            this.kind = "Unknown";
        }
    }

    public FictionLiterature(String kind, String author, String name,
            int numberOfVolumes, int volumeNumber, int date, int numberOfPages) {
        super(author, name, numberOfVolumes, volumeNumber, date, numberOfPages);
        if (kind != null) {
            this.kind = kind;
        } else {
            this.kind = "Unknown";
        }
    }

    public void setKind(String kind) throws IllegalFictionKindException {
        if (kind != null) {
            this.kind = kind;
        } else {
           throw new IllegalFictionKindException();
        }
    }

    public String getKind() {
        return kind;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.kind);
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
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " " + kind;
    }

}
