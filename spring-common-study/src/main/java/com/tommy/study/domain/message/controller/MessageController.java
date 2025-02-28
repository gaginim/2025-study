package com.tommy.study.domain.message.controller;

import com.tommy.study.domain.message.dto.MessageDto;
import com.tommy.study.domain.message.service.MessagePublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Log4j2
public class MessageController {

  private final MessagePublisherService messagePublisherService;

  @GetMapping("{message}")
  public String getMessage(@PathVariable(value = "message") String message) {
    return "hello " + message;
  }

  @GetMapping("{message}/real-time")
  public String getMessagePubSub(@RequestParam String channel, @RequestBody MessageDto message) {
    log.info("Redis Pub MSG Channel = {}", channel);
    messagePublisherService.publish(channel, message);
    return "OK";
  }
}
