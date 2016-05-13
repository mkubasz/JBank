package DomainModule;

import DomainModule.AccountAggregate.AccountNumber;
import DomainModule.UserAggregate.Address;
import DomainModule.UserAggregate.Name;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Transaction {
    public TransactionId transactionId;
    public Transaction(AccountNumber accountNumber) {

    }

    public Transaction(Name name, AccountNumber accountNumber) {

    }

    public Transaction(Name name, AccountNumber accountNumber, Address address) {

    }
}
