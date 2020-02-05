package fr.rli.domain;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HistoryLineTest {

    @Test
    public void should_print_one_history_line() {
        double depositAmount = 100.5;
        LocalDate depositDate = LocalDate.of(2020, 2, 2);
        Operation operation = new Operation(depositAmount, depositDate);

        HistoryLine historyLine = new HistoryLine(operation, 100.5);

        System.setOut(mock(PrintStream.class));

        historyLine.print();

        verify(System.out).println("2020-02-02 || 100.50 || 100.50");
    }
}
