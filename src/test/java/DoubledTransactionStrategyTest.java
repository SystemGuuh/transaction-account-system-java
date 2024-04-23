import org.features.authorization.*;
import org.junit.jupiter.api.Test;
import org.features.Account;
import org.features.Transaction;
import static org.junit.jupiter.api.Assertions.*;

public class DoubledTransactionStrategyTest {

    @Test
    public void testAuthorizeWhenTimeIsDifferent() {
        Account account = new Account(true, 1000);
        Transaction transaction = new Transaction(100, "Amazon", 1);
        account.addTransaction(transaction);
        DoubledTransactionStrategy strategy = new DoubledTransactionStrategy();


        Transaction transaction2 = new Transaction(100, "Amazon", System.currentTimeMillis());
        AuthorizationResult result = strategy.authorize(transaction2, account);

        assertNull(result, "Should return null when account time is bigger than 2 minutes");
    }

    @Test
    public void testAuthorizeWhenAccountIsNotActive() {
        Account account = new Account(true, 1000);
        Transaction transaction = new Transaction(100, "Amazon", System.currentTimeMillis());
        account.addTransaction(transaction);
        DoubledTransactionStrategy strategy = new DoubledTransactionStrategy();


        Transaction transaction2 = new Transaction(100, "Amazon", System.currentTimeMillis());
        AuthorizationResult result = strategy.authorize(transaction2, account);


        assertEquals("doubled-transaction", result.getViolations().get(0), "Should return 'doubled-transaction' violation");
    }
}
