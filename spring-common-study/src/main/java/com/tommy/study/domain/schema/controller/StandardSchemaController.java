package com.tommy.study.domain.schema.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tommy.study.domain.schema.dto.StandardSchemaDto;
import com.tommy.study.domain.schema.entity.common.StandardSchema;
import com.tommy.study.domain.schema.service.StandardSchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/non-schema")
@RequiredArgsConstructor
public class StandardSchemaController {
  private final StandardSchemaService standardSchemaService;

  @PostMapping
  public StandardSchema valid(@RequestBody StandardSchemaDto.Request request)
      throws JsonProcessingException {
    return standardSchemaService.validStandardSchema(request);
  }
}
