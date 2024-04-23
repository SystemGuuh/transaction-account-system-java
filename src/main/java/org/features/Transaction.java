package org.features;

public class Transaction {
    private double amount;
    private String merchant;
    private String time;

    public Transaction(double amount, String merchant, String time) {
        this.amount = amount;
        this.merchant = merchant;
        this.time = time;
    }

    
    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", merchant='" + merchant + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
