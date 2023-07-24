package com.xchangeapp.fxrateservice.controller;

import com.google.gson.JsonObject;
import com.xchangeapp.fxrateservice.data.Currency;
import com.xchangeapp.fxrateservice.service.FxRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fx")
public class FxRateController {
    
    private final FxRateService fxRateService;
    
    @GetMapping("/latest")
    public JsonObject getLatestRates(@RequestParam(required = false, defaultValue = "TRY") Currency currency) {
        return fxRateService.getLatestRates(currency);
    }
    
}
