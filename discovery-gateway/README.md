# 기능

- 처음에 포트를 6000 으로 했는데 unsafe 포트라고 안되네^^.. 참고
- GlobalFilter 뒤에 Customer Filter 동작
    - GlobalFilter.pre -> CustomFilter.pre -> CustomFilter.post -> GlobalFilter.post