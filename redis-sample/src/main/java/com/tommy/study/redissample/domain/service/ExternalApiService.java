package com.tommy.study.redissample.domain.service;

import com.tommy.study.redissample.domain.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiService {

  private final List<User> users =
      List.of(new User("A", "tommy", 11), new User("B", "hyungki", 12));

  public String gerUserName(String userId) throws InterruptedException {

    // 외부 서비스나 db 호출
    Thread.sleep(500);

    return users.stream()
        .filter(s -> s.getId().equals(userId))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("there is no data"))
        .getName();
  }

  public int getUserAge(String userId) throws InterruptedException {

    // 외부 서비스나 db 호출
    Thread.sleep(500);

    return users.stream()
        .filter(s -> s.getId().equals(userId))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("there is no data"))
        .getAge();
  }
}
