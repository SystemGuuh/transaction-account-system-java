package org.features.authorization;
import org.features.Account;
import org.features.Transaction;

public class DoubledTransactionStrategy implements AuthorizationStrategy {


    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {

        return null;
    }
}
