package com.tommy.study.domain.schema.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tommy.study.domain.schema.dto.NonStandardSchemaDto;
import com.tommy.study.domain.schema.entity.common.NonStandardSchema;
import com.tommy.study.domain.schema.service.NonStandardSchemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/non-schema")
@RequiredArgsConstructor
public class NonStandardSchemaController {
  private final NonStandardSchemaService nonStandardSchemaService;

  @PostMapping
  public NonStandardSchema valid(@RequestBody NonStandardSchemaDto.Request request)
      throws JsonProcessingException {
    return nonStandardSchemaService.validNonStandardSchema(request);
  }
}
