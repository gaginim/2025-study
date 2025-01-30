package com.tommy.study.domain.login.dto;

import lombok.Builder;
import lombok.Getter;

public abstract class LoginDto {

  @Builder
  @Getter
  public static class Request {
    private String username;
    private String password;
  }


}
