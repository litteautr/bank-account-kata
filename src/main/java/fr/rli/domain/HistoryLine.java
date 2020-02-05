package fr.rli.domain;

import java.io.PrintStream;

public class HistoryLine {

    private Operation operation;
    private double accountBalance;

    public HistoryLine(Operation operation, double accountBalance) {
        this.operation = operation;
        this.accountBalance = accountBalance;
    }

    public void print(PrintStream printStream) {
        operation.print(printStream, accountBalance);
    }
}
