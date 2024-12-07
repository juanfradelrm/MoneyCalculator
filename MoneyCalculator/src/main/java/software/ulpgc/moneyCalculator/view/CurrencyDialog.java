package software.ulpgc.moneyCalculator.view;

import software.ulpgc.moneyCalculator.model.Currency;
import software.ulpgc.moneyCalculator.model.Money;

import java.util.List;

public interface CurrencyDialog {
    CurrencyDialog define(List<Currency> currencies);
    Currency get();
}
