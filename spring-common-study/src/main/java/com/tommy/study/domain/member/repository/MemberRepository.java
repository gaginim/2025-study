package com.tommy.study.domain.member.repository;

import com.tommy.study.domain.member.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {

  Optional<Member> findByUserId(String userId);
}
