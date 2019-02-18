package by.epam.javatraining.beseda.task01.model.entity;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Dictionary extends NonPeriodical {

    private String type;
    private String language;

    public Dictionary() {
    }

    public Dictionary(String type, String language, String author, String name,
            int year, int numberOfPages) {
        super(author, name, year, numberOfPages);
        if (type != null) {
            this.type = type;
        } else {
            this.type = "Unknown";
        }
        if (language != null) {
            this.language = language;
        } else {
            this.language = "Unknown";
        }
    }

    public Dictionary(String type, String language, String author, String name,
            int numberOfVolumes, int volumeNumber, int date, int numberOfPages) {
        super(author, name, numberOfVolumes, volumeNumber, date, numberOfPages);
        if (type != null) {
            this.type = type;
        } else {
            this.type = "Unknown";
        }
        if (language != null) {
            this.language = language;
        } else {
            this.language = "Unknown";
        }
    }

    public void setType(String type) {
        if (type != null) {
            this.type = type;
        } else {
            this.type = "Unknown";
        }
    }

    public void setLanguage(String language) {
        if (language != null) {
            this.language = language;
        } else {
            this.language = "Unknown";
        }
    }

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.type);
        hash = 19 * hash + Objects.hashCode(this.language);
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
        final Dictionary other = (Dictionary) obj;
        if (!super.equals(new NonPeriodical(other))) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.language, other.language)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
