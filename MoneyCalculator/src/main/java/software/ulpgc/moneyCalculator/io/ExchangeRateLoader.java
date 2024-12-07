package software.ulpgc.moneyCalculator.io;

import software.ulpgc.moneyCalculator.model.Currency;
import software.ulpgc.moneyCalculator.model.ExchangeRate;

import java.io.IOException;
import java.time.LocalDate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to) throws IOException;
    ExchangeRate load(Currency from, Currency to, LocalDate date) throws IOException;
}
