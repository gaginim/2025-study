package com.example.codeingtest.softeer;

import java.util.*;

class Work {

  public int start;
  public int end;

  public Work(int s, int e) {
    this.start = s;
    this.end = e;
  }

  public int getStart() {
    return this.start;
  }

  public int getEnd() {
    return this.end;
  }
}

public class 강의실배정 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());

    List<Work> works = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] line = sc.nextLine().split(" ");
      works.add(new Work(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
    }

    // 종료 시간 기준 정렬 (종료 시간이 같으면 시작 시간 순으로)
    works.sort((a, b) -> {
      if (a.end == b.end) return a.start - b.start;
      return a.end - b.end;
    });


    int count = 0;
    int lastEnd = 0;

    for (Work w : works) {
      if (w.start >= lastEnd) {
        count++;
        lastEnd = w.end;
      }
    }

  }

}
