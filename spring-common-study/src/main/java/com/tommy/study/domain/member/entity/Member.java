package com.tommy.study.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Table("member")
public class Member {

  @Id private Long id;
  private String userId;
  private String password;

  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  protected LocalDateTime createdAt;

  @CreatedBy protected String createdBy;

  @Builder
  private Member(
      Long id, String userId, String password, LocalDateTime createdAt, String createdBy) {
    this.id = id;
    this.userId = userId;
    this.password = password;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
  }
}
