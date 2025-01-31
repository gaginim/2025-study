package com.tommy.study.aspect;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@Aspect
@RequiredArgsConstructor
public class LoggingAspect {

  @Around("execution(* com.tommy.study.domain.login.service.LoginService.getAccessAbleToken(..))")
  public Object logging(ProceedingJoinPoint pjp) throws Throwable {
    Object proceeds = pjp.proceed();
    try {
      String username = String.valueOf(pjp.getArgs()[0]);
      String password = String.valueOf(pjp.getArgs()[1]);
      log.info("username: {}, password: {}", username, password);

    } catch (Exception ex) {
      log.error("cannot logging login information: {}", ex.getMessage());
    }
    return proceeds;
  }
}
