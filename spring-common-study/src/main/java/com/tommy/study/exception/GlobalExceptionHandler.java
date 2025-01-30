package com.tommy.study.exception;

import com.tommy.study.exception.dto.ApplicationExceptionDto;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private final MessageSource messageSource;

  public GlobalExceptionHandler(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler({ApplicationException.class})
  protected ResponseEntity handleApplicationException(ApplicationException ex) {
    var exceptionMessage =
        messageSource.getMessage(
            ex.getApplicationExceptionCode().getMessage(), null, LocaleContextHolder.getLocale());

    return new ResponseEntity(
        ApplicationExceptionDto.builder()
            .message(exceptionMessage)
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
