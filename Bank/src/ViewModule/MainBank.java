package ViewModule;

import DomainModule.*;
import DomainModule.AccountAggregate.Account;
import DomainModule.AccountAggregate.AccountNumber;
import DomainModule.UserAggregate.Address;
import DomainModule.UserAggregate.Name;
import DomainModule.UserAggregate.Password;
import DomainModule.UserAggregate.User;

import java.util.List;

/**
 * Created by mkuba on 12.05.2016.
 */
public class MainBank {
    public static void main(String[] args){
        User user = new User(
                new Name("Mateusz","Kubaszek"),
                new Address("Polska","Opole","45-047","Warynskiego","31","30"),
                new Password("test"),
                new Account("pierwsze"));
        Account account = user.getAccount("pierwsze");
        String infos = account.getInfo();
        String amount = account.checkAmount();
        boolean transactionSendAll = account.sendTransaction(new Transaction(new Name("Adam", "Niezgoda"), new AccountNumber("213"), new Address("Polska","Opole","45-047","Warynskiego","31","30")));
        boolean transactionSendName = account.sendTransaction(new Transaction(new Name("Adam", "Niezgoda"), new AccountNumber("213")));
        boolean transactionSend = account.sendTransaction(new Transaction(new AccountNumber("213")));
        boolean transactionRecivd = account.checkLastTransaction();

    }
}
