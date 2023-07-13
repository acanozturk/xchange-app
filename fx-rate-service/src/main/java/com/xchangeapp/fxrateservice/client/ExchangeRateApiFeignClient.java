package com.xchangeapp.fxrateservice.client;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.data.enumeration.Currency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "exchange-rate-api",
        url = "${exchange-rate-api.url}"
)
public interface ExchangeRateApiFeignClient {

    @GetMapping(
            value = "/latest/{currency}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    JsonObject getLatestRates(@PathVariable Currency currency);

}