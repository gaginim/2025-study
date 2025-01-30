package com.tommy.study.domain.myjob.controller;

import com.tommy.study.domain.myjob.entity.MyJobTest;
import com.tommy.study.domain.myjob.entity.MyJobTestRecord;
import com.tommy.study.domain.myjob.repository.MyJobTestRecordRepository;
import com.tommy.study.domain.myjob.repository.MyJobTestRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(name = "Test API", description = "test init api..")
@Log4j2
public class TestController {

  private final MyJobTestRepository myJobTestRepository;
  private final MyJobTestRecordRepository myJobTestRecordRepository;

  @Operation(summary = "Get MyJob", description = "test endpoint")
  @GetMapping("/{id}")
  public MyJobTest findAllByMyJobTest(@PathVariable(value = "id") Long id) {
    var myJobTest = myJobTestRepository.findById(1L).stream().findFirst().orElse(null);
    log.info("MyJobTest=> {}", myJobTest.getName());
    return myJobTest;
  }

  @Operation(summary = "Save MyJob", description = "test endpoint")
  @PostMapping("/{name}")
  public MyJobTestRecord saveMyJobTest(@PathVariable(value = "name") String name) {
    var myJobTest = myJobTestRecordRepository.save(MyJobTestRecord.builder().name(name).build());
    log.info("MyJobTestRecord => {}", myJobTest.name());
    return myJobTest;
  }
}
