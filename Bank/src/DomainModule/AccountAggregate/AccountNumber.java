package DomainModule.AccountAggregate;

/**
 * Created by mkuba on 12.05.2016.
 */
public class AccountNumber {
    private String accountNumber;

    public AccountNumber(String accountNumber){

        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return accountNumber;
    }
}
