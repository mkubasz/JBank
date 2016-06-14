package Tests

import DomainModule.AccountAggregate.Account
import DomainModule.AccountAggregate.AccountNumber
import DomainModule.AccountAggregate.Amount
import DomainModule.Transaction
import DomainModule.UserAggregate.Address
import DomainModule.UserAggregate.Name
import DomainModule.UserAggregate.Password
import DomainModule.UserAggregate.User
import InfrastructureModule.UsersDb
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * Created by mkuba on 12.05.2016.
 */
class BankTest {
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    private User user;
    private  UsersDb usersDb;
    @Before
    public void setUp(){
        user  = new User(
                new Name("Mateusz","Kubaszek"),
                new Address("Polska","Opole","45-047","Warynskiego","31","30"),
                new Password("test"),
                new Account("pierwszy"));
        usersDb = new UsersDb();
        usersDb.add(user);
    }

    @Test
    public void checkInstanceAccount(){
        Account account = user.getAccount("pierwszy");
        Assert.assertNotNull(account);
    }
    @Test
    public void getInfoTest(){
        Account account = user.getAccount("pierwszy");
        Assert.assertEquals("Name: pierwszy,Account number: 0001",account.getInfo());
    }
    @Test
    public void checkAmountIfNoTransaction(){
        Account account = user.getAccount("pierwszy");
        Assert.assertEquals("100",account.checkAmount());
    }
    @Test
    public void checkTransactionSendAll(){
        Account account = user.getAccount("pierwszy");
        boolean transactionSend = account.sendTransaction(
                new Transaction(
                        new Name("Adam", "Niezgoda"),
                        new AccountNumber("213"),
                        new Amount(21),
                        new Address("Polska","Opole","45-047","Warynskiego","31","30")
                ),usersDb);
        Assert.assertTrue(transactionSend);
    }
    @Test
    public void checkTransactionSendName(){
        Account account = user.getAccount("pierwszy");
        boolean transactionSend = account.sendTransaction(
                new Transaction(
                        new Name("Adam", "Niezgoda"),
                        new AccountNumber("213"),
                        new Amount(21),
                ),usersDb);
        Assert.assertTrue(transactionSend);
    }
    @Test
    public void checkIsTransactionInSender(){
        Account account = user.getAccount("pierwszy");
        List<Transaction> transactionSend = account.getTransactionsByAccountNumber(
                        new AccountNumber("213")
                );
        Assert.assertNotNull(transactionSend);
    }
    @Test
    public void checkIsTransactionInReceived(){
        Account account = usersDb.findAccountNumber("213").getAccount("test");
        List<Transaction> transactionReceived = account.getTransactionsByAccountNumber(
                new AccountNumber("213")
        );
        Assert.assertNotNull(transactionReceived);
    }
    @Test
    public void getListTransactionsHistory(){
        Account account = user.getAccount("pierwszy");
        boolean transactionSend = account.sendTransaction(
                new Transaction(
                        new Name("Adam", "Niezgoda"),
                        new AccountNumber("213"),
                        new Amount(21),
                ),usersDb);
        List<Transaction> transactionHistory = account
                .getTransactionsHistory(
                LocalDate.parse("21.01.2016", dateTimeFormatter),
                LocalDate.parse("15.06.2016", dateTimeFormatter));
        Assert.assertNotNull(transactionHistory);
    }
}
