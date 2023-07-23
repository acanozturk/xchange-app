package com.xchangeapp.fxrateservice.data;

import lombok.Builder;

@Builder
public record FxRate(String baseCurrency, String fxRates, String createdAt) {
    
}
