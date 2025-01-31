package com.tommy.study.domain.login.controller;

import com.tommy.study.domain.login.dto.LoginDto;
import com.tommy.study.domain.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

  private final LoginService loginService;

  @PostMapping("/login")
  public String login(@RequestBody LoginDto.Request request) {
    return loginService.getAccessAbleToken(request.getUsername(), request.getPassword());
  }
}
