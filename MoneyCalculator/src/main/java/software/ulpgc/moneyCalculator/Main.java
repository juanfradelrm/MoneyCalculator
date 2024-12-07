package software.ulpgc.moneyCalculator;


import software.ulpgc.moneyCalculator.control.Command;
import software.ulpgc.moneyCalculator.control.ExchangeMoneyCommand;
import software.ulpgc.moneyCalculator.io.fixerws.FixerCurrencyLoader;
import software.ulpgc.moneyCalculator.io.fixerws.FixerExchangeRateLoader;
import software.ulpgc.moneyCalculator.model.Currency;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new FixerExchangeRateLoader(),
                main.moneyDisplay());
        main.put("Exchange money", command);
        main.setVisible(true);
    }
}
