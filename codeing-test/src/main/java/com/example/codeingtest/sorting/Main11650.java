package com.example.codeingtest.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
}

public class Main11650 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int size = sc.nextInt();
    List<Point> map = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      map.add(new Point(sc.nextInt(), sc.nextInt()));
    }

    map.stream()
        .sorted(Comparator.comparing(Point::getX).thenComparing(Point::getY))
        .forEach(point -> System.out.println(point.getX() + " " + point.getY()));
  }
}
