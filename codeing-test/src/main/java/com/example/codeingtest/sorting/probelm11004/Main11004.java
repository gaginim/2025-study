package com.example.codeingtest.sorting.probelm11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/*
  랜덤으로 pivot 을 바꾸고 작업하는 방법
*/
public class Main11004 {

  private static final Random random = new Random();

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int mapSize = Integer.parseInt(st.nextToken());
    int index = Integer.parseInt(st.nextToken());
    int[] map = new int[mapSize];

    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < mapSize; i++) {
      map[i] = Integer.parseInt(st.nextToken());
    }

    quickSort(map, 0, map.length - 1, index - 1);

    System.out.println(map[index - 1]);
  }

  public static void quickSort(int[] arr, int start, int end, int index) {

    if (start >= end) return;

    int pivotIndex = start + random.nextInt(end - start + 1);
    swap(arr, pivotIndex, end); // 피벗을 끝으로 이동

    int pivot = arr[end];
    int left = start;

    for (int i = start; i < end; i++) {
      if (arr[i] <= pivot) {
        swap(arr, left, i);
        left++;
      }
    }

    swap(arr, left, end);

    if (left == index) return;
    else if (left > index) quickSort(arr, start, left - 1, index);
    else quickSort(arr, left + 1, end, index);
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
