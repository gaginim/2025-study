package com.tommy.study.domain.schema.entity.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tommy.study.domain.schema.dto.NonStandardSchemaCreateAble;
import com.tommy.study.domain.schema.entity.NonStandardSchemaEvent;
import com.tommy.study.domain.schema.entity.NonStandardSchemaInterval;
import com.tommy.study.domain.schema.entity.NonStandardSchemaStopwatch;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import com.tommy.study.utils.StringUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(value = NonStandardSchemaStopwatch.class, name = "stopwatch"),
  @JsonSubTypes.Type(value = NonStandardSchemaInterval.class, name = "interval"),
  @JsonSubTypes.Type(value = NonStandardSchemaEvent.class, name = "event"),
})
public abstract class NonStandardSchema implements NonStandardSchemaCreateAble {

  protected String domainId;
  protected String projectId;
  protected String productId;
  protected String resourceId;

  protected NonStandardSchema(
      String domainId, String projectId, String productId, String resourceId) {
    this.domainId = domainId;
    this.projectId = projectId;
    this.productId = productId;
    this.resourceId = resourceId;

    if (!isRequiredParamsValid()) {
      throw new ApplicationException(ApplicationExceptionCode.BAD_REQUEST);
    }
  }

  private Boolean isRequiredParamsValid() {
    return StringUtils.isNonBlank(domainId)
        && StringUtils.isNonBlank(domainId)
        && StringUtils.isNonBlank(domainId)
        && StringUtils.isNonBlank(domainId);
  }
}
