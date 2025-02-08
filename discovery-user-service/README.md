# 기능

- 유레카 서비스

- 포트 달리해서 동일 서비스 띄우는 법
  VM Option 추가: -Dserver.port=9003

- command 로 다른 port 번호 줘서 실행하는법
  ./gradlew :discovery-user-service:clean :discovery-user-service:build :discovery-user-service:bootRun
  --args='--server.port=9004'