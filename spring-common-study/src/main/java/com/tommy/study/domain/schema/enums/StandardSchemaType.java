package com.tommy.study.domain.schema.enums;

import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import java.util.Arrays;

public enum StandardSchemaType {
  EVENT,
  INTERVAL,
  STOPWATCH;

  public static StandardSchemaType of(String name) {
    return Arrays.stream(StandardSchemaType.values())
        .filter(s -> name.equals(s.name()))
        .findFirst()
        .orElseThrow(() -> ApplicationException.of(ApplicationExceptionCode.BAD_REQUEST));
  }
}
