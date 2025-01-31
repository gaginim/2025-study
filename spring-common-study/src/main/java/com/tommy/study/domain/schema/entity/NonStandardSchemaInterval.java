package com.tommy.study.domain.schema.entity;

import com.tommy.study.domain.schema.entity.common.NonStandardSchema;
import com.tommy.study.domain.schema.enums.NonStandardSchemaType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class NonStandardSchemaInterval extends NonStandardSchema {

  @Builder
  protected NonStandardSchemaInterval(
      String domainId, String projectId, String productId, String resourceId) {
    super(domainId, projectId, productId, resourceId);
  }

  @Override
  public NonStandardSchemaType getNonStandardSchemaType() {
    return NonStandardSchemaType.INTERVAL;
  }
}
