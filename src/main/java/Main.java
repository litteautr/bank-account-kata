import fr.rli.domain.Account;
import fr.rli.domain.AccountHistory;

import java.time.LocalDate;

public class Main {

    /**
     * Execute 2 deposit & 2 withdrawal then print them
     *
     * @param args no arg needed here
     * @see README.md for requirements.
     */
    public static void main(String[] args) {
        Account account = new Account(new AccountHistory());

        account.deposit(100, LocalDate.of(2020, 1, 30));
        account.withdrawal(200, LocalDate.of(2020, 1, 31));
        account.deposit(1000.75, LocalDate.of(2020, 2, 2));
        account.withdrawal(2000.25, LocalDate.of(2020, 2, 2));

        account.printHistory();
    }
}
