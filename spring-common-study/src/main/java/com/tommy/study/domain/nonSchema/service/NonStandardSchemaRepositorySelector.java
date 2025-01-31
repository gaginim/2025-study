package com.tommy.study.domain.nonSchema.service;

import com.tommy.study.domain.nonSchema.dto.ConverterRepositoryReadAble;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NonStandardSchemaRepositorySelector {

  private final List<NonStandardSchemaRepositoryBean> nonStandardSchemaRepositoryBeans;

  public NonStandardSchemaRepositorySelector(
      List<NonStandardSchemaRepositoryBean> nonStandardSchemaRepositoryBeans) {
    this.nonStandardSchemaRepositoryBeans = nonStandardSchemaRepositoryBeans;
  }

  public NonStandardSchemaRepositoryBean selector(
      ConverterRepositoryReadAble converterRepositoryReadAble) {
    return nonStandardSchemaRepositoryBeans.stream()
        .filter(
            repo ->
                repo.getRepositoryName().equals(converterRepositoryReadAble.getRepositoryName()))
        .findFirst()
        .orElseThrow(() -> ApplicationException.of(ApplicationExceptionCode.BAD_REQUEST));
  }
}
