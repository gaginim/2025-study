package com.tommy.study.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApplicationExceptionCode {

  // common (1000~2000)

  // member & login (2001~3000)
  MEMBER_NOT_EXIST(HttpStatus.BAD_REQUEST, 2001, "there is no members"),
  MEMBER_WRONG_PASSWORD(HttpStatus.BAD_REQUEST, 2002, "wrong password");

  private final HttpStatus status;
  private final int code;
  private final String message;

  ApplicationExceptionCode(HttpStatus status, int code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
