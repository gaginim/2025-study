package com.tommy.study.domain.member.controller;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tommy.study.domain.member.entity.Member;
import com.tommy.study.domain.member.entity.QMember;
import com.tommy.study.domain.member.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberJpaRepository memberJpaRepository;
  private final JPAQueryFactory jpaStudyQueryFactory;

  @PostMapping("/{userId}/info")
  public Member findMember(@PathVariable(value = "userId") String userId) {
    return memberJpaRepository.findByUserId(userId).orElse(null);
  }

  @PostMapping("/{userId}/querydsl-info")
  public Member findMemberQueryDsl(@PathVariable(value = "userId") String userId) {

    QMember qMember = QMember.member;
    return jpaStudyQueryFactory.selectFrom(qMember).where(qMember.userId.eq(userId)).fetchOne();
  }
}
