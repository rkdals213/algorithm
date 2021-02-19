package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_16973_G5_직사각형탈출 {
    static boolean[][] map;
    static boolean[][] visited;
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int A;
    private static int B;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(temp.nextToken()) == 1) {
                    map[i][j] = true;
                }
            }
        }
        temp = new StringTokenizer(br.readLine());
        A = Integer.parseInt(temp.nextToken());
        B = Integer.parseInt(temp.nextToken());

        visited = new boolean[N][M];
        Point start = new Point(Integer.parseInt(temp.nextToken()) - 1, Integer.parseInt(temp.nextToken()) - 1, 0);
        Point end = new Point(Integer.parseInt(temp.nextToken()) - 1, Integer.parseInt(temp.nextToken()) - 1, 0);

        BFS(start, end);
    }

    static void BFS(Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        int ex = end.i;
        int ey = end.j;
        queue.add(start);
        visited[start.i][start.j] = true;
        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int x = temp.i + dirs[i][0];
                int y = temp.j + dirs[i][1];

                if (isPossible(x, y, i) && !map[x][y]) {
                    if (x == ex && y == ey) {
                        System.out.println(temp.count + 1);
                        return;
                    }
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.add(new Point(x, y, temp.count + 1));
                    }

                }
            }
        }
        System.out.println(-1);
    }

    private static boolean isPossible(int i, int j, int dir) {

        switch (dir) {
            case 0:
                if (i >= 0) {
                    for (int k = j; k <= j + B - 1; k++) {
                        if (map[i][k]) return false;
                    }
                } else {
                    return false;
                }
                break;
            case 1:
                if (i + A - 1 < N) {
                    for (int k = j; k <= j + B - 1; k++) {
                        if (map[i + A - 1][k]) return false;
                    }
                } else {
                    return false;
                }
                break;
            case 2:
                if (j >= 0) {
                    for (int k = i; k <= i + A - 1; k++) {
                        if (map[k][j]) return false;
                    }
                } else {
                    return false;
                }
                break;

            case 3:
                if (j + B - 1 < M) {
                    for (int k = i; k <= i + A - 1; k++) {
                        if (map[k][j + B - 1]) return false;
                    }
                } else {
                    return false;
                }
                break;

            default:
                break;
        }

        return true;
    }

    static class Point {
        int i;
        int j;
        int count;

        public Point(int i, int j, int count) {
            super();
            this.i = i;
            this.j = j;
            this.count = count;
        }
    }

}