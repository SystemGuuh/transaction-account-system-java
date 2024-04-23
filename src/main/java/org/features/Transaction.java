package org.features;
import java.util.Date;

public class Transaction {
    private double amount;
    private String merchant;
    private Long time;

    public Transaction(double amount, String merchant, long time) {
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
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
