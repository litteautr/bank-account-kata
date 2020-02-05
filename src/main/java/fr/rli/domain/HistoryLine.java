package fr.rli.domain;

public class HistoryLine {

    private Operation operation;
    private double accountBalance;

    public HistoryLine(Operation operation, double accountBalance) {
        this.operation = operation;
        this.accountBalance = accountBalance;
    }

    public void print() {
        operation.print(accountBalance);
    }
}
