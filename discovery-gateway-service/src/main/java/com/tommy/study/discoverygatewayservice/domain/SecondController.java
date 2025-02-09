package com.tommy.study.discoverygatewayservice.domain;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@Profile("test")
@RestController
@RequestMapping("/second-service")
public class SecondController {

  @GetMapping("welcome")
  public String welcome() {
    return "Good luck second me.";
  }

  @GetMapping("message")
  public String message(@RequestHeader(value = "second-request", required = false) String header) {
    log.info("header: {}", header);
    return "hello luck second me.";
  }

  @GetMapping("check")
  public String check() {
    return "checking second service";
  }
}
