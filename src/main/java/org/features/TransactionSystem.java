package org.features;
import java.util.Random;

public class TransactionSystem {
    public static void main(String[] args) {
        Account account = new Account(true, 1000);
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            double amount = (random.nextDouble() * 2000.0) - 1000.0;
            amount = Math.round(amount * 100.0) / 100.0;
            Transaction transaction = new Transaction(amount, "Pix", "2022-04-14T14:30:00");
            account.addTransaction(transaction);
        }

        System.out.println(account);
    }
}
