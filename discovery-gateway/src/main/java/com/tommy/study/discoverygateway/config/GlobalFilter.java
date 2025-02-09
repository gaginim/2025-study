package com.tommy.study.discoverygateway.config;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Log4j2
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {

  public GlobalFilter() {
    super(Config.class);
  }

  @Override
  public GatewayFilter apply(Config config) {

    // custom pre filter
    return (exchange, chain) -> {
      ServerHttpRequest request = exchange.getRequest();
      ServerHttpResponse response = exchange.getResponse();
      log.info("GlobalFilter baseMessage: {}", config.getBaseMessage());

      if (config.isPreLogger()) {
        log.info("GlobalFilter Start: request id -> {}", request.getId());
      }

      return chain
          .filter(exchange)
          .then(
              Mono.fromRunnable(
                  () -> {
                    if (config.isPostLogger()) {
                      log.info("GlobalFilter End: response code -> {}", response.getStatusCode());
                    }
                  }));
    };
  }

  @Data
  public static class Config {
    // put configuration properties
    private String baseMessage;
    private boolean preLogger;
    private boolean postLogger;
  }
}
