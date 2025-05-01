package com.example.codeingtest.softeer;

import java.util.*;

class Point {
  public int x;
  public int y;
  public int depth;

  public Point(int x, int y, int depth) {
    this.x = x;
    this.y = y;
    this.depth = depth;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getDepth() {
    return this.depth;
  }
}

public class 장애물인식프로그램 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String[] aa = sc.nextLine().split(" ");
    int x = Integer.parseInt(aa[0]);
    int y = Integer.parseInt(aa[1]);


    String[][] maps = new String[x][y];
    int[][] visitied = new int[x][y];
    int[][] rainTime = new int[x][y];
    int[] xDir = new int[] {-1,0,1,0};
    int[] yDir = new int[] {0,1,0,-1};

    Queue<Point> rains = new LinkedList<>();
    Point pivot = null;
    for (int i = 0; i < x; i++) {
      String[] line = sc.nextLine().split("");
      for (int j = 0; j < y; j++) {
        maps[i][j] = line[j];
        if (maps[i][j].equals("W")) {
          pivot = new Point(i, j, 0);
        } else if (maps[i][j].equals("*")) {
          rains.add(new Point(i, j, 0));
        }
      }
    }

    // 1. 비 확산 먼저 처리 (BFS)
    while (!rains.isEmpty()) {
      Point p = rains.poll();
      for (int d = 0; d < 4; d++) {
        int nx = p.getX() + xDir[d];
        int ny = p.getY() + yDir[d];

        if (nx < 0 || ny < 0 || nx >= x || ny >=  y) continue;
        if (maps[nx][ny].equals(".") || rainTime[nx][ny] <= p.getDepth() + 1) continue;

        rainTime[nx][ny] = p.getDepth() + 1;
        rains.offer(new Point(nx, ny, p.getDepth() + 1));
      }
    }

    boolean isSuccess = false;
    Queue<Point> queue = new LinkedList<>();
    queue.offer(pivot);
    visitied[pivot.getX()][pivot.getY()] = 1;

    int result = 0;
    while(!queue.isEmpty()) {
      Point current = queue.poll();
      if (maps[current.getX()][current.getY()].equals("H")) {
        isSuccess = true;
        result = current.getDepth();
        break;
      }

      for(int k = 0 ; k < 4; k++) {
        int tempX = current.getX() + xDir[k];
        int tempY = current.getY() + yDir[k];
        if (tempX >= 0 && tempX < x && tempY >= 0 && tempY < y && (maps[tempX][tempY].equals(".") || maps[tempX][tempY].equals("H")) && visitied[tempX][tempY] != 1
          && rainTime[tempX][tempY] <= current.getDepth()

        ) {
          queue.offer(new Point(tempX, tempY, current.getDepth() + 1));
          visitied[tempX][tempY] = 1;
        }
      }
    }

    System.out.println(isSuccess? result :"FAIL");
  }

}
