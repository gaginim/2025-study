package com.tommy.study.domain.schema.dto;

import com.tommy.study.domain.schema.enums.StandardSchemaType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class StandardSchemaDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Request {
    private StandardSchemaType type;
    private String domainId;
    private String projectId;
    private String productId;
    private String resourceId;
  }
}
