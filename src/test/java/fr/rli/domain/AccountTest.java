package fr.rli.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {

    private static final double OPERATION_AMOUNT = 100.50;
    private static final LocalDate OPERATION_DATE = LocalDate.now();

    private Account account;
    private AccountHistory history;

    @BeforeEach
    public void initialise() {
        history = mock(AccountHistory.class);
        account = new Account(history);
    }

    @Test
    public void should_increase_amount_when_making_deposit() {
        double depositAmount = 100.5;
        LocalDate depositDate = LocalDate.now();

        account.deposit(depositAmount, depositDate);

        assertEquals(100.5, account.getBalance());
    }

    @Test
    public void should_decrease_amount_when_making_withdrawal() {
        double withdrawalAmount = 100.5;
        LocalDate withdrawalDate = LocalDate.now();

        account.withdrawal(withdrawalAmount, withdrawalDate);

        assertEquals(-100.5, account.getBalance());
    }

    @Test
    public void should_create_history_line_when_making_deposit() {
        double depositAmount = 100.5;
        LocalDate depositDate = LocalDate.now();

        account.deposit(depositAmount, depositDate);

        verify(history).addHistoryLine(new Operation(depositAmount, depositDate), 100.5);
    }

    @Test
    public void should_create_history_line_when_making_withdrawal() {
        double withdrawalAmount = 100.5;
        LocalDate withdrawalDate = LocalDate.now();

        account.withdrawal(withdrawalAmount, withdrawalDate);

        verify(history).addHistoryLine(new Operation(-withdrawalAmount, withdrawalDate), -100.5);
    }

    @Test
    public void should_print_account_history() {
        account.printHistory(System.out);
        verify(history).print(System.out);
    }
}
