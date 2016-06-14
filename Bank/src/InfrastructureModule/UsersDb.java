package InfrastructureModule;

import DomainModule.AccountAggregate.Account;
import DomainModule.AccountAggregate.AccountNumber;
import DomainModule.UserAggregate.Address;
import DomainModule.UserAggregate.Name;
import DomainModule.UserAggregate.Password;
import DomainModule.UserAggregate.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkuba on 14.06.2016.
 */
public class UsersDb
{
    public List<User> users;
    public UsersDb(){
        users = new ArrayList<>();
       users.add(new User(
                new Name("Adam","Niezgoda"),
                new Address("Polska","Opole","45-047","Warynskiego","31","30"),
                new Password("test"),
                new Account("test","213")));
    }
    public void add(User user){
        users.add(user);
    }

    public User findAccountNumber(String accountNumber) {
        for (User user : users){
            if(user.isAccountNumber(accountNumber))
                return user;
        }
        return null;
    }
}
