package com.example.codeingtest;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArraysTest {

  @DisplayName("array 공부")
  @Test
  void test01() {

    int[] map = {1, 2, 3, 4, 5};

    // integer array desc ordering
    // boxed() : IntegerStream -> Integer 로 변경
    // toArray() : array 로 변경
    var tmp = Arrays.stream(map).boxed().toArray(Integer[]::new);
    Arrays.sort(tmp, (a, b) -> b - a);

    // integer list
    var tmpList = Arrays.stream(tmp).toList();
  }
}
