package fr.rli.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private double balance = 0.0;

    private List<Operation> history = new ArrayList<>();

    public Account(List<Operation> history) {
        this.history = history;
    }

    public void deposit(double amount, LocalDate date) {
        balance += amount;
    }

    public void withdrawal(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
