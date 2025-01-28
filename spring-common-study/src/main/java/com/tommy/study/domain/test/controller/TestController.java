package com.tommy.study.domain.test.controller;

import com.tommy.study.domain.test.entity.MyJobTest;
import com.tommy.study.domain.test.repository.MyJobTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

  private final MyJobTestRepository myJobTestRepository;

  @GetMapping("/{id}")
  public MyJobTest findAllByMyJobTest(@PathVariable(value = "id") Long id) {
    return myJobTestRepository.findById(id).orElse(null);
  }
}
