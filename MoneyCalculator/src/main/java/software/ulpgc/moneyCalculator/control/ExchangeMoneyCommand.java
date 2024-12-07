package software.ulpgc.moneyCalculator.control;

import software.ulpgc.moneyCalculator.io.ExchangeRateLoader;
import software.ulpgc.moneyCalculator.model.Currency;
import software.ulpgc.moneyCalculator.model.ExchangeRate;
import software.ulpgc.moneyCalculator.model.Money;
import software.ulpgc.moneyCalculator.view.CurrencyDialog;
import software.ulpgc.moneyCalculator.view.MoneyDialog;
import software.ulpgc.moneyCalculator.view.MoneyDisplay;

import java.io.IOException;

public class ExchangeMoneyCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = null;
        try {
            exchangeRate = exchangeRateLoader.load(money.currency(), currency);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Money result = new Money((long) (money.amount()*exchangeRate.rate()), currency);

        moneyDisplay.show(result);
    }
}
