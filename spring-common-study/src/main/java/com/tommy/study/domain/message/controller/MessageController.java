package com.tommy.study.domain.message.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Log4j2
public class MessageController {

  @GetMapping("{message}")
  public String getMessage(@PathVariable(value = "message") String message) {
    return "hello " + message;
  }
}
