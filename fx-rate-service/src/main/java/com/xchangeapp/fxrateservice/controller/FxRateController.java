package com.xchangeapp.fxrateservice.controller;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.data.enumeration.Currency;
import com.xchangeapp.fxrateservice.service.FxRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/fx")
public class FxRateController {
    
    private final FxRateService fxRateService;
    
    @GetMapping("/latest/{currency}")
    public JsonObject getLatestRates(@PathVariable Currency currency) {
        return fxRateService.getLatestRates(currency);
    }
    
}
