package com.example.codeingtest.sorting.probelm2775;

import java.util.Scanner;

/*
 1. 퀵정렬을 했으나 메모리 초과 발생
*/
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

    //    int[] map = {8, 3, 5, 533, 67, 6, 89, 32};
    //    int line = map.length;
    quickSort(map, 0, line);
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (Math.abs(end - start) <= 1) return;

    int pivot = arr[end - 1];
    int[] orderMap = new int[arr.length];
    boolean[] visited = new boolean[arr.length];

    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < pivot) {
        orderMap[index++] = arr[i];
        visited[i] = true;
      }
    }

    int firstBiggerPivot = -1;
    for (int i = start; i < arr.length; i++) {
      if (!visited[i]) {
        if (firstBiggerPivot == -1) firstBiggerPivot = index;
        orderMap[index++] = arr[i];
      }
    }

    int changeItem = orderMap[firstBiggerPivot];
    orderMap[firstBiggerPivot] = pivot;
    orderMap[end - 1] = changeItem;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = orderMap[i];
    }

    quickSort(arr, 0, firstBiggerPivot);
    quickSort(arr, firstBiggerPivot + 1, end);
  }
}
