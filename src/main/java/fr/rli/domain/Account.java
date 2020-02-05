package fr.rli.domain;

import java.io.PrintStream;
import java.time.LocalDate;

public class Account {

    private double balance = 0.0;

    private AccountHistory history;

    public Account(AccountHistory history) {
        this.history = history;
    }

    public void deposit(double amount, LocalDate date) {
        executeOperation(amount, date);
    }

    public void withdrawal(double amount, LocalDate date) {
        executeOperation(-amount, date);
    }

    public void printHistory(PrintStream printStream) {
        history.print(printStream);
    }

    public double getBalance() {
        return balance;
    }

    private void executeOperation(double amount, LocalDate date) {
        balance += amount;
        history.addHistoryLine(new Operation(amount, date), balance);
    }


}
