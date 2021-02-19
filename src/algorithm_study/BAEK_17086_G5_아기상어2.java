package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17086_G5_아기상어2 {
    static int[][] map;
    static int N, M;
    static int[][] dir4 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) BFS(i, j);
            }
        }

        System.out.println(result);
    }

    static void BFS(int a, int b) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new Point(a, b, 0));
        visited[a][b] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < dir4.length; i++) {
                int x = p.x + dir4[i][0];
                int y = p.y + dir4[i][1];
                if (isIn(x, y) && !visited[x][y] && map[x][y] == 0) {
                    queue.add(new Point(x, y, p.count + 1));
                    visited[x][y] = true;
                } else if (isIn(x, y) && !visited[x][y] && map[x][y] == 1) {
                    result = Math.max(result, p.count + 1);
                    return;
                }
            }
        }

    }


    static class Point {
        int x, y, count;

        public Point(int x, int y, int count) {
            super();
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", count=" + count + "]";
        }

    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

}
