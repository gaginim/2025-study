package com.tommy.study.discoveryserviceuser.properties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("integration")
public record IntegrationProperties(@NotNull Greeting greeting) {
  public record Greeting(@NotBlank String message) {}
}
