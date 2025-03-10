package com.example.codeingtest.twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class Main1253 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    int[] map = new int[size];

    for (int i = 0; i < size; i++) {
      map[i] = sc.nextInt();
    }

    Arrays.sort(map);

    int result = 0;
    for (int i = 0; i < map.length; i++) {
      int goal = map[i];
      int left = 0;
      int right = map.length - 1;

      while (left < right) {
        if (left == i) {
          left++;
          continue;
        }
        if (right == i) {
          right--;
          continue;
        }

        if (map[left] + map[right] == goal) {
          result++;
          break;
        } else if (map[left] + map[right] > goal) {
          right--;
        } else {
          left++;
        }
      }
    }

    System.out.println(result);
  }
}
