package com.example.codeingtest.sorting.probelm11004;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 추천하지 않은 방법
*/
public class Main11004Priority {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int mapSize = sc.nextInt();
    int index = sc.nextInt();
    int otherMap[] = new int[mapSize];

    PriorityQueue<Integer> map = new PriorityQueue<>();
    for (int i = 0; i < mapSize; i++) {
      map.offer(sc.nextInt());
    }

    int result = 0;
    int i = 0;
    while (i++ <= index - 1) {
      result = map.poll();
    }

    Arrays.sort(otherMap);

    System.out.println(result);
    System.out.println(otherMap[index]);
  }
}
