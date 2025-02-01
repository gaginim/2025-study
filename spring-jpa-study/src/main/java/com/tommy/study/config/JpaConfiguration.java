package com.tommy.study.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.tommy.study.domain.**.repository"})
@EntityScan(basePackages = "com.tommy.study.domain.**.entity")
public class JpaConfiguration {}
