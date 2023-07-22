package com.xchangeapp.fxrateservice.service;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.util.CacheConstant;
import com.xchangeapp.fxrateservice.client.ExchangeRateApiFeignClient;
import com.xchangeapp.fxrateservice.data.Currency;
import com.xchangeapp.fxrateservice.data.FxRate;
import com.xchangeapp.fxrateservice.repository.FxRateRepository;
import com.xchangeapp.fxrateservice.util.FxRateUtil;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class FxRateService {

    private final FxRateRepository fxRateRepository;

    private final ExchangeRateApiFeignClient exchangeRateApiFeignClient;

    @Cacheable(value = CacheConstant.FX_RATES, key = "#currency.name()")
    public JsonObject getLatestRates(Currency currency) {
        final JsonObject apiResponse = exchangeRateApiFeignClient.getLatestRates(currency);
        final JsonObject latestRates = FxRateUtil.removeUnnecessaryFields(apiResponse);

        final FxRate fxRate = FxRate.builder()
                .baseCurrency(latestRates.get("base_code").getAsString())
                .fxRates(latestRates.get("conversion_rates").getAsJsonObject().toString())
                .createdDate(Instant.now())
                .build();

        fxRateRepository.save(fxRate);

        return latestRates;
    }

}
