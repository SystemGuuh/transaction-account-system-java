package org.features.authorization;
import org.features.Account;
import org.features.Transaction;

public class ActiveAccountStrategy implements AuthorizationStrategy {
    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {
        if (!account.isActive()) {
            return new AuthorizationResult(account, "account-not-active");
        }
        return null;
    }
}

