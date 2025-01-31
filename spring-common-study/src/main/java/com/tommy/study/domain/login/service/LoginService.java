package com.tommy.study.domain.login.service;

import com.tommy.study.config.custom_security.JwtUtil;
import com.tommy.study.domain.member.repository.MemberRepository;
import com.tommy.study.exception.ApplicationException;
import com.tommy.study.exception.ApplicationExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@RequiredArgsConstructor
@Service
public class LoginService {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;
  private final MemberRepository memberRepository;
  private final JwtUtil jwtUtil;

  public String getAccessAbleToken(final String userId, final String password) {
    var member = memberRepository.findByUserId(userId).orElse(null);
    if (ObjectUtils.isEmpty(member))
      throw new ApplicationException(ApplicationExceptionCode.MEMBER_NOT_EXIST);

    if (!passwordEncoder.matches(password, member.getPassword()))
      throw new ApplicationException(ApplicationExceptionCode.MEMBER_WRONG_PASSWORD);

    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userId, password));
    final UserDetails userDetails = userDetailsService.loadUserByUsername(userId);
    return jwtUtil.generateToken(userDetails);
  }
}
