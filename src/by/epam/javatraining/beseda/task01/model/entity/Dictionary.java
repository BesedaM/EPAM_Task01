package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalTypeException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class Dictionary extends NonPeriodical {

    public enum Type {
        BILINGUAL, MONOLINGUAL, ENCYCLOPEDIA,
        THESAURUS, GLOSSARY, ILLUSTRATED, POCKET
    }

    public static final String DEFAULT_PUBLISHERS = "Unknown";

    private Type type;
    private String publishers;

    public Dictionary() {
        super();
        this.type = Type.BILINGUAL;
        this.publishers = DEFAULT_PUBLISHERS;
    }

    public Dictionary(Type type, String publishers, String author, String name,
            int year, int numberOfPages) {
        super(author, name, year, numberOfPages);
        if (type != null) {
            this.type = type;
        } else {
            this.type = Type.BILINGUAL;
        }
        if (publishers != null) {
            this.publishers = publishers;
        } else {
            this.publishers = DEFAULT_PUBLISHERS;
        }
    }

    public Dictionary(Type type, String publishers, String author, String name,
            int numberOfVolumes, int volumeNumber, int date, int numberOfPages) {
        super(author, name, numberOfVolumes, volumeNumber, date, numberOfPages);
        if (type != null) {
            this.type = type;
        } else {
            this.type = Type.BILINGUAL;
        }
        if (publishers != null) {
            this.publishers = publishers;
        } else {
            this.publishers = DEFAULT_PUBLISHERS;
        }
    }

    public void setType(Type type) throws IllegalTypeException {
        if (type != null) {
            this.type = type;
        } else {
            throw new IllegalTypeException();
        }
    }

    public void setPublishers(String language) {
        if (language != null) {
            this.publishers = language;
        } else {
            this.publishers = DEFAULT_PUBLISHERS;
        }
    }

    public Type getType() {
        return type;
    }

    public String getPublishers() {
        return publishers;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.type);
        hash = 19 * hash + Objects.hashCode(this.publishers);
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
        if (!super.equals(obj)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.publishers, other.publishers)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.multivolume == false) {
            return publishers + ". " + name + ". " + year;
        } else {
            return publishers + ". " + name + ". Volume " + volumeNumber
                    + " of " + numberOfVolumes + ". " + year;
        }
    }

}
