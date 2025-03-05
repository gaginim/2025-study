package com.tommy.study.redissample.domain.service;

import com.tommy.study.redissample.domain.dto.UserProfile;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final String REDIS_USERID = "nameKey::";

  @Autowired private ExternalApiService externalApiService;
  @Autowired private StringRedisTemplate redisTemplate;

  public UserProfile getUser(String userId) throws InterruptedException {

    var username = redisTemplate.opsForValue().get(REDIS_USERID + userId);
    if (username == null) {
      username = externalApiService.gerUserName(userId);
      redisTemplate.opsForValue().set(REDIS_USERID + userId, username, 5, TimeUnit.MINUTES);
    }
    int age = externalApiService.getUserAge(userId);
    return new UserProfile(username, age);
  }
}
