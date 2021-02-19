package com.ssafy.step08.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_16234_G5_인구이동2 {
    static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(temp.nextToken());  // 땅의 크기
        int L = Integer.parseInt(temp.nextToken());  // L이상
        int R = Integer.parseInt(temp.nextToken());  // R이하의 값이면 인구이동

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
            }
        }

        int cnt = 0;

        // 모든 칸 순회
        // BFS 탐색 인접한 국가와 L~R 범위 내의 인구차
        while (true) {
            boolean change = false; // 인구이동 여부 체크

            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && search(i, j)) {
                        change = true;
                    }
                }
            }

            if (!change) break;
            cnt++;
        }

        System.out.println(cnt);

    }

    static boolean search(int i, int j) {
        List<Point> list = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        Point p = new Point(i, j);
        list.add(p);
        queue.add(p);
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            p = queue.poll();
            i = p.i;
            j = p.j;
            for (int k = 0; k < dirs.length; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if (isIn(x, y) && !visited[x][y] && diff(map[i][j], map[x][y])) {
                    Point np = new Point(x, y);
                    list.add(np);
                    queue.add(np);
                    visited[x][y] = true;
                }
            }
        }

        // 인접국가 개수가 2이상이면 인구이동 발생
        if (list.size() >= 2) {
            int total = 0;
            for (Point loc : list) {
                total += map[loc.i][loc.j];
            }
            int avg = total / list.size();
            for (Point loc : list) {
                map[loc.i][loc.j] = avg;
            }
            return true;
        }
        return false; // 인구이동이 없으면 false
    }

    static boolean diff(int i, int j) {
        int sub = i >= j ? i - j : j - i;

        return L <= sub && sub <= R;
    }

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            super();
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Point [i=" + i + ", j=" + j + "]";
        }

    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
    }

}
