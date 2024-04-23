package org.features.authorization;

import org.features.Account;
import org.features.Transaction;

public class HighFrequencyStrategy implements AuthorizationStrategy {
    private static final int MAX_TRANSACTIONS = 3;
    private static final long TIME_INTERVAL = 2 * 60 * 1000; // 2 minutos em milissegundos

    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {

        return null;
    }
}
