package com.tommy.study.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApplicationExceptionCode {

  // common (1000~2000)
  BAD_REQUEST(HttpStatus.BAD_REQUEST, 1000, "bad.request"),

  // member & login (2001~3000)
  MEMBER_NOT_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, 2001, "member.not.exist"),
  MEMBER_WRONG_PASSWORD(HttpStatus.INTERNAL_SERVER_ERROR, 2002, "member.wrong.password");

  private final HttpStatus status;
  private final int code;
  private final String message;

  ApplicationExceptionCode(HttpStatus status, int code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
