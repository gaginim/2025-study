package com.tommy.study.domain.schema.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tommy.study.domain.schema.enums.NonStandardSchemaType;

public interface NonStandardSchemaCreateAble {

  String getDomainId();

  String getProjectId();

  String getProductId();

  String getResourceId();

  @JsonIgnore
  NonStandardSchemaType getNonStandardSchemaType();
}
