package com.tommy.study.domain.schema.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy.study.domain.schema.dto.StandardSchemaDto;
import com.tommy.study.domain.schema.entity.common.StandardSchema;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class StandardSchemaService extends AbstractStandardSchemaService {

  public StandardSchemaService(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  public StandardSchema validStandardSchema(final StandardSchemaDto.Request request)
      throws JsonProcessingException {
    var standardSchemaJson = getStandardSchemaJson(request);
    if (ObjectUtils.isEmpty(standardSchemaJson)) {
      throw new ApplicationException(ApplicationExceptionCode.BAD_REQUEST);
    }
    return convert(standardSchemaJson);
  }

  protected String getStandardSchemaJson(final StandardSchemaDto.Request request)
      throws JsonProcessingException {
    return objectMapper.writeValueAsString(getStandardSchema(request));
  }
}
