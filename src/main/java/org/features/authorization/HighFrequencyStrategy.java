package org.features.authorization;
import org.features.Account;
import org.features.Transaction;

public class HighFrequencyStrategy implements AuthorizationStrategy {
    private static final int MAX_TRANSACTIONS = 3;
    private static final long TIME_INTERVAL = 2 * 60 * 1000;

    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {
        long currentTime = System.currentTimeMillis();
        int count = 0;

        for (Transaction t : account.getHistory()) {
            if (t.getMerchant().equals(transaction.getMerchant()) && currentTime - t.getTime() < TIME_INTERVAL) {
                count++;
            }
        }

        if (count >= MAX_TRANSACTIONS) {
            return new AuthorizationResult(account, "high-frequency-small-interval");
        }
        return null;
    }
}
