package org.features.authorization;
import org.features.Account;
import org.features.Transaction;

public class DoubledTransactionStrategy implements AuthorizationStrategy {
    private static final long TIME_INTERVAL = 2 * 60 * 1000;

    @Override
    public AuthorizationResult authorize(Transaction transaction, Account account) {
        long currentTime = System.currentTimeMillis();

        for (Transaction t : account.getHistory()) {
            if (t.getMerchant().equals(transaction.getMerchant()) &&
            t.getAmount() == transaction.getAmount() &&
            currentTime - t.getTime() < TIME_INTERVAL){
                return new AuthorizationResult(account, "doubled-transaction");
            }
        }

        return null;
    }
}
