package com.example.codeingtest.softeer;

import java.util.*;

public class 우물안개구리 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int memberCount = sc.nextInt();
    int relationCount = sc.nextInt();

    int[] weights = new int[memberCount];
    for (int i = 0; i < memberCount; i++) {
      weights[i] = sc.nextInt();
    }

    Map<Integer, List<Integer>> relations = new HashMap<>();
    for(int i = 0 ; i < memberCount ; i++) {
      relations.put(i, new ArrayList<>());
    }

    for(int i = 0; i < relationCount; i++) {
      int one = sc.nextInt() - 1;
      int two = sc.nextInt() - 1;

      relations.get(one).add(two);
      relations.get(two).add(one);
    }

    int result = 0;
    for(int i = 0 ; i < memberCount; i++) {
      List<Integer> friends = relations.get(i);
      if (friends.isEmpty()) {
        result++;
      } else {
        boolean isStrong = true;
        for(int friend : friends) {
          if (weights[friend] >= weights[i]) {
            isStrong = false;
            break;
          }
        }
        if (isStrong) result++;
      }
    }
    System.out.println(result);
  }
}
