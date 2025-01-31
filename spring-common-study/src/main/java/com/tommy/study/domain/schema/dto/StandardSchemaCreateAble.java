package com.tommy.study.domain.schema.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tommy.study.domain.schema.enums.StandardSchemaType;

public interface StandardSchemaCreateAble {

  String getDomainId();

  String getProjectId();

  String getProductId();

  String getResourceId();

  @JsonIgnore
  StandardSchemaType getStandardSchemaType();
}
