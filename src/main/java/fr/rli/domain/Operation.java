package fr.rli.domain;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Objects;

public class Operation {

    private DecimalFormat amountDecimalFormat = new DecimalFormat("#.00");

    private double amount;

    private LocalDate date;

    public Operation(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public void print(PrintStream printStream) {
        StringBuilder operationBuilder = new StringBuilder()
                .append(date.toString())
                .append(" || ")
                .append(amountDecimalFormat.format(amount));
        printStream.println(operationBuilder.toString());
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
