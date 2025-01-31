package com.tommy.study.domain.schema.entity.common;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.tommy.study.domain.schema.dto.StandardSchemaCreateAble;
import com.tommy.study.domain.schema.entity.StandardSchemaEvent;
import com.tommy.study.domain.schema.entity.StandardSchemaInterval;
import com.tommy.study.domain.schema.entity.StandardSchemaStopwatch;
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
  @JsonSubTypes.Type(value = StandardSchemaStopwatch.class, name = "stopwatch"),
  @JsonSubTypes.Type(value = StandardSchemaInterval.class, name = "interval"),
  @JsonSubTypes.Type(value = StandardSchemaEvent.class, name = "event"),
})
public abstract class StandardSchema implements StandardSchemaCreateAble {

  protected String domainId;
  protected String projectId;
  protected String productId;
  protected String resourceId;

  protected StandardSchema(String domainId, String projectId, String productId, String resourceId) {
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
