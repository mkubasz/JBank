package DomainModule.UserAggregate;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Password {
    String password;
    public Password(String password) {
       this.password = Password.decrypt(password);
    }

    private static String decrypt(String password) {

        return null;
    }
}
