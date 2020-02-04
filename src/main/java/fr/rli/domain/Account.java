package fr.rli.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance = 0.0;

    private List<Operation> history;

    public Account(List<Operation> history) {
        this.history = history;
    }

    public void deposit(double amount, LocalDate date) {
        executeOperation(amount, date);
    }

    public void withdrawal(double amount, LocalDate date) {
        executeOperation(-amount, date);
    }

    public double getBalance() {
        return balance;
    }

    private void executeOperation(double amount, LocalDate date) {
        balance += amount;
        history.add(new Operation(amount, date));
    }
}
