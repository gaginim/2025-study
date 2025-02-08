package com.tommy.study.discoverygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommerceEurekaServerConfig {

  @Bean
  public RouteLocator gatewayRouters(RouteLocatorBuilder builder) {
    return builder
        .routes()
        .route(r -> r.path("/first-service/**").uri("http://localhost:6001"))
        .route(r -> r.path("/second-service/**").uri("http://localhost:6002"))
        .build();
  }
}
