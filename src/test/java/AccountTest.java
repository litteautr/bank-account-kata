import fr.rli.domain.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void initialise() {
        account = new Account();
    }

    @Test
    public void should_increase_amount_when_making_deposit() {
        double depositAmount = 100.50;

        account.deposit(depositAmount);

        assertEquals(depositAmount, account.getBalance());
    }

    @Test
    public void should_decrease_amount_when_making_withdrawal() {
        double withdrawalAmount = 100.50;

        account.withdrawal(withdrawalAmount);

        assertEquals(-withdrawalAmount, account.getBalance());
    }

}
