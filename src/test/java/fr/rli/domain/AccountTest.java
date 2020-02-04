package fr.rli.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountTest {

    private static final double OPERATION_AMOUNT = 100.50;
    private static final LocalDate OPERATION_DATE = LocalDate.now();

    private Account account;
    private List<Operation> history;

    @BeforeEach
    public void initialise() {
        history = mock(ArrayList.class);
        account = new Account(history);
    }

    @Test
    public void should_increase_amount_when_making_deposit() {
        account.deposit(OPERATION_AMOUNT, OPERATION_DATE);

        assertEquals(OPERATION_AMOUNT, account.getBalance());
    }

    @Test
    public void should_decrease_amount_when_making_withdrawal() {
        account.withdrawal(OPERATION_AMOUNT, OPERATION_DATE);

        assertEquals(-OPERATION_AMOUNT, account.getBalance());
    }

    @Test
    public void should_create_operation_when_making_deposit() {
        account.deposit(OPERATION_AMOUNT, OPERATION_DATE);

        verify(history).add(new Operation(OPERATION_AMOUNT, OPERATION_DATE));
    }

    @Test
    public void should_create_operation_when_making_withdrawal() {
        account.withdrawal(OPERATION_AMOUNT, OPERATION_DATE);

        verify(history).add(new Operation(-OPERATION_AMOUNT, OPERATION_DATE));
    }
}
