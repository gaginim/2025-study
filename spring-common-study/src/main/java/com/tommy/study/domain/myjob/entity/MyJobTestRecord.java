package com.tommy.study.domain.myjob.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Builder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Table("my_job_test")
public record MyJobTestRecord(
    @CreatedDate @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdAt,
    @CreatedBy String createdBy,
    @Id Long id,
    String name) {

  public MyJobTestRecord changeName(String name) {
    return new MyJobTestRecord(this.createdAt, this.createdBy, this.id, name);
  }
}
