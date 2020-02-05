package fr.rli.domain;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OperationTest {

    @Test
    public void should_print_deposit_operation() {
        double depositAmount = 100.50;
        LocalDate depositDate = LocalDate.of(2020, 02, 02);
        Operation operation = new Operation(depositAmount, depositDate);

        PrintStream printStream = mock(PrintStream.class);

        operation.print(printStream, 100.50);

        verify(printStream).println("2020-02-02 || 100.50 || 100.50");
    }
}