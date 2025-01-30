package com.tommy.study.properties;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("mysql")
public record MysqlProperties(@NotBlank String username, @NotBlank String password) {}
