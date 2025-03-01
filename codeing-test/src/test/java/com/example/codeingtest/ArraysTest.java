package com.example.codeingtest;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArraysTest {

  @DisplayName("array 공부")
  @Test
  void test01() {

    int[] map = {1, 2, 3, 4, 5};

    var mapArr = Arrays.stream(map).boxed().toArray(Integer[]::new);
    Arrays.sort(mapArr, (prev, next) -> next - prev);

    for (var aa : mapArr) {
      System.out.println(aa);
    }
  }
}
