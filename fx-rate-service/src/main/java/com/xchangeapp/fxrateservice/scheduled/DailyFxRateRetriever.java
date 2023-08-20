package com.xchangeapp.fxrateservice.scheduled;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.client.ExchangeRateApiFeignClient;
import com.xchangeapp.fxrateservice.data.Currency;
import com.xchangeapp.fxrateservice.kafka.producer.KafkaProducer;
import com.xchangeapp.fxrateservice.repository.FxRateRepository;
import com.xchangeapp.fxrateservice.util.FxRateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class DailyFxRateRetriever {

    private final ExchangeRateApiFeignClient exchangeRateApiFeignClient;

    private final FxRateRepository fxRateRepository;

    private final KafkaProducer kafkaProducer;

    @Scheduled(cron = "0 0 8 * * *", zone = "Europe/Istanbul")
    public void getLatestRates() {
        final JsonObject apiResponse = exchangeRateApiFeignClient.getLatestRates(Currency.TRY);
        final JsonObject latestRates = FxRateUtil.removeUnnecessaryFields(apiResponse);

        fxRateRepository.save(latestRates);

        kafkaProducer.produce(latestRates.toString());
    }

}
