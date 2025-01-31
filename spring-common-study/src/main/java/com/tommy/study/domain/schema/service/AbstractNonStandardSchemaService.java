package com.tommy.study.domain.schema.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy.study.domain.schema.dto.NonStandardSchemaDto;
import com.tommy.study.domain.schema.entity.NonStandardSchemaEvent;
import com.tommy.study.domain.schema.entity.NonStandardSchemaInterval;
import com.tommy.study.domain.schema.entity.NonStandardSchemaStopwatch;
import com.tommy.study.domain.schema.entity.common.NonStandardSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractNonStandardSchemaService {

  protected final ObjectMapper objectMapper;

  protected NonStandardSchema convert(final String nonStandardSchemaJson)
      throws JsonProcessingException {
    return objectMapper.readValue(nonStandardSchemaJson, NonStandardSchema.class);
  }

  protected String getNonStandardSchema(final NonStandardSchemaDto.Request request)
      throws JsonProcessingException {
    var nonStandardSchema = getStandardSchema(request);
    return objectMapper.writeValueAsString(nonStandardSchema);
  }

  // todo: 중복 코드가 많아서 개선 필요
  protected NonStandardSchema getStandardSchema(NonStandardSchemaDto.Request request) {
    return switch (request.getType()) {
      case EVENT ->
          NonStandardSchemaEvent.builder()
              .domainId(request.getDomainId())
              .projectId(request.getProjectId())
              .productId(request.getProductId())
              .resourceId(request.getResourceId())
              .build();
      case INTERVAL ->
          NonStandardSchemaInterval.builder()
              .domainId(request.getDomainId())
              .projectId(request.getProjectId())
              .productId(request.getProductId())
              .resourceId(request.getResourceId())
              .build();
      case STOPWATCH ->
          NonStandardSchemaStopwatch.builder()
              .domainId(request.getDomainId())
              .projectId(request.getProjectId())
              .productId(request.getProductId())
              .resourceId(request.getResourceId())
              .build();
    };
  }
}
