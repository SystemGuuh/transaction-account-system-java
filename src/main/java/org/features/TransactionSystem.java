package org.features;

public class TransactionSystem {
    public static void main(String[] args) {
        Account account = new Account(true, 1000);
        Transaction transaction = new Transaction(100, "Amazon", "2022-04-14T14:30:00");
        
        account.getHistory().add(transaction);
        
        System.out.println(account);
        System.out.println(transaction);
    }
}