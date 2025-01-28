package com.tommy.study.domain.myjob.controller;

import com.tommy.study.domain.myjob.entity.MyJobTest;
import com.tommy.study.domain.myjob.repository.MyJobTestRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(name = "Test API", description = "test init api..")
public class TestController {

  private final MyJobTestRepository myJobTestRepository;

  @Operation(summary = "Get MyJob", description = "test endpoint")
  @GetMapping("/{id}")
  public MyJobTest findAllByMyJobTest(@PathVariable(value = "id") Long id) {
    return myJobTestRepository.findById(id).orElse(null);
  }
}
