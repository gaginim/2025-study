package com.example.codeingtest.greedy;

import java.util.*;

class Conference {
  private int start;
  private int end;

  public Conference(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return this.start;
  }

  public int getEnd() {
    return this.end;
  }
}

/*
 todo: 다시 풀어보도록
*/
public class Main1931 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int conferenceSize = sc.nextInt();

    List<Conference> conferences = new ArrayList<>();

    for (int i = 0; i < conferenceSize; i++) {
      conferences.add(new Conference(sc.nextInt(), sc.nextInt()));
    }

    conferences.sort(Comparator.comparing(Conference::getEnd).thenComparing(Conference::getStart));

    int max = 0;
    int lastEndTime = 0;

    for (Conference conference : conferences) {
      if (conference.getStart() >= lastEndTime) {
        max++;
        lastEndTime = conference.getEnd();
      }
    }

    System.out.println(max);
  }
}
