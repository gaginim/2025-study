package com.tommy.study.redissample.domain;

import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
  private HashMap<String, String> sessionMap = new HashMap<>();

  @GetMapping("/login")
  public String login(HttpSession httpSession, @RequestParam String name) {
    sessionMap.put(httpSession.getId(), name);
    return "saved " + name;
  }

  @GetMapping("/myName")
  public String getMyName(HttpSession httpSession, @RequestParam String name) {
    return sessionMap.get(httpSession.getId());
  }
}
