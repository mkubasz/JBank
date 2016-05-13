package Tests

import DomainModule.AccountAggregate.Account
import DomainModule.AccountAggregate.AccountNumber
import DomainModule.Transaction
import DomainModule.UserAggregate.Address
import DomainModule.UserAggregate.Name
import DomainModule.UserAggregate.Password
import DomainModule.UserAggregate.User
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by mkuba on 12.05.2016.
 */
class BankTest {
private User user;
    @Before
    public void setUp(){
        user  = new User(
                new Name("Mateusz","Kubaszek"),
                new Address("Polska","Opole","45-047","Warynskiego","31","30"),
                new Password("test"),
                new Account("pierwszy"));
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
        Assert.assertEquals("0",account.checkAmount());
    }
    @Test
    public void checkTransactionSendAll(){
        Account account = user.getAccount("pierwszy");
        boolean transactionSend = account.sendTransaction(
                new Transaction(
                        new Name("Adam", "Niezgoda"),
                        new AccountNumber("213"),
                        new Address("Polska","Opole","45-047","Warynskiego","31","30")
                ));
        Assert.assertTrue(transactionSend);
    }
    @Test
    public void checkTransactionSendName(){
        Account account = user.getAccount("pierwszy");
        boolean transactionSend = account.sendTransaction(
                new Transaction(
                        new Name("Adam", "Niezgoda"),
                        new AccountNumber("213")
                ));
        Assert.assertTrue(transactionSend);
    }
    @Test
    public void checkTransactionSend(){
        Account account = user.getAccount("pierwszy");
        boolean transactionSend = account.sendTransaction(
                new Transaction(
                        new AccountNumber("213")
                ));
        Assert.assertTrue(transactionSend);
    }
    @Test
    public void checkTransactionReceived(){
        Account account = user.getAccount("pierwszy");
       account.sendTransaction(
                new Transaction(
                        new AccountNumber("213")
                ));
        boolean transactionReceived = account.checkLastTransaction();
        Assert.assertTrue(transactionReceived);
    }
    @Test
    public void getListTransactionsHistory(){
        Account account = user.getAccount("pierwszy");
        List<Transaction> testTrans = new ArrayList<>();
        account.sendTransaction(
                new Transaction(
                        new AccountNumber("213")
                ));
        List<Transaction> transactionHistory = account.getTransactionsHistory("21.01.2016","12.05.2016");
        Assert.assertArrayEquals(testTrans,transactionHistory.toArray());
    }
}
