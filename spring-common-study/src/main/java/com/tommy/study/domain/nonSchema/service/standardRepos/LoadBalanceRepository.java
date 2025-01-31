package com.tommy.study.domain.nonSchema.service.standardRepos;

import com.tommy.study.domain.schema.entity.StandardSchemaStopwatch;
import com.tommy.study.domain.schema.entity.common.StandardSchema;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@Service
public class LoadBalanceRepository extends AbstractNonStandardSchemaRepositoryBean {

  public LoadBalanceRepository(JdbcClient jdbcClient) {
    super(jdbcClient);
  }

  @Override
  public String getRepositoryName() {
    return "loadBalanceRepository";
  }

  @Override
  protected String getQuery() {
    // language=SQL
    return """
            select domain_id, product_id, project_id, resource_id, date_id, hour_id
            from load_balance_worker
            where date_id = :dateId
            and hour_id = :hourId """;
  }

  @Override
  protected StandardSchema getStandardSchema(ResultSet rs) throws SQLException {
    return StandardSchemaStopwatch.builder()
        .domainId(rs.getString("domain_id"))
        .productId(rs.getString("product_id"))
        .projectId(rs.getString("project_id"))
        .resourceId(rs.getString("resource_id"))
        .build();
  }
}
