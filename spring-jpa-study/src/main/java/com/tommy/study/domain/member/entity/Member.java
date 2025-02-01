package com.tommy.study.domain.member.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@NoArgsConstructor
@Builder
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String userId;

  private String password;

  @CreatedDate
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  @CreatedBy private String createdBy;

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
