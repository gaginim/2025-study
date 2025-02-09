package com.tommy.study.discoverygatewayservice.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("test")
@RestController
@RequestMapping("/second-service")
public class SecondController {

  @GetMapping("welcome")
  public String welcome() {
    return "Good luck second me.";
  }
}
