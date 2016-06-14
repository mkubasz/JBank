package DomainModule.AccountAggregate;

/**
 * Created by mkuba on 12.05.2016.
 */
public class Amount {

    private long amount;

    public Amount(long amount){

        this.amount = amount;
    }

    public Amount subtract(Amount amount){
        return new Amount(this.amount - amount.amount);
    }
    @Override
    public String toString() {
        return Long.toString(this.amount);
    }
}
