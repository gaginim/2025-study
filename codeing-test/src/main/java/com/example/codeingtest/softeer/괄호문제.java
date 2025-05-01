package com.example.codeingtest.softeer;

import java.util.*;

public class 괄호문제 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String[] aa = sc.nextLine().split(" ");
    int count = Integer.parseInt(aa[0]);
    int discount = Integer.parseInt(aa[1]);

    String[] items = sc.nextLine().split("");
    int[] visited = new int[count];

    int result = 0;
    for(int i = 0 ; i < items.length; i++) {
      int start = i - discount;
      int end = i + discount;

      while(start <= end) {
        if (start >= 0 && start < items.length) {
          if (items[start].equals("H") && visited[start] != 1) {
            result++;
            visited[start] = 1;
            break;
          }
        }
        start++;
      }
    }
    System.out.println(result);
  }
}
