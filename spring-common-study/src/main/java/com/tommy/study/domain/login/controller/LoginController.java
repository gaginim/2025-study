package com.tommy.study.domain.login.controller;

import com.tommy.study.config.custom_security.JwtUtil;
import com.tommy.study.domain.login.dto.LoginDto;
import com.tommy.study.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;
  private final MemberRepository memberRepository;
  private final JwtUtil jwtUtil;

  @PostMapping("/login")
  public String login(@RequestBody LoginDto.Request request) {

    var member = memberRepository.findByUserId(request.getUsername()).orElse(null);
    if (ObjectUtils.isEmpty(member))
      throw new IllegalArgumentException("there is no member information.");

    if (!passwordEncoder.matches(request.getPassword(), member.getPassword()))
      throw new IllegalArgumentException("wrong password");

    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
    return jwtUtil.generateToken(userDetails);
  }
}
