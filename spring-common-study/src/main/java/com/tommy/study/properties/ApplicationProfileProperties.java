package com.tommy.study.properties;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("spring.profiles")
public record ApplicationProfileProperties(@NotBlank String active) {}
