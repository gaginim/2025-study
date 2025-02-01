package com.tommy.study.domain.nonSchema.service.standardRepos;

import com.tommy.study.domain.nonSchema.dto.PartitionAble;
import com.tommy.study.domain.nonSchema.service.NonStandardSchemaRepositoryBean;
import com.tommy.study.domain.schema.entity.common.StandardSchema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.simple.JdbcClient;

public abstract class AbstractNonStandardSchemaRepositoryBean
    implements NonStandardSchemaRepositoryBean {

  private final JdbcClient jdbcClient;

  public AbstractNonStandardSchemaRepositoryBean(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  public List<StandardSchema> getStandardSchema(PartitionAble partitionAble) {
    return jdbcClient.sql(getQuery())
            .param("dateId", partitionAble.getDateId())
            .param("hourId", partitionAble.getHourId())
            .query((rs, __) -> getStandardSchema(rs))
            .list();
  }

  protected abstract String getQuery();

  protected abstract StandardSchema getStandardSchema(ResultSet rs) throws SQLException;
}
