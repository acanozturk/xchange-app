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

    @Value("${apm.application-packages}")
    private String applicationPackages;

    @Value("${apm.environment}")
    private String environment;

    @Value("${apm.secret-token}")
    private String secretToken;

    @Value("${apm.server-url}")
    private String serverUrl;

    @Value("${apm.service-name}")
    private String serviceName;

    @PostConstruct
    public void init() {
        if (enabled) {
            final Map<String, String> apmConfig = Map.of(
                    "application_packages", applicationPackages,
                    "environment", environment,
                    "secret_token", secretToken,
                    "server_url", serverUrl,
                    "service_name", serviceName
            );

            ElasticApmAttacher.attach(apmConfig);
        }
    }

}
