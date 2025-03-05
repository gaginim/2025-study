package com.tommy.study.redissample.domain.controller;

import com.tommy.study.redissample.domain.dto.UserProfile;
import com.tommy.study.redissample.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping("/{userId}/profile")
  public UserProfile getUser(@PathVariable(name = "userId") String userId)
      throws InterruptedException {

    return userService.getUser(userId);
  }
}
