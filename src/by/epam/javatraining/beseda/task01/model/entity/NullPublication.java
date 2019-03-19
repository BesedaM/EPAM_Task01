/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.javatraining.beseda.task01.model.entity;

/**
 *
 * @author Beseda
 * @version 1.0 19/03/2019
 */
public class NullPublication extends Publication {

    public NullPublication() {
        super();
    }

    @Override
    public Publication clone() {
        return new NullPublication();
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public String toString() {
        return "";
    }
}
