package com.xchangeapp.fxrateservice.config;

import com.xchangeapp.fxrateservice.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@Slf4j
public class CacheConfig {

    private static final Set<ConcurrentMapCache> CACHES = Set.of(
            new ConcurrentMapCache(Constant.CACHE_FX_RATES)
    );

    @Bean
    public CacheManager cacheManager() {
        final SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(CACHES);
        
        log.info("Initialized {} caches.", CACHES.size());

        return cacheManager;
    }
}
