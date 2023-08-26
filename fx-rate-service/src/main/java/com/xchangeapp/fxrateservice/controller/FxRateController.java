package com.xchangeapp.fxrateservice.controller;

import com.xchangeapp.fxrateservice.data.Currency;
import com.xchangeapp.fxrateservice.data.FxRate;
import com.xchangeapp.fxrateservice.service.FxRateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fx")
public class FxRateController {
    
    private final FxRateService fxRateService;
    
    @GetMapping("/latest")
    public FxRate getLatestRates(@RequestParam(required = false, defaultValue = "TRY") Currency currency) {
        return fxRateService.getLatestRates(currency);
    }
    
}
