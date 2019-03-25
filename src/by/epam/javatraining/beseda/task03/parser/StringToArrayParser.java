package by.epam.javatraining.beseda.task03.parser;

/**
 *
 * @author Beseda
 * @version 25/03/2019
 */
public class StringToArrayParser {

    public static String[] getStringArray(String data) {
        String[] arr = null;
        if (data != null) {
            arr = data.split("; ");
        }
        return arr;
    }
}
