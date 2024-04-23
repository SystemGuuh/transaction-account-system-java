package org.features.authorization;

import org.features.Account;
import org.features.Transaction;

public class FirstTransactionThresholdStrategy implements AuthorizationStrategy {
    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {
        if (account.getHistory().isEmpty() && transaction.getAmount() > account.getAvailableLimit() * 0.9) {
            return new AuthorizationResult(account, "first-transaction-above-threshold");
        }
        return null;
    }
}
