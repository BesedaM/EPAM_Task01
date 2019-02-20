/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task01.util;

import java.util.Scanner;

/**
 *
 * @author Beseda
 * @version 1.0 20/02/2019
 */
public class UserInput {

    private static final Scanner in = new Scanner(System.in);

    public static int inputInt(String msg) {
        System.out.print(msg + " ");
        return in.nextInt();
    }

}
