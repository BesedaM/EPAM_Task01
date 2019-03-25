package by.epam.javatraining.beseda.task03.parser;

/**
 *
 * @author Beseda
 * @version 1.0 25/03/2019
 */
public class PublicationParser {

    public static String[] parse(String obj) {
        String rawData = obj.substring(obj.indexOf(':') + 2);
        String[] data = rawData.split(", ");
        
        return data;
    }

}
