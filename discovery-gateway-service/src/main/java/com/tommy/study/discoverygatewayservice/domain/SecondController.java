package com.tommy.study.discoverygatewayservice.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class SecondController {

  @GetMapping("welcome")
  public String welcome() {
    return "Good luck first me.";
  }
}
