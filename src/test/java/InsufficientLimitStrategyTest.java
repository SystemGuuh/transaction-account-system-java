import org.features.authorization.*;
import org.junit.jupiter.api.Test;
import org.features.Account;
import org.features.Transaction;
import static org.junit.jupiter.api.Assertions.*;

public class InsufficientLimitStrategyTest {

    @Test
    public void testAuthorizeWhenAvaliableLimitIsBiggerThanTrasactionAmount() {
        Account account = new Account(true, 1000);
        Transaction transaction = new Transaction(999, "Amazon", 1);
        InsufficientLimitStrategy strategy = new InsufficientLimitStrategy();


        AuthorizationResult result = strategy.authorize(transaction, account);

        assertNull(result, "Should return null when AvaliableLimit > Amount");
    }

    @Test
    public void testAuthorizeWhenAvaliableLimitIsLessThanTrasactionAmount() {
        Account account = new Account(true, 1000);
        Transaction transaction = new Transaction(1001, "Amazon", 1);
        InsufficientLimitStrategy strategy = new InsufficientLimitStrategy();


        AuthorizationResult result = strategy.authorize(transaction, account);

        assertEquals(" insufficient-limit", result.getViolations().get(0), "Should return ' insufficient-limit' violation");
    }
}
