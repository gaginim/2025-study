package com.tommy.study.domain.test.config;

import com.tommy.study.domain.test.entity.MyJobTest;
import com.tommy.study.domain.test.repository.MyJobTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

@Log4j2
@RequiredArgsConstructor
@Configuration
public class MyJobTestConfiguration {
  private final MyJobTestRepository myJobTestRepository;

  @Bean
  MyJobTest getMyJobTest() {
    var myJobTest = myJobTestRepository.findById(1L).stream().findFirst().orElse(null);
    if (!ObjectUtils.isEmpty(myJobTest)) {
      log.info("myJobTest => {}", myJobTest.getName());
    }
    return myJobTest;
  }
}
