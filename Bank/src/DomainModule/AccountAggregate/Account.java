package DomainModule.AccountAggregate;

import DomainModule.Transaction;

import java.util.List;
import java.util.Objects;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Account {
    private AccountId accountId;
    private String name;
    private AccountNumber accountNumber;
    private Amount amount;
    public Account(String name) {
        this.accountNumber = new AccountNumber("0001");
        this.name = name;
    }

    public static boolean exist(Account account) {
        return false;
    }

    public boolean haveName(String accountName) {
        return Objects.equals(name, accountName);
    }

    public String getInfo() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Name: " + name + ",Account number: " + accountNumber.toString();
    }

    public String checkAmount() {
        if(amount == null) return "0";
        return amount.toString();
    }

    public boolean checkLastTransaction() {

        return  false;
    }

    public boolean sendTransaction(Transaction transaction) {
        return false;
    }

    public List<Transaction> getTransactionsHistory(String dateFrom, String dateTo) {
        return null;
    }
}
