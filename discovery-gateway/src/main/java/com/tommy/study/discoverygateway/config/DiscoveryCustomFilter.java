package com.tommy.study.discoverygateway.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class DiscoveryCustomFilter
    extends AbstractGatewayFilterFactory<DiscoveryCustomFilter.Config> {

  public DiscoveryCustomFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {

    // custom pre filter
    return (exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      ServerHttpResponse response = exchange.getResponse();
      log.info("Custom pre filter: request id -> {}", request.getId());

      // custom post filter
      return chain
          .filter(exchange)
          .then(
              Mono.fromRunnable(
                  () -> {
                    log.info("custom post filter: response code -> {}", response.getStatusCode());
                  }));
    };
  }

  public static class Config {
    // put configuration properties
  }
}
