package com.tommy.study.domain.login.controller;

import com.tommy.study.config.custom_security.JwtUtil;
import com.tommy.study.domain.login.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtUtil;
  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  @GetMapping("/generate/{password}")
  public String generatePasswordEncoder(@PathVariable(value = "password") String password) {
    return passwordEncoder.encode(password);
  }

  @PostMapping("/login")
  public String login(@RequestBody LoginDto.Request request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
    var token =  jwtUtil.generateToken(userDetails);
    return token;
  }
}
