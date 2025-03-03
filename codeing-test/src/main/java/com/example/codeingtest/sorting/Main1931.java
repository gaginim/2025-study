package com.example.codeingtest.sorting;

import java.util.*;
import java.util.stream.Collectors;

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

public class Main1931 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int conferenceSize = sc.nextInt();

    List<Conference> conferences = new ArrayList<>();

    for (int i = 0; i < conferenceSize; i++) {
      conferences.add(new Conference(sc.nextInt(), sc.nextInt()));
    }

    conferences.sort(Comparator.comparing(Conference::getStart).thenComparing(Conference::getEnd));

    int max = 0;
    for (int i = 0; i < conferences.size(); i++) {

      int result = nextConference(conferences, conferences.get(i), 1);
      if (max < result) {
        max = result;
      }
    }

    System.out.println(max);
  }

  public static int nextConference(List<Conference> conferences, Conference conference, int route) {

    List<Conference> nexConferences =
        conferences.stream()
            .filter(s -> s.getStart() > conference.getEnd())
            .collect(Collectors.toList());
    if (nexConferences.isEmpty()) return route;

    int maxRoute = route;
    for (Conference next : nexConferences) {
      int result = nextConference(conferences, next, route + 1);
      maxRoute = Math.max(maxRoute, result);
    }

    return maxRoute;
  }
}
