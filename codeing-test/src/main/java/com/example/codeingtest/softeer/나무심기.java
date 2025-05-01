package com.example.codeingtest.softeer;


import java.util.*;
import java.util.stream.Collectors; // 외워

class ConferenceSchedule {

  public String conference;
  public int start;
  public int end;

  public ConferenceSchedule(String conference, int start, int end) {
    this.conference = conference;
    this.start = start;
    this.end = end;
  }

  public String getConference() {
    return this.conference;
  }

  public int getStart() {
    return this.start;
  }

  public int getEnd() {
    return this.end;
  }
}

public class 나무심기 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Set<String> conference = new TreeSet<>(); // 외워
    List<ConferenceSchedule> schedules = new ArrayList(); // 외워

    String[] items = sc.nextLine().split(" ");
    int conferneceCount = Integer.parseInt(items[0]);
    int scheduleCount = Integer.parseInt(items[1]);

    for (int i = 0; i < conferneceCount; i++) {
      conference.add(sc.nextLine()); // 외워
    }

    for (int i = 0; i < scheduleCount; i++) {
      String[] information = sc.nextLine().split(" ");
      schedules.add(new ConferenceSchedule(information[0], Integer.parseInt(information[1]),
          Integer.parseInt(information[2])));
    }

    int index = 0;
    for (String currentConference : conference) {

      if (index++ != 0) {
        System.out.println("-----");
      }

      List<ConferenceSchedule> allSchedules = schedules.stream()
          .filter(s -> s.getConference().equals(currentConference))
          .sorted(Comparator.comparing(ConferenceSchedule::getStart)) // 외워
          .collect(Collectors.toList());

      List<ConferenceSchedule> availables = new ArrayList<>();
      System.out.println("Room " + currentConference + ":");
      int lastTime = 9;
      for (ConferenceSchedule used : allSchedules) {
        if (used.getStart() != lastTime) {
          availables.add(new ConferenceSchedule(currentConference, lastTime, used.getStart()));
        }
        lastTime = used.getEnd();
      }
      if (lastTime < 18) {
        availables.add(new ConferenceSchedule(currentConference, lastTime, 18));
      }

      if (availables.size() == 0) {
        System.out.println("Not available");
      } else {
        System.out.println(availables.size() + " available:");
        availables.forEach(
            s -> {
              System.out.println(String.format("%02d-%02d", s.getStart(), s.getEnd())); // 외워
            }
        );
      }

    }

  }
}
