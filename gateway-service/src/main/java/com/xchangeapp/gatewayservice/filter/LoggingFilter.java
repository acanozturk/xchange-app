package com.xchangeapp.gatewayservice.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;

@Component
@Slf4j
public class LoggingFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        final Set<URI> uriList = exchange.getAttributeOrDefault(
                GATEWAY_ORIGINAL_REQUEST_URL_ATTR,
                Collections.emptySet()
        );

        final String originalUri = uriList.isEmpty()
                ? "Unknown"
                : uriList.iterator().next().toString();

        final Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        final URI routeUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);

        log.info(
                "Request received: {}. Forwarded to {} with id {}",
                originalUri,
                routeUri,
                route.getId()
        );

        return chain.filter(exchange);
    }

}
