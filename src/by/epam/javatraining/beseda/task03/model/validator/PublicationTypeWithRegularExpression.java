package by.epam.javatraining.beseda.task03.model.validator;

import by.epam.javatraining.beseda.task01.model.entity.Dictionary;
import by.epam.javatraining.beseda.task01.model.entity.FictionLiterature;
import by.epam.javatraining.beseda.task01.model.entity.Magazine;
import by.epam.javatraining.beseda.task01.model.entity.Manuale;
import by.epam.javatraining.beseda.task01.model.entity.Newspaper;



interface RegularConstants {

    String FICTION_LITERATURE_TYPE = FictionLiterature.class.getSimpleName();
    String DICTIONARY_TYPE = Dictionary.class.getSimpleName();
    String MAGAZINE_TYPE = Magazine.class.getSimpleName();
    String NEWSPAPER_TYPE = Newspaper.class.getSimpleName();
    String MANUALE_TYPE = Manuale.class.getSimpleName();

    String AUTHOR = "[a-zA-Z\\s\\.]+";
    String NAME = "[1-9a-zA-Z\\s\\.]+";
    String VOLUMES_NUMBER = "[0-9]{0,2}";
    String VOLUME_NUMBER = "[0-9]{0,2}";
    String YEAR = "[0-9]{4}";
    String PAGES_NUMBER = "[0-9]{1,6}";
    String NUMBER = "[0-9]{1,3}";
    String AUDIENCE = "[A-Z]+";
    String FICT_GENRE = "[a-zA-Z\\s\\.]+";
    String DICT_TYPE = "[A-Z]+";
    String DICT_PUBLISHERS = "[a-zA-Z\\s\\.]+";
    String MAN_AUDIENCE = "[a-zA-Z]+";
    String MAN_FIELD = "[a-zA-Z]+";
    String NEWS_PERIODICITY = "[A-Z_]+";
    String MAG_PERIODICITY = "[A-Z_]+";

    String FIRST_S = "^";
    String SEP = ".*";
    String LAST_S = SEP;

    String PUBLICATION_INFO = NAME + SEP + YEAR + SEP + PAGES_NUMBER;

    String NON_PERIODICAL_INFO = PUBLICATION_INFO + SEP + AUTHOR + SEP
            + VOLUMES_NUMBER + SEP + VOLUME_NUMBER;
    String PERIODICAL_INFO = PUBLICATION_INFO + SEP + NUMBER + SEP + AUDIENCE;
}


/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public enum PublicationTypeWithRegularExpression implements RegularConstants {
    
    FICTION_LITERATURE(FIRST_S + FICTION_LITERATURE_TYPE + SEP
            + NON_PERIODICAL_INFO + SEP + FICT_GENRE + LAST_S),
    DICTIONARY(FIRST_S + DICTIONARY_TYPE + SEP + NON_PERIODICAL_INFO
            + SEP + DICT_TYPE + SEP + DICT_PUBLISHERS + LAST_S),
    MAGAZINE(FIRST_S + MAGAZINE_TYPE + SEP + PERIODICAL_INFO
            + SEP + MAG_PERIODICITY + LAST_S),
    NEWSPAPER(FIRST_S + NEWSPAPER_TYPE + SEP + PERIODICAL_INFO
            + SEP + NEWS_PERIODICITY + LAST_S),
    MANUALE(FIRST_S + MANUALE_TYPE + SEP + NON_PERIODICAL_INFO
            + SEP + MAN_FIELD + SEP + MAN_AUDIENCE + LAST_S);

    private String regex;

    PublicationTypeWithRegularExpression() {
        regex = "";
    }

    PublicationTypeWithRegularExpression(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
