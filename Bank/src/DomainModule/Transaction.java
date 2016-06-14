package DomainModule;

import DomainModule.AccountAggregate.AccountNumber;
import DomainModule.AccountAggregate.Amount;
import DomainModule.UserAggregate.Address;
import DomainModule.UserAggregate.Name;

import java.time.LocalDate;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Transaction {
    public Name name;
    public TransactionId transactionId;
    public AccountNumber accountNumber;
    public Amount amount;
    public Address address;
    public LocalDate date;
    public Transaction(AccountNumber accountNumber) {
        this.accountNumber = accountNumber;
        date = LocalDate.now();
    }

    public Transaction(Name name, AccountNumber accountNumber, Amount amount) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
        date = LocalDate.now();
    }

    public Transaction(Name name, AccountNumber accountNumber, Amount amount, Address address) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.address = address;
        date = LocalDate.now();
    }
}
