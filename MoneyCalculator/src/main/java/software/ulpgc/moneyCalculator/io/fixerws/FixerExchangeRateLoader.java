package software.ulpgc.moneyCalculator.io.fixerws;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneyCalculator.io.ExchangeRateLoader;
import software.ulpgc.moneyCalculator.model.Currency;
import software.ulpgc.moneyCalculator.model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Map;

public class FixerExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) throws IOException {
        try {
            return load(from, to, LocalDate.now());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ExchangeRate load(Currency from, Currency to, LocalDate localDate) throws IOException {
        try {
            String json = loadJson(localDate);
            return ExchangeRateLoad(from, to, json, localDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ExchangeRate ExchangeRateLoad(Currency from, Currency to, String json, LocalDate localDate) {
        Map<String, JsonElement> exchageRates = new Gson().fromJson(json, JsonObject.class).get("rates").getAsJsonObject().asMap();
        Double rateFrom = null;
        Double rateTo = null;
        for (String code : exchageRates.keySet()){
            if (code.equals(from.code())){rateFrom = exchageRates.get(code).getAsDouble();}
            if (code.equals(to.code())){rateTo = exchageRates.get(code).getAsDouble();}
        }
        return new ExchangeRate(localDate, rateTo / rateFrom, from, to);
    }

    private String loadJson(LocalDate localDate) throws IOException {
        String date = localDate.toString();
        String urlString = "http://data.fixer.io/api/" + date + "?access_key=" + FixerAPI.key;
        URL url = new URL(urlString);
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
