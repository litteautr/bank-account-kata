package fr.rli.domain;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountHistoryTest {

    @Test
    public void should_print_one_history_line() {
        double depositAmount = 100.50;
        LocalDate depositDate = LocalDate.of(2020, 02, 02);
        Operation operation = new Operation(depositAmount, depositDate);

        AccountHistory history = new AccountHistory();
        history.addHistoryLine(operation, 100.50);

        PrintStream printStream = mock(PrintStream.class);

        history.print(printStream);

        verify(printStream).println("2020-02-02 || 100.50 || 100.50");
    }
}
