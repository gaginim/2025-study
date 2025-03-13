package com.example.codeingtest.twopointer;

import java.util.*;

/*
 반드시 해야할 점: 소수점 만들기!!
 todo: 주말에 다시 풀기
*/
public class Main1644 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    boolean[] numbers = new boolean[num + 1];
    ArrayList<Integer> prime_numbers = new ArrayList<>();

    numbers[0] = numbers[1] = true;
    for (int i = 2; i * i <= num; i++) {
      if (!numbers[i]) for (int j = i * i; j <= num; j += i) numbers[j] = true;
    }
    for (int i = 1; i <= num; i++) {
      if (!numbers[i]) prime_numbers.add(i);
    }

    int result = 0;
    int start = 0;
    int end = 0;
    int temp = 0;

    while (true) {
      if (temp > num) {
        temp -= prime_numbers.get(start++);
      } else if (temp < num) {
        if (end == prime_numbers.size()) break;
        temp += prime_numbers.get(end++);
      } else {
        result++;
        temp -= prime_numbers.get(start++);
      }
    }

    System.out.println(result);
  }
}
