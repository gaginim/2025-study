package com.example.codeingtest.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class Main2470 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    int[] map = new int[size];

    for (int i = 0; i < size; i++) {
      map[i] = sc.nextInt();
    }
    Arrays.sort(map);

    int min = Integer.MAX_VALUE;
    int left = 0;
    int right = map.length - 1;

    int[] result = new int[2];
    while (left < right) {
      int sum = map[left] + map[right];
      int sumAbs = Math.abs(sum);

      if (sumAbs < min) {
        min = sumAbs;
        result[0] = map[left];
        result[1] = map[right];
      }

      if (sum > 0) {
        right--;
      } else {
        left++;
      }
    }

    System.out.println(result[0] + " " + result[1]);
  }
}
