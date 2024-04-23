import org.features.authorization.*;
import org.junit.jupiter.api.Test;
import org.features.Account;
import org.features.Transaction;
import static org.junit.jupiter.api.Assertions.*;

public class ActiveAccountStrategyTest {

    @Test
    public void testAuthorizeWhenAccountIsActive() {
        Account account = new Account(true, 1000);
        Transaction transaction = new Transaction(100, "Amazon", System.currentTimeMillis());
        ActiveAccountStrategy strategy = new ActiveAccountStrategy();


        AuthorizationResult result = strategy.authorize(transaction, account);

        assertNull(result, "Should return null when account is active");
    }

    @Test
    public void testAuthorizeWhenAccountIsNotActive() {
        Account account = new Account(false, 1000);
        Transaction transaction = new Transaction(100, "Amazon", System.currentTimeMillis());
        ActiveAccountStrategy strategy = new ActiveAccountStrategy();

        AuthorizationResult result = strategy.authorize(transaction, account);


        assertEquals("account-not-active", result.getViolations().get(0), "Should return 'account-not-active' violation");
    }
}
