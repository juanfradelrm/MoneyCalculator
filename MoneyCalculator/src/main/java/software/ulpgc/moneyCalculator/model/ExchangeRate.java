package software.ulpgc.moneyCalculator.model;

import java.time.LocalDate;

public record ExchangeRate(LocalDate localDate, double rate, Currency from, Currency to) {
}
