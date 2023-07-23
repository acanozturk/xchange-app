package com.xchangeapp.fxrateservice.service;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.client.ExchangeRateApiFeignClient;
import com.xchangeapp.fxrateservice.data.Currency;
import com.xchangeapp.fxrateservice.repository.FxRateRepository;
import com.xchangeapp.fxrateservice.util.Constant;
import com.xchangeapp.fxrateservice.util.FxRateUtil;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FxRateService {

    private final ExchangeRateApiFeignClient exchangeRateApiFeignClient;
    
    private final FxRateRepository fxRateRepository;
    
    @Cacheable(value = Constant.CACHE_FX_RATES, key = "#currency.name()")
    public JsonObject getLatestRates(Currency currency) {
        final JsonObject apiResponse = exchangeRateApiFeignClient.getLatestRates(currency);
        final JsonObject latestRates = FxRateUtil.removeUnnecessaryFields(apiResponse);
        
        fxRateRepository.save(latestRates);
        
        return latestRates;
    }

}
