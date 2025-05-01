package com.example.codeingtest.softeer;

import java.util.*;

class NNPoint {

  public Integer first;
  public Integer second;

  public NNPoint(Integer first, Integer second) {
    this.first = first;
    this.second = second;
  }

  public Integer getFirst() {
    return this.first;
  }

  public Integer getSecond() {
    return this.second == null ? -1 : this.second;
  }

  public String getFullItem() {
    if (this.second == null) {
      return String.valueOf(this.first);
    } else {
      return String.format("%d.%d", this.first, this.second);
    }
  }
}

public class GPT숫자비교 {

  public static void main(String[] args) {

//    Scanner sc = new Scanner(System.in);
//    int n = Integer.parseInt(sc.nextLine());
    List<NNPoint> items = new ArrayList<>();
//
//    for (int i = 0; i < n; i++) {
//      String aa = sc.nextLine();
//      String[] temp = aa.split("\\.");
//      if (temp.length == 2) {
//        items.add(new NNPoint(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
//      } else {
//        items.add(new NNPoint(Integer.parseInt(temp[0]), null));
//      }
//    }

//    items.stream().sorted(Comparator.comparing(NNPoint::getFirst)
//        .thenComparing(NNPoint::getSecond)
//    ).forEach(v -> System.out.println(v.getFullItem()));

    items.add(new NNPoint(2,3));
    items.add(new NNPoint(3,4));
    items.add(new NNPoint(2,1));
    items.add(new NNPoint(2,2));
    items.add(new NNPoint(3,5));

    items.stream()
            .sorted((a, b) -> {
              int result = Integer.compare(a.getFirst(), b.getFirst());
              if (result != 0) {
                return result;
              } else {
                  int subResult = Integer.compare(a.getSecond(), b.getSecond());
                  return subResult;
              }
            })
        .forEach(v -> System.out.println(v.getFullItem()));


    Set<String> aa = new HashSet<>();
    aa.add("aa");
    aa.remove("bb");

    Map<String, List<String>> test = new HashMap<>();
    test.put("key1", List.of("value1", "value2"));
    test.put("aaa", List.of("value3"));
    test.put("key2", List.of("value4"));

    for (Map.Entry<String, List<String>> entry : test.entrySet()) {
      String key = entry.getKey();
      List<String> value = entry.getValue();
      System.out.println("키: " + key + ", 값: " + value);

      // 필요에 따라 key 또는 value를 사용하여 작업 수행
      if (key.equals("aaa")) {
        List<String> aaaList = test.get("aaa"); // 특정 키의 값에 접근 (이미 알고 있다면 루프 밖에서 처리 가능)
        System.out.println("값 (키 'aaa'): " + aaaList);
      }
    }

//    items.stream().sorted((a, b) -> {
//      int firstComparison = Integer.compare(a.getFirst(), b.getFirst());
//      if (firstComparison != 0) {
//        return firstComparison;
//      } else {
//        // getSecond가 null인 경우를 처리해야 합니다.
//        if (a.getSecond() == null && b.getSecond() == null) {
//          return 0;
//        } else if (a.getSecond() == null) {
//          return -1; // null은 non-null보다 작다고 가정 (원하는 정렬 방식에 따라 변경 가능)
//        } else if (b.getSecond() == null) {
//          return 1;  // non-null은 null보다 크다고 가정 (원하는 정렬 방식에 따라 변경 가능)
//        } else {
//          return Integer.compare(a.getSecond(), b.getSecond());
//        }
//      }
//    }).forEach(v -> System.out.println(v.getFullItem()));

  }
}

