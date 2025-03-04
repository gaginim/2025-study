package com.tommy.study.redissample.domain;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @GetMapping("/login")
  public String login(HttpSession httpSession, @RequestParam String name) {
    httpSession.setAttribute("name", name);
    return "saved " + name;
  }

  @GetMapping("/myName")
  public String getMyName(HttpSession httpSession, @RequestParam String name) {
    return (String) httpSession.getAttribute("name");
  }
}
