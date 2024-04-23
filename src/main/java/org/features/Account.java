package org.features;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Account implements Runnable{
    private boolean active;
    private double availableLimit;
    private List<Transaction> history;
    private final Semaphore semaphore = new Semaphore(1);

    public Account(boolean active, int availableLimit) {
        this.active = active;
        this.availableLimit = availableLimit;
        this.history = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        new Thread(() -> {
            try {
                semaphore.acquire();
                this.history.add(transaction);
                System.out.println("Transaction added by thread: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
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

    @Override
    public void run() {
        System.out.println("Processing transaction...");
    }

    @Override
    public String toString() {
        return "Account{" +
                "active=" + active +
                ", availableLimit=" + availableLimit +
                ", history=" + history +
                '}';
    }
}
