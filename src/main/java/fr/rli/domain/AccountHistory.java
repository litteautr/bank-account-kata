package fr.rli.domain;

import java.util.ArrayList;
import java.util.List;

public class AccountHistory {

    private List<HistoryLine> historyLines = new ArrayList<>();

    public void addHistoryLine(Operation operation, double accountBalance) {
        historyLines.add(new HistoryLine(operation, accountBalance));
    }
}
