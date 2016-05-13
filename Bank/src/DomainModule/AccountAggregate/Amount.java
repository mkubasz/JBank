package DomainModule.AccountAggregate;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Amount {

    private Long amount;

    public Amount(long amount){

        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.amount.toString();
    }
}
