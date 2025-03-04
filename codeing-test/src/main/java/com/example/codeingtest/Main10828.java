package com.example.codeingtest;

import java.util.Scanner;
import java.util.Stack;

public class Main10828 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int commandCount = sc.nextInt();

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < commandCount; i++) {

      String command = sc.next();
      if ("push".equals(command)) {
        stack.add(sc.nextInt());
      } else if ("pop".equals(command)) {
        System.out.println(stack.isEmpty() ? -1 : stack.pop());
      } else if ("top".equals(command)) {
        System.out.println(stack.isEmpty() ? -1 : stack.peek());
      } else if ("size".equals(command)) {
        System.out.println(stack.size());
      } else if ("empty".equals(command)) {
        System.out.println(stack.isEmpty() ? 1 : 0);
      }
    }
  }
}
