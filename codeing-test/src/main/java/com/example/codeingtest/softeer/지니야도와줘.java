package com.example.codeingtest.softeer;

import java.util.Scanner;

public class 지니야도와줘 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] map = new int[n];
    int[] visied = new int[m];
    for(int i = 0 ; i< n; i++) {
      map[i] = sc.nextInt();
    }

    for(int i = 0 ; i< n; i++) {
      System.out.println(map[i]);
    }
  }

}
