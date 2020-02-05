package fr.rli.domain;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountHistory {

    private List<HistoryLine> historyLines = new ArrayList<>();

    public void addHistoryLine(Operation operation, double accountBalance) {
        historyLines.add(new HistoryLine(operation, accountBalance));
    }

    public void print(PrintStream printStream) {
        orderHistoryLineForPrinting();
        historyLines.forEach(historyLine -> historyLine.print(printStream));
    }

    private void orderHistoryLineForPrinting() {
        Collections.reverse(historyLines);
    }
}
