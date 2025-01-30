package com.tommy.study.config.service;

import com.tommy.study.properties.ApplicationProfileProperties;
import com.tommy.study.properties.MysqlProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties({MysqlProperties.class, ApplicationProfileProperties.class})
public class DBConnectionPropertiesService {
  private final ApplicationProfileProperties applicationProfileProperties;
  private final MysqlProperties mysqlProperties;

  public String getUserName() {
    if ("local".equals(applicationProfileProperties.active())) {
      return mysqlProperties.username();
    }
    return null;
  }

  public String getPassword() {
    if ("local".equals(applicationProfileProperties.active())) {
      return mysqlProperties.password();
    }
    return null;
  }
}
