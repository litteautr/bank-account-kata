package fr.rli.domain;

public class Account {

    private double balance;

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdrawal(double amount) {
    }

    public double getBalance() {
        return balance;
    }
}
