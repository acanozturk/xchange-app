package com.xchangeapp.fxrateservice.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.client.ExchangeRateApiFeignClient;
import com.xchangeapp.fxrateservice.data.Currency;
import com.xchangeapp.fxrateservice.data.FxRate;
import com.xchangeapp.fxrateservice.kafka.producer.KafkaProducer;
import com.xchangeapp.fxrateservice.repository.FxRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.SortedMap;

@Service
@AllArgsConstructor
public class FxRateService {

    private final ExchangeRateApiFeignClient exchangeRateApiFeignClient;

    private final FxRateRepository fxRateRepository;

    private final KafkaProducer kafkaProducer;
    
    public FxRate getLatestRates(Currency currency) {
        final JsonObject apiResponse = exchangeRateApiFeignClient.getLatestRates(currency);
        final FxRate fxRate = new FxRate(
                apiResponse.get("base_code").getAsString(),
                new Gson().fromJson(apiResponse.get("conversion_rates").getAsJsonObject(), SortedMap.class)
        );

        fxRateRepository.save(fxRate);

        kafkaProducer.produce(fxRate);

        return fxRate;
    }

}
