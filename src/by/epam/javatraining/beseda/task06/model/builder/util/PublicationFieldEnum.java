package by.epam.javatraining.beseda.task06.model.builder.util;

/**
 * Enumeration, covering field type names of Publication and it's descendants
 * objects
 *
 * @author Beseda
 * @version 1.0 16/04/2019
 */
public enum PublicationFieldEnum {
    ID("id"),
    NAME("name"),
    YEAR("year"),
    PAGESNUMBER("pagesNumber"), //PUBLICATION
    AUDIENCE("audience"),
    NUMBER("number"), //PERIODICAL    +MANUALE
    AUTHOR("author"),
    VOLUMESNUMBER("volumesNumber"),
    VOLUMENUMBER("volumeNumber"), //NON_PERIODICAL
    TYPE("type"),
    PUBLISHERS("publishers"), //DICTIONARY
    GENRE("genre"), //FICTION_LITERATURE
    FIELD("field"), //MANUALE
    PERIODICITY("periodicity"); //NEWSPAPER, MAGAZINE

    private String value;

    private PublicationFieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
