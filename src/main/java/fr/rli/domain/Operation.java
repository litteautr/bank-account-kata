package fr.rli.domain;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Objects;

public class Operation {

    private double amount;

    private LocalDate date;

    public Operation(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public void print(PrintStream printStream) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Double.compare(operation.amount, amount) == 0 &&
                Objects.equals(date, operation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, date);
    }
}
