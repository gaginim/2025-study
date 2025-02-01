package com.tommy.study.domain.member.repository;

import com.tommy.study.domain.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUserId(String userId);

}
