package com.tommy.study.domain.schema.dto;

import com.tommy.study.domain.schema.enums.NonStandardSchemaType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class NonStandardSchemaDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Request {
    private NonStandardSchemaType type;
    private String domainId;
    private String projectId;
    private String productId;
    private String resourceId;
  }
}
