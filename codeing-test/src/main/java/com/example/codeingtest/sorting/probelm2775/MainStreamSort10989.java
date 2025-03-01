package com.example.codeingtest.sorting.probelm2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainStreamSort10989 {

  public static void main(String[] args) throws IOException {

    // bufferReader 를 써야 더 빠름
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(br.readLine());
    int[] map = new int[size];

    for (int i = 0; i < size; i++) {
      map[i] = Integer.parseInt(br.readLine());
    }

    // forEach 에서 printout 을 하면 속도가 느림
    StringBuilder sb = new StringBuilder();
    Arrays.stream(map).sorted().forEach(x -> sb.append(x).append("\n"));

    System.out.println(sb.toString());

    /***
     * // 이런 방법도 있으나 boxed 를 하는 자체가 Integer 로 바꾸는거라서 속도 걸림
     * Arrays.stream(map).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::println);
     *
     * // Comparator 를 쓰려면 원시타입을 쓰면 안됨
     * var aa = Arrays.stream(map).boxed().toArray(Integer[]::new);
     * Arrays.sort(aa, Comparator.reverseOrder());
     ***/
  }
}
