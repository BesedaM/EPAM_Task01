package by.epam.javatraining.beseda.task01.model.entity;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Newspaper extends Periodical {

    public enum Periodicity {
        MONTHLY, SEVERAL_TIMES_A_MONTH, WEEKLY,
        SEVERAL_TIMES_A_WEEK, DAYLY
    }

    private Periodicity periodicity;

    public Newspaper() {
    }

    public Newspaper(String name, int year, int number, int numberOfPages,
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
        final Newspaper other = (Newspaper) obj;
        if (!super.equals(new Periodical(other))) { //!!!
            return false;
        }
        
        if (this.periodicity != other.periodicity) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Newspaper " + super.toString();
    }

}
