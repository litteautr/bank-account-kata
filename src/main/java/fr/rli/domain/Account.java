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
        balance += amount;
        Operation operation = new Operation(amount, date);
        history.add(operation);
    }

    public void withdrawal(double amount, LocalDate date) {
        balance -= amount;
        Operation operation = new Operation(amount, date);
        history.add(operation);
    }

    public double getBalance() {
        return balance;
    }
}
