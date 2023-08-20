package com.xchangeapp.notificationservice.email.data;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

@Getter
@Setter
public final class FxRateEmailData {

    private String baseCurrency;
    private Map<String, Double> rates;

    public FxRateEmailData(String baseCurrency, SortedMap<String, Double> rates) {
        this.baseCurrency = baseCurrency;
        
        rates.replaceAll((k, v) -> 1 / rates.get(k));
        final Map<String, Double> customOrderedRates = new LinkedHashMap<>();
        
        customOrderedRates.put("USD", rates.get("USD"));
        customOrderedRates.put("EUR", rates.get("EUR"));
        customOrderedRates.put("GBP", rates.get("GBP"));
        customOrderedRates.putAll(rates);
        
        this.rates = customOrderedRates;
    }

}
