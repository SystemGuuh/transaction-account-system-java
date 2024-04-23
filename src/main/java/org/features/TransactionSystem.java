package org.features;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class TransactionSystem {
    public static void main(String[] args) {
        Account account = new Account(true, 1000);
        Random random = new Random();
        Semaphore semaphore = new Semaphore(1);
        Thread accountThread = new Thread(account);
        accountThread.start();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            double amount = (random.nextDouble() * 2000.0) - 1000.0;
            amount = Math.round(amount * 100.0) / 100.0;
            Transaction transaction = new Transaction(amount, "Amazon", "2022-04-14T14:30:00");
            threads[i] = new Thread(() -> {
                try {
                    semaphore.acquire();
                    account.addTransaction(transaction);
                    System.out.println("Transaction added by thread: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(account);
    }
}
