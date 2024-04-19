package org.features;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private boolean active;
    private int availableLimit;
    private List<Transaction> history;

    public Account(boolean active, int availableLimit) {
        this.active = active;
        this.availableLimit = availableLimit;
        this.history = new ArrayList<>();
    }

    // Getters e Setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getAvailableLimit() {
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
    public String toString() {
        return "Account{" +
                "active=" + active +
                ", availableLimit=" + availableLimit +
                ", history=" + history +
                '}';
    }
}
