package org.features.authorization;
import org.features.Account;
import org.features.Transaction;

public interface AuthorizationStrategy {
    AuthorizationResult authorize(Transaction transaction, Account account);
}