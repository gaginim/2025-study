package com.tommy.study.domain.schema.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy.study.domain.schema.dto.StandardSchemaDto;
import com.tommy.study.domain.schema.entity.StandardSchemaEvent;
import com.tommy.study.domain.schema.entity.StandardSchemaInterval;
import com.tommy.study.domain.schema.entity.StandardSchemaStopwatch;
import com.tommy.study.domain.schema.entity.common.StandardSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class AbstractStandardSchemaService {

  protected final ObjectMapper objectMapper;

  protected StandardSchema convert(final String standardSchemaJson) throws JsonProcessingException {
    return objectMapper.readValue(standardSchemaJson, StandardSchema.class);
  }

  // todo: 중복 코드가 많아서 개선 필요
  protected StandardSchema getStandardSchema(StandardSchemaDto.Request request) {
    return switch (request.getType()) {
      case EVENT ->
          StandardSchemaEvent.builder()
              .domainId(request.getDomainId())
              .projectId(request.getProjectId())
              .productId(request.getProductId())
              .resourceId(request.getResourceId())
              .build();
      case INTERVAL ->
          StandardSchemaInterval.builder()
              .domainId(request.getDomainId())
              .projectId(request.getProjectId())
              .productId(request.getProductId())
              .resourceId(request.getResourceId())
              .build();
      case STOPWATCH ->
          StandardSchemaStopwatch.builder()
              .domainId(request.getDomainId())
              .projectId(request.getProjectId())
              .productId(request.getProductId())
              .resourceId(request.getResourceId())
              .build();
    };
  }
}
