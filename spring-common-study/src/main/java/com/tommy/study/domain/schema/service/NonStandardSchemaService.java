package com.tommy.study.domain.schema.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tommy.study.domain.schema.dto.NonStandardSchemaDto;
import com.tommy.study.domain.schema.entity.common.NonStandardSchema;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class NonStandardSchemaService extends AbstractNonStandardSchemaService {

  public NonStandardSchemaService(ObjectMapper objectMapper) {
    super(objectMapper);
  }

  public NonStandardSchema validNonStandardSchema(final NonStandardSchemaDto.Request request)
      throws JsonProcessingException {
    var nonStandardSchemaJson = getNonStandardSchema(request);
    if (ObjectUtils.isEmpty(nonStandardSchemaJson)) {
      throw new ApplicationException(ApplicationExceptionCode.BAD_REQUEST);
    }
    return convert(nonStandardSchemaJson);
  }
}
