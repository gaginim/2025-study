package com.example.codeingtest.sorting.problem11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main11399 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    int[] input = new int[size];

    for (int i = 0; i < size; i++) {
      input[i] = sc.nextInt();
    }

    Arrays.sort(input);

    int sum = 0;
    int eachsum = 0;
    for (int i = 0; i < input.length; i++) {
      sum = sum + eachsum + input[i];
      eachsum = eachsum + input[i];
    }

    System.out.println(sum);
  }
}
