package org.features.authorization;

import org.features.Account;
import org.features.Transaction;

public class InsufficientLimitStrategy implements AuthorizationStrategy {
    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {
        if (transaction.getAmount() > account.getAvailableLimit()) {
            return new AuthorizationResult(account, "insufficient-limit");
        }
        return null;
    }
}
