package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2178_S1_미로탐색 {
    static int N, M;
    static char[][] map;
    static int[][] dir4 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[i] = input.toCharArray();
        }

        BFS();
    }

    private static void BFS() {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Point t = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = t.x + dir4[i][0];
                int yy = t.y + dir4[i][1];
                if (xx == N - 1 && yy == M - 1) {
                    System.out.println(t.length + 1);
                    return;
                }
                if (isIn(xx, yy) && map[xx][yy] == '1' && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    q.add(new Point(xx, yy, t.length + 1));
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Point {
        int x, y, length;

        public Point(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", length=" + length +
                    '}';
        }
    }
}
