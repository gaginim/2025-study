package com.tommy.study.config.custom_security;

import com.tommy.study.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.ObjectUtils;

@Log4j2
@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  // TODO: 권한별로 관리되도록 수정해야 함
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    try {
      var member = memberRepository.findByUserId(username).orElse(null);
      if (ObjectUtils.isEmpty(member))
        throw new IllegalArgumentException("there is no member information.");

      return User.builder().username(username).password(member.getPassword()).roles("USER").build();
    } catch (Exception ex) {
      log.error("detail exception => {}", ex.fillInStackTrace());
      return null;
    }
  }
}
