package com.example.codeingtest.sorting.probelm2775;

import java.util.Scanner;

/*
 문제 푸는 과정:
   - 1번째: 삽입정렬로 품. 그런데 for 문을 두번써서 시간복잡도가 O(n*n) 이됨.
   - 2번째: Stream 으로 사용
*/
public class MainInsertSort2775 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    var line = sc.nextInt();
    int[] map = new int[line];

    for (int i = 0; i < line; i++) {
      map[i] = sc.nextInt();
    }

    // 2번 Stream 으로 쓰는법. 그런데 속도이슈가 있어서 추천하지 않음
    //    Arrays.stream(map).sorted().forEach(System.out::println);

    // 1번
    for (int i = 1; i < line; i++) {
      for (int j = 0; j <= i; j++) {
        int compareOne = map[i];
        int pivotOne = map[j];
        if (pivotOne > compareOne) {
          map[j] = compareOne;
          map[i] = pivotOne;
        }

        // 여기서 break 문 있으면 안됨
      }
    }

    for (int i = 0; i < line; i++) {
      System.out.println(map[i]);
    }
  }
}
