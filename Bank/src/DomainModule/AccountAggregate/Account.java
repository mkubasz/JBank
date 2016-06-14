package DomainModule.AccountAggregate;

import DomainModule.Transaction;
import InfrastructureModule.UsersDb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Account {
    private AccountId accountId;
    private String name;
    private AccountNumber accountNumber;
    private Amount amount;
    private List<Transaction> transactions = new ArrayList<>();
    public Account(String name) {
        this.accountNumber = new AccountNumber("0001");
        this.name = name;
        this.amount = new Amount(100);
    }
    public Account(String name, String accountNumber) {
        this.accountNumber = new AccountNumber(accountNumber);
        this.name = name;
        this.amount = new Amount(100);
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

    public boolean sendTransaction(Transaction transaction, UsersDb dbContext) {

        if(dbContext.findAccountNumber(transaction.accountNumber.toString())==null)
            return false;
        amount = amount.subtract(transaction.amount);

        transactions.add(transaction);
        return true;
    }

    public List<Transaction> getTransactionsHistory(LocalDate dateFrom, LocalDate dateTo) {
        return transactions
                .stream()
                .filter(item ->
                        item.date.isAfter(dateFrom)
                                && item.date.isBefore(dateTo))
                .collect(Collectors.toList());
    }

    public List<Transaction> getTransactionsByAccountNumber(final AccountNumber accountNumber) {
       return transactions.stream().filter(item -> item.accountNumber.equals(accountNumber)).collect(Collectors.toList());
    }
    public AccountNumber getAccountNumber() {
        return accountNumber;
    }
}
