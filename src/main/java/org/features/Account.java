package org.features;
import java.util.ArrayList;
import java.util.List;

public class Account implements Runnable{
    private boolean active;
    private double availableLimit;
    private double balance;
    private List<Transaction> history;

    public Account(boolean active, int availableLimit) {
        this.active = active;
        this.availableLimit = availableLimit;
        this.history = new ArrayList<>();
    }

    public synchronized void addTransaction(Transaction transaction) {
        this.history.add(transaction);
        this.balance += transaction.getAmount();
    }

    // Getters e Setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(int availableLimit) {
        this.availableLimit = availableLimit;
    }

    public List<Transaction> getHistory() {
        return history;
    }

    public void setHistory(List<Transaction> history) {
        this.history = history;
    }

    public double getBalance() { return balance;  }

    public void setBalance(int balance) { this.balance = balance; }


    @Override
    public void run() {

        System.out.println("Processing transaction...");
    }

    @Override
    public String toString() {
        return "Account{" +
                "active=" + active +
                ", availableLimit=" + availableLimit +
                ", balance=" + String.format("%.2f", (double) balance / 100) +
                ", history=" + history +
                '}';
    }
}
