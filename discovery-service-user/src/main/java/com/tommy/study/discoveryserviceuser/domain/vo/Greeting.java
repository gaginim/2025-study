package com.tommy.study.discoveryserviceuser.domain.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Greeting {
  @Value("${integration.greeting.message}")
  private String message;
}
