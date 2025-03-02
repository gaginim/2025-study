package com.example.codeingtest.sorting.probelm11004;

import java.util.Scanner;

// todo: 문제가 뭔지 찾아보자
public class Main11004 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int mapSize = sc.nextInt();
    int index = sc.nextInt();
    int[] map = new int[mapSize];

    for (int i = 0; i < mapSize; i++) {
      map[i] = sc.nextInt();
    }

    quickSort(map, 0, map.length - 1, index);

    System.out.println(map[index - 1]);
  }

  public static void quickSort(int[] arr, int start, int end, int index) {

    if (start >= end) return;

    int pivot = arr[end];
    int left = start;
    int right = end;

    while (left <= right) {
      if (left <= right && arr[left] < pivot) left++;
      if (left <= right && arr[right] >= pivot) right--;
      if (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
    }

    int temp = arr[left];
    arr[left] = pivot;
    arr[end] = temp;

    if (left == index) return;
    else if (left > index) quickSort(arr, start, left - 1, index);
    else quickSort(arr, left + 1, end, index);
  }
}
