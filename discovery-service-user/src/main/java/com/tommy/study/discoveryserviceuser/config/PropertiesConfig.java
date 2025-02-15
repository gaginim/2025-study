package com.tommy.study.discoveryserviceuser.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = "com.tommy.study.**.properties")
public class PropertiesConfig {}
