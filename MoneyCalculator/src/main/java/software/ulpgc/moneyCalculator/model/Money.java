package software.ulpgc.moneyCalculator.model;


public record Money(Long amount, Currency currency) {

    @Override
    public String toString() {
        return amount +  " " + currency;
    }
}
