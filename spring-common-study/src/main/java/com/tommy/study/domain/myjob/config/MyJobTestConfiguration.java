package com.tommy.study.domain.myjob.config;

import com.tommy.study.domain.myjob.entity.MyJobTest;
import com.tommy.study.domain.myjob.entity.MyJobTestRecord;
import com.tommy.study.domain.myjob.repository.MyJobTestRecordRepository;
import com.tommy.study.domain.myjob.repository.MyJobTestRepository;
import java.time.LocalDateTime;
import java.util.UUID;
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
  private final MyJobTestRecordRepository myJobTestRecordRepository;

  @Bean
  MyJobTest getMyJobTest() {
    var myJobTest = myJobTestRepository.findById(1L).stream().findFirst().orElse(null);
    if (!ObjectUtils.isEmpty(myJobTest)) {
      log.info("myJobTest => {}", myJobTest.getName());
    }
    return myJobTest;
  }

  @Bean
  MyJobTestRecord getMyJobTestRecord() {
    var myJobTest = myJobTestRecordRepository.findById(1L).stream().findFirst().orElse(null);
    if (!ObjectUtils.isEmpty(myJobTest)) {
      var changeMyJobTest = myJobTestRecordRepository.save(myJobTest.changeName("tommy hello!"));
      log.info("MyJobTestRecord => {}", changeMyJobTest.name());
    }

    myJobTestRecordRepository.save(
        MyJobTestRecord.builder()
            .name("hello" + UUID.randomUUID().toString().substring(1, 5))
            .createdAt(LocalDateTime.now())
            .createdBy("tommy")
            .build());

    return myJobTest;
  }
}
