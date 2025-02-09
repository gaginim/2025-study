# 기능

- 처음에 포트를 6000 으로 했는데 unsafe 포트라고 안되네^^.. 참고
- GlobalFilter -> Customer Filter -> Logger Filter
    - GlobalFilter.pre -> CustomFilter.pre -> LoggerFilter.pre -> LoggerFilter.post -> CustomFilter.post ->
      GlobalFilter.post