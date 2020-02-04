import fr.rli.domain.Account;
import fr.rli.domain.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {

    private Account account;
    private List<Operation> history;

    @BeforeEach
    public void initialise() {
        history = mock(ArrayList.class);
        account = new Account(history);
    }

    @Test
    public void should_increase_amount_when_making_deposit() {
        double depositAmount = 100.50;

        account.deposit(depositAmount, LocalDate.now());

        assertEquals(depositAmount, account.getBalance());
    }

    @Test
    public void should_decrease_amount_when_making_withdrawal() {
        double withdrawalAmount = 100.50;

        account.withdrawal(withdrawalAmount);

        assertEquals(-withdrawalAmount, account.getBalance());
    }

    @Test
    public void should_create_operation_when_making_deposit() {
        LocalDate depositDate = LocalDate.now();
        double depositAmount = 100.50;

        account.deposit(depositAmount, depositDate);

        verify(history).add(new Operation(depositAmount, depositDate));
    }
}
