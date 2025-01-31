package com.tommy.study.domain.nonSchema.service;

import com.tommy.study.domain.nonSchema.dto.ConverterRepositoryReadAble;
import com.tommy.study.domain.nonSchema.service.standardRepos.AbstractNonStandardSchemaRepositoryBean;
import com.tommy.study.domain.schema.entity.common.StandardSchema;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DefaultConverterService {

  private final NonStandardSchemaRepositorySelector nonStandardSchemaRepositorySelector;

  public DefaultConverterService(
      NonStandardSchemaRepositorySelector nonStandardSchemaRepositorySelector) {
    this.nonStandardSchemaRepositorySelector = nonStandardSchemaRepositorySelector;
  }

  // todo: 테스트 만들어서 잘 되는지 확인 필요
  public List<StandardSchema> getStandardSchemas(
      ConverterRepositoryReadAble converterRepositoryReadAble) {
    return Optional.ofNullable(
            nonStandardSchemaRepositorySelector.selector(converterRepositoryReadAble))
        .map(s -> (AbstractNonStandardSchemaRepositoryBean) s)
        .map(s -> s.getStandardSchema(converterRepositoryReadAble))
        .orElseThrow(() -> ApplicationException.of(ApplicationExceptionCode.BAD_REQUEST));
  }
}
