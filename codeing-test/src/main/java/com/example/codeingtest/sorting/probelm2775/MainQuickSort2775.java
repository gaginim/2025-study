package com.example.codeingtest.sorting.probelm2775;

import java.util.Arrays;

/*
 1. 퀵정렬을 했으나 메모리 초과 발생
*/
public class MainQuickSort2775 {

  public static void main(String[] args) {

    int[] map = {8, 3, 5, 533, 67, 6, 89, 32};
    int line = map.length;
    quickSort(map, 0, line - 1);

    System.out.println(Arrays.toString(map));
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (start >= end) return;

    int pivot = arr[end];
    int left = start;
    int right = end - 1;

    while (left <= right) {
      while (left <= right && arr[left] < pivot) left++;
      while (left <= right && arr[right] >= pivot) right--;

      if (left < right) {
        swap(arr, left, right);
      }
    }

    swap(arr, right + 1, end);

    quickSort(arr, start, left - 1);
    quickSort(arr, left + 1, end);
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
