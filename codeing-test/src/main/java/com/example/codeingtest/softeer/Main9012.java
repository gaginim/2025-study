package com.example.codeingtest.softeer;

import java.util.Scanner;
import java.util.Stack;

/*
todo: 수정해야함
 */
public class Main9012 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();

    Stack<String> stack = new Stack<>();
    for (int i = 0; i < size; i++) {

      stack.clear();
      String[] arr = sc.next().split("");
      for (int j = 0; j < arr.length; j++) {
        if ("(".equals(arr[j])) {
          stack.push(arr[j]);
        } else if (")".equals(arr[j])) {
          if (!stack.isEmpty() && "(".equals(stack.peek())) {
            stack.pop();
          } else {
            System.out.println("NO");
            break;
          }
        }
      }
      if (stack.isEmpty()) System.out.println("YES");
    }
  }
}
