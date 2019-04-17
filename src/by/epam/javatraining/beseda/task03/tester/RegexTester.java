/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task03.tester;

import by.epam.javatraining.beseda.task03.model.validator.PublicationTypeWithRegularExpression;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author User
 */
public class RegexTester {

    public static void main(String[] args) {

        String regex =PublicationTypeWithRegularExpression.FICTION_LITERATURE.getRegex();          //"[a-zA-Z\\s]+";
        String input = "FictionLiterature: The Great Gatsby, 2016, 198, F.Scott Fitzgerald, 0, 0, historical fiction";  //"hello world";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        Pattern p1 = Pattern.compile("[a-zA-Z\\s\\.]+");
        Matcher m1 = p1.matcher("F.Scott Fitzgerald");
        
        Pattern p2 = Pattern.compile("[A-Z_]+");
        Matcher m2 = p2.matcher("TWICE_A_WEEK");
        
        System.out.println(m.matches());
        System.out.println(m1.matches());
        System.out.println(m2.matches());
        

    }
}
