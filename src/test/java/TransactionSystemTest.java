import org.features.Account;
import org.features.Transaction;
import org.junit.jupiter.api.Test;
import java.util.Date;


public class TransactionSystemTest {

    @Test
    public void testAddTransactionToAccountHistory() {
        Account account = new Account(true,1000);
        Transaction transaction = new Transaction(100, "Amazon", System.currentTimeMillis());

        account.getHistory().add(transaction);

        int expectedHistorySize = 1;
        int actualHistorySize = account.getHistory().size();

        assert expectedHistorySize == actualHistorySize :
                "O historico da conta deveria ter uma transacao apos a adicao.";
    }

}