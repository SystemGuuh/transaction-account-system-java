import org.features.Account;
import org.features.Transaction;
import org.junit.jupiter.api.Test;

public class TransactionSystemTest {

    @Test
    public void testAddTransactionToAccountHistory() {
        Account account = new Account(true, 0.0,1000);
        Transaction transaction = new Transaction(100, "Amazon", "2022-04-14T14:30:00");

        account.getHistory().add(transaction);

        int expectedHistorySize = 1;
        int actualHistorySize = account.getHistory().size();

        assert expectedHistorySize == actualHistorySize :
                "O historico da conta deveria ter uma transacao apos a adicao.";
    }

    @Test
    public void testBelanceCalculationFromAccount(){
        Account account = new Account(true, 0.0,1000);
        Transaction transaction0 = new Transaction(800.0, "Pix", "2022-04-14T12:00:00");
        Transaction transaction1 = new Transaction(-200.5, "Market", "2022-04-14T14:30:00");
        Transaction transaction2 = new Transaction(0.5, "Freelance", "2022-04-14T14:00:00");
        Transaction transaction3 = new Transaction(100.0, "Cine", "2022-04-14T16:30:00");
        Transaction transaction4 = new Transaction(-100.0, "Dinner", "2022-04-14T22:30:00");

        account.addTransaction(transaction0);
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);
        account.addTransaction(transaction3);
        account.addTransaction(transaction4);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double actualBalance = account.getBalance();
        double expectedBalance = 800 - 200.5 + 0.5 + 100 - 100;
        assert actualBalance == expectedBalance :
                "O valor da conta deveria ser: R$" + expectedBalance + " ,mas era: R$"+ actualBalance;
    }
}