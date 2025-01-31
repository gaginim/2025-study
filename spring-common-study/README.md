# 적용내용

1. jdbc mysql 연동
2. security + jwt
3. 다국어 추가
4. log4j2
5. vault 추가 (dev 환경에서 실행 가능)
6. aop 추가
7. jsonType 추가

# vault 적용 사전작업

1. vault 설치: brew install vault
2. vault 서버 시작: vault server --dev --dev-root-token-id="00000000-0000-0000-0000-000000000000"
3. vault 의 kv 추가: vault kv put secret/application mysql.username=tommy mysql.password=1234