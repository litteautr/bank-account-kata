package fr.rli.domain;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OperationTest {

    @Test
    public void should_print_one_operation() {
        double depositAmount = 100.5;
        LocalDate depositDate = LocalDate.of(2020, 2, 2);
        Operation operation = new Operation(depositAmount, depositDate);

        System.setOut(mock(PrintStream.class));

        operation.print(100.5);

        verify(System.out).println("2020-02-02 || 100.50 || 100.50");
    }
}