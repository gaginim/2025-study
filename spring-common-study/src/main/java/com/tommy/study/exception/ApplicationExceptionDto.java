package com.tommy.study.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationExceptionDto {
  private int statusCode;
  private int code;
  private String message;

  @Builder
  public ApplicationExceptionDto(int statusCode, int code, String message) {
    this.statusCode = statusCode;
    this.code = code;
    this.message = message;
  }
}
