package software.ulpgc.moneyCalculator.io;

import software.ulpgc.moneyCalculator.model.Currency;

import java.io.IOException;
import java.util.List;

public interface CurrencyLoader {
    List<Currency> load() throws IOException;
}
