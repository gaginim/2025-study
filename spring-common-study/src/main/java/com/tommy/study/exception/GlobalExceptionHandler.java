package com.tommy.study.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({ApplicationException.class})
  protected ResponseEntity handleApplicationException(ApplicationException ex) {
    return new ResponseEntity(
        ApplicationExceptionDto.builder()
            .message(ex.getApplicationExceptionCode().getMessage())
            .code(ex.getApplicationExceptionCode().getCode())
            .statusCode(ex.getApplicationExceptionCode().getStatus().value())
            .build(),
        ex.getApplicationExceptionCode().getStatus());
  }

  @ExceptionHandler({RuntimeException.class})
  protected ResponseEntity handleServerException(RuntimeException ex) {
    return new ResponseEntity(
        ApplicationExceptionDto.builder()
            .message(ex.getMessage())
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .build(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({Exception.class})
  protected ResponseEntity handleServerException(Exception ex) {
    return new ResponseEntity(
        ApplicationExceptionDto.builder()
            .message(ex.getMessage())
            .code(HttpStatus.BAD_REQUEST.value())
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .build(),
        HttpStatus.BAD_REQUEST);
  }
}
