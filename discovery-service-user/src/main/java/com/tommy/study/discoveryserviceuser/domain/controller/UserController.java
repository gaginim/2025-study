package com.tommy.study.discoveryserviceuser.domain.controller;

import com.tommy.study.discoveryserviceuser.domain.vo.Greeting;
import com.tommy.study.discoveryserviceuser.properties.IntegrationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

  private final IntegrationProperties integrationProperties;
  private final Greeting greeting;

  @GetMapping("/health_check")
  public String status() {
    return "It's working";
  }

  @GetMapping("/greeting")
  public String greeting() {
    return integrationProperties.greeting().message();
  }

  @GetMapping("/welcome")
  public String welcome() {
    return greeting.getMessage();
  }
}
