package com.example.codeingtest;

import java.util.*;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {

  @DisplayName("두개의 List 를 하나의 문자열로 만들기")
  @Test
  void test01_stream() {

    List<Integer> temp1 = List.of(1, 2, 3, 4, 5, 6);
    List<Integer> temp2 = List.of(7, 8, 9, 10, 11, 12);

    List<List<Integer>> arrTemps = List.of(temp1, temp2);

    var fullText =
        arrTemps.stream()
            .map(s -> s.stream().map(String::valueOf).collect(Collectors.joining(", ")))
            .collect(Collectors.joining(" | "));
    Assertions.assertEquals("1, 2, 3, 4, 5, 6 | 7, 8, 9, 10, 11, 12", fullText);
  }

  @DisplayName("List 의 값을 합치기")
  @Test
  void test02_sum() {
    List<Integer> temp1 = List.of(1, 2, 3, 4, 5);

    var result = temp1.stream().reduce(((integer, integer2) -> integer + integer2));
    System.out.println("result: " + result);
  }

  @DisplayName("문자열 사전 만들기")
  @Test
  void test03_disctionanry() {
    List<String> items = List.of("tommy", "han", "hyungki", "kim", "kim");

    // 문자열의 앞글자로 사전 만들기. 중복 허용하지 않음
    Map<String, Set<String>> notDuplicatedDictionary =
        items.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toSet()));

    // 문자열의 앞글자로 사전 만들기. 중복허용
    Map<String, List<String>> duplicatedDictionary =
        items.stream().collect(Collectors.groupingBy(s -> s.substring(0, 1)));

    // 문자열의 앞글자로 사전 만들기. 앞글자를 오름차순으로
    var ascNotDuplicatedDictionary =
        items.stream()
            .collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.toSet()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, TreeMap::new));

    // 문자열의 앞글자로 사전 만들기. 내림차순으로
    var descNotDuplicatedDictionary =
        items.stream()
            .collect(Collectors.groupingBy(it -> it.substring(0, 1), Collectors.toSet()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

  @DisplayName(
      "이 리스트에서 첫 번째 글자를 기준으로 **그룹화(grouping)**하고, 각 그룹 내에서 길이가 5 이상인 단어만 남기고, 그룹을 내림차순으로 정렬한 뒤, 각 그룹 내 단어를 대문자로 변환하여 출력하세요.")
  @Test
  void test04() {
    List<String> items =
        List.of("apple", "banana", "cherry", "date", "avocado", "blueberry", "carrot");

    var result =
        items.stream()
            .filter(s -> s.length() >= 5)
            .collect(Collectors.groupingBy(s -> s.substring(0, 1)))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    s -> s.getValue().stream().map(m -> m.toUpperCase()).toList(),
                    (e1, e2) -> e1,
                    LinkedHashMap::new));
  }
}
