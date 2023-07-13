package com.xchangeapp.fxrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableFeignClients
@EnableScheduling
public class FxRateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FxRateServiceApplication.class, args);
    }

}
