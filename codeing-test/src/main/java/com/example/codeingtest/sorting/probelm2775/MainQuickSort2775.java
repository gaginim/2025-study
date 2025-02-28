package com.example.codeingtest.sorting.probelm2775;

import java.util.Scanner;

public class MainQuickSort2775 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    var line = sc.nextInt();
    int[] map = new int[line];

    for (int i = 0; i < line; i++) {
      map[i] = sc.nextInt();
    }

    for (int i = 0; i < line; i++) {
      System.out.println(map[i]);
    }
  }

  public static void quickSort(int arr, int start, int end) {}
}
