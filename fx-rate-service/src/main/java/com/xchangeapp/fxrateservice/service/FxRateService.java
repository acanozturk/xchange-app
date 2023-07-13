package com.xchangeapp.fxrateservice.service;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.client.ExchangeRateApiFeignClient;
import com.xchangeapp.fxrateservice.cache.CacheConstant;
import com.xchangeapp.fxrateservice.data.enumeration.Currency;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FxRateService {

    private final ExchangeRateApiFeignClient exchangeRateApiFeignClient;

    @Cacheable(value = CacheConstant.FX_RATES, key = "#currency.name()")
    public JsonObject getLatestRates(Currency currency) {
        return exchangeRateApiFeignClient.getLatestRates(currency);
    }

}
