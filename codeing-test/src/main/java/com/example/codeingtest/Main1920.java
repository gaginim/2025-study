package com.example.codeingtest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/*
 todo: 다시 풀어보도록
*/
public class Main1920 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int firstSize = sc.nextInt();
    int[] first = new int[firstSize];

    for (int i = 0; i < firstSize; i++) {
      first[i] = sc.nextInt();
    }
    Set<Integer> firstList = Arrays.stream(first).distinct().boxed().collect(Collectors.toSet());

    int secondSize = sc.nextInt();
    int[] second = new int[secondSize];
    for (int i = 0; i < secondSize; i++) {
      second[i] = sc.nextInt();
    }

    int[] result = new int[secondSize];
    for (int i = 0; i < secondSize; i++) {
      result[i] = firstList.contains(second[i]) ? 1 : 0;
    }

    for (int i = 0; i < result.length; i++) {
      System.out.println(result[i]);
    }
  }
}
