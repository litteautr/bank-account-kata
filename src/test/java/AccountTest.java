import fr.rli.domain.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AccountTest {

    @Test
    public void should_increase_amount_when_making_deposit() {
        //Given
        Account account = new Account();
        double depositAmount = 100.50;

        //when
        account.deposit(depositAmount);

        //then
        Assertions.assertEquals(depositAmount, account.getBalance());
    }
}
