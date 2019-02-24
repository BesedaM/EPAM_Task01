package by.epam.javatraining.beseda.task01.model.entity;

import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class Magazine extends Periodical {

    public enum Periodicity {
        ANNUAL(360), TWICE_A_YEAR(180), ONCE_A_QUATER(90),
        MONTHLY(30), TWICE_A_MONTH(15), WEEKLY(7);
        
        private double numberOfDays;

        private Periodicity(double numberOfDays ) {
            this.numberOfDays = numberOfDays;
        }

        public double getNumberOfDays() {
            return numberOfDays;
        }

    }

    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String name, int year, int number, int numberOfPages,
            Audience audience, Periodicity periodicity) {
        super(name, year, number, numberOfPages, audience);
        this.periodicity = periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.periodicity);
        hash = 29 * hash + super.hashCode() / 2;
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
        final Magazine other = (Magazine) obj;
        if (!super.equals(new Periodical(other))) {     //!!!!!
            return false;
        }
        
        if (this.periodicity != other.periodicity) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Magazine " + super.toString();
    }

}
