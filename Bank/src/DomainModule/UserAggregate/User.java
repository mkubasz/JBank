package DomainModule.UserAggregate;

import DomainModule.AccountAggregate.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by mkuba on 12.05.2016.
 */
public class User {
    private UserId id;
    private Name name;
    private Address address;
    private Password password;
    private List<Account> accountList;

    public User(Name name, Address address, Password password, Account account){
            addUser(name, address, password, account);
    }
    public void addUser(Name name, Address address, Password password, Account account){
        id = new UserId(UUID.randomUUID());
        this.accountList = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.password = password;
        if(!Account.exist(account) && !this.accountList.contains(account)) {
            this.accountList.add(account);
        }
    }

    public Account getAccount(String accountName) {

        for (Account account : accountList) {
            if(account.haveName(accountName)){
                return account;
            }
        }
        return null;
    }

    public boolean isAccountNumber(String accountNumber) {
        for(Account account : accountList){
            if(account.getAccountNumber().toString().equals(accountNumber)){
                return true;
            }
        }
        return false;
    }
}
