package com.tommy.study.domain.member;

import com.tommy.study.domain.member.entity.Member;
import com.tommy.study.domain.member.repository.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

  private final MemberJpaRepository memberJpaRepository;

  @PostMapping("/{userId}/info")
  public Member login(@PathVariable(value = "userId") String userId) {
    return memberJpaRepository.findByUserId(userId).orElse(null);
  }
}
