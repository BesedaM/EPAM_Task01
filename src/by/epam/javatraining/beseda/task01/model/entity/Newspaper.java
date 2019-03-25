package by.epam.javatraining.beseda.task01.model.entity;

import by.epam.javatraining.beseda.task01.model.exception.IllegalPeriodicityException;
import java.util.Objects;

/**
 *
 * @author Beseda
 * @version 1.0 19/02/2019
 */
public class Newspaper extends Periodical {

    public enum Periodicity {
        MONTHLY(30), TWICE_A_MONTH(15), WEEKLY(7),
        TWICE_A_WEEK(7.0 / 2), THREE_TIMES_A_WEEK(7.0 / 3), DAYLY(1);

        private double daysNumber;

        private Periodicity(double daysNumber) {
            this.daysNumber = daysNumber;
        }

        public double getDaysNumber() {
            return daysNumber;
        }
    }

    public static final Periodicity DEFAULT_PERIODICITY = Periodicity.WEEKLY;

    private Periodicity periodicity;

    public Newspaper() {
        super();
        this.periodicity = DEFAULT_PERIODICITY;
    }

    public Newspaper(String name, int year, int number, int pagesNumber,
            Audience audience, Periodicity periodicity) {
        super(name, year, number, pagesNumber, audience);
        if (periodicity != null) {
            this.periodicity = periodicity;
        } else {
            this.periodicity = DEFAULT_PERIODICITY;
        }
    }

        public Newspaper(Publication p, int number, Audience audience, 
                Periodicity periodicity) {
        super(p, number, audience);
        if (periodicity != null) {
            this.periodicity = periodicity;
        } else {
            this.periodicity = DEFAULT_PERIODICITY;
        }
    }
    
    public Newspaper(Newspaper obj) {
        super(obj);
        this.periodicity = obj.periodicity;
    }

    @Override
    public Newspaper clone() {
        return new Newspaper(this);
    }

    public void setPeriodicity(Periodicity periodicity) throws IllegalPeriodicityException {
        if (periodicity != null) {
            this.periodicity = periodicity;
        } else {
            throw new IllegalPeriodicityException();
        }
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    @Override
    public double getDays() {
        return this.number * this.periodicity.getDaysNumber();
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
        if (!super.equals(obj)) { //!!!
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

    @Override
    public String writeAllData() {
        return super.writeAllData() + periodicity + "; ";
    }

}
