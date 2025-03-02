package com.example.codeingtest.sorting.problem11399;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1181 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    String[] input = new String[size];

    for (int i = 0; i < size; i++) {
      input[i] = sc.next();
    }

    Arrays.stream(input)
        .distinct()
        .sorted(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder()))
        .forEach(System.out::println);
  }
}
