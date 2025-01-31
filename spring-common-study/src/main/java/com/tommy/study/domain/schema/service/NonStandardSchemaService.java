package com.tommy.study.domain.schema.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy.study.domain.schema.dto.NonStandardSchemaDto;
import com.tommy.study.domain.schema.entity.NonStandardSchemaEvent;
import com.tommy.study.domain.schema.entity.NonStandardSchemaInterval;
import com.tommy.study.domain.schema.entity.NonStandardSchemaStopwatch;
import com.tommy.study.domain.schema.entity.common.NonStandardSchema;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class NonStandardSchemaService {

  private final ObjectMapper objectMapper;

  public NonStandardSchema validNonStandardSchema(final NonStandardSchemaDto.Request request)
      throws JsonProcessingException {
    var nonStandardSchemaJson = getNonStandardSchema(request);
    if (ObjectUtils.isEmpty(nonStandardSchemaJson)) {
      throw new ApplicationException(ApplicationExceptionCode.BAD_REQUEST);
    }
    return convertNonStandardSchema(nonStandardSchemaJson);
  }

  private String getNonStandardSchema(final NonStandardSchemaDto.Request request)
      throws JsonProcessingException {
    var nonStandardSchema = getStandardSchema(request);
    return objectMapper.writeValueAsString(nonStandardSchema);
  }

  private NonStandardSchema convertNonStandardSchema(final String nonStandardSchemaJson)
      throws JsonProcessingException {
    var nonStandardSchema = objectMapper.readValue(nonStandardSchemaJson, NonStandardSchema.class);
    if (nonStandardSchema instanceof NonStandardSchemaStopwatch nonStandardSchemaStopwatch) {
      return nonStandardSchemaStopwatch;
    } else if (nonStandardSchema instanceof NonStandardSchemaInterval nonStandardSchemaInterval) {
      return nonStandardSchemaInterval;
    } else if (nonStandardSchema instanceof NonStandardSchemaEvent nonStandardSchemaEvent) {
      return nonStandardSchemaEvent;
    } else return null;
  }

  private NonStandardSchema getStandardSchema(NonStandardSchemaDto.Request request) {
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
