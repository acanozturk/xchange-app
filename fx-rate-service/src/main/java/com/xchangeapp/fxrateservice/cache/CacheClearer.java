package com.xchangeapp.fxrateservice.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheClearer {

    @Scheduled(cron = CacheConstant.FX_RATES_CRON)
    @CacheEvict(value = CacheConstant.FX_RATES)
    public void clearFxRatesCache() {
        log.info("Clearing fx-rates cache..");
    }
    
}
