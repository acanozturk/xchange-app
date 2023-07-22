package com.xchangeapp.fxrateservice.config;

import co.elastic.apm.attach.ElasticApmAttacher;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ElasticsearchApmConfig {

    @Value("${apm.enabled}")
    private boolean enabled;

    @Value("${apm.environment}")
    private String environment;

    @Value("${apm.server-url}")
    private String serverUrl;

    @Value("${apm.secret-token}")
    private String secretToken;

    @Value("${apm.service-name}")
    private String serviceName;

    @Value("${apm.application-packages}")
    private String applicationPackages;

    @PostConstruct
    public void init() {
        if (enabled) {
            final Map<String, String> apmConfig = Map.of(
                    "environment", environment,
                    "server_url", serverUrl,
                    "secret_token", secretToken,
                    "service_name", serviceName,
                    "application_packages", applicationPackages
            );

            ElasticApmAttacher.attach(apmConfig);
        }
    }

}
