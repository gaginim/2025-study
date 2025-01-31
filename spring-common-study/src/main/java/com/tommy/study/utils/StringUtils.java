package com.tommy.study.utils;

import org.springframework.util.ObjectUtils;

public final class StringUtils {

  public static Boolean isNonBlank(String value) {
    return !ObjectUtils.isEmpty(value);
  }
}
