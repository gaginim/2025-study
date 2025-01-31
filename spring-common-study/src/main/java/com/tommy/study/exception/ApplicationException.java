package com.tommy.study.exception;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {
  private final ApplicationExceptionCode applicationExceptionCode;

  public ApplicationException(ApplicationExceptionCode applicationExceptionCode) {
    this.applicationExceptionCode = applicationExceptionCode;
  }

  public static ApplicationException of(ApplicationExceptionCode applicationExceptionCode) {
    return new ApplicationException(applicationExceptionCode);
  }
}
