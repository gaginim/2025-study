package com.tommy.study.domain.schema.entity;

import com.tommy.study.domain.schema.entity.common.StandardSchema;
import com.tommy.study.domain.schema.enums.StandardSchemaType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StandardSchemaEvent extends StandardSchema {

  @Builder
  protected StandardSchemaEvent(
      String domainId, String projectId, String productId, String resourceId) {
    super(domainId, projectId, productId, resourceId);
  }

  @Override
  public StandardSchemaType getStandardSchemaType() {
    return StandardSchemaType.EVENT;
  }
}
