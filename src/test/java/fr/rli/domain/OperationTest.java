package fr.rli.domain;

import fr.rli.domain.port.IObtainOperation;
import fr.rli.infrastructure.DatabaseAdapter;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

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

    @Test
    public void should_print_one_operation_from_database() {
        double depositAmount = 200;
        LocalDate depositDate = LocalDate.of(2020, 2, 2);

        IObtainOperation dbAdapter = mock(IObtainOperation.class);
        when(dbAdapter.findOperation(1)).thenReturn(new Operation(depositAmount, depositDate));

        System.setOut(mock(PrintStream.class));

        Operation operationFromDb = dbAdapter.findOperation(1);
        operationFromDb.print(200);

        verify(System.out).println("2020-02-02 || 200.00 || 200.00");
    }
}