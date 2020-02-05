package fr.rli.domain;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

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

    @Test
    public void should_print_preserve_order_for_multiple_line_history() {
        Operation firstOperation = new Operation(100, LocalDate.of(2020, 02, 02));
        Operation secondOperation = new Operation(-200, LocalDate.of(2020, 02, 03));
        Operation thirdOperation = new Operation(1000.75, LocalDate.of(2020, 02, 04));

        AccountHistory history = new AccountHistory();
        history.addHistoryLine(firstOperation, 100);
        history.addHistoryLine(secondOperation, -100);
        history.addHistoryLine(thirdOperation, 900.75);

        PrintStream printStream = mock(PrintStream.class);
        InOrder orderedPrint = Mockito.inOrder(printStream);

        history.print(printStream);

        orderedPrint.verify(printStream).println("2020-02-04 || 1000.75 || 900.75");
        orderedPrint.verify(printStream).println("2020-02-03 || -200.00 || -100.00");
        orderedPrint.verify(printStream).println("2020-02-02 || 100.00 || 100.00");
    }
}
