# 기능

- integration 으로 custom value 사용하는법
  Value annotation 사용해도 되는데 configuration Prpoerties 사용
    1. org.springframework.boot:spring-boot-configuration-processor 넣어줌
    2. ConfigurationPropertiesScan 을 해서 properties 가 있는 package 를 읽음
    3. ConfigurationProperties 사용