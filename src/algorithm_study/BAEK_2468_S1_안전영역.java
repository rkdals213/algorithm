package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BAEK_2468_S1_안전영역 {
    static int N, M;
    static int[][] map;
    static int[][] tempmap;
    static boolean[][] visited;
    static int[][] dir4 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        map = new int[N][N];
        tempmap = new int[N][N];
        int maxheight = 0;
        int minheight = 100;
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
                if (map[i][j] > maxheight) maxheight = map[i][j];
                if (map[i][j] < minheight) minheight = map[i][j];
            }
        }
        for (int k = minheight - 1; k < maxheight; k++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > k) {
                        visited[i][j] = true;
                        BFS(i, j, k);
                        cnt++;
                    }
                }
            }
            result = Math.max(result, cnt);
        }
        System.out.println(result);
    }

    static void BFS(int a, int b, int k) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(a, b));
        while (!q.isEmpty()) {
            Point t = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = t.x + dir4[i][0];
                int y = t.y + dir4[i][1];
                if (isIn(x, y) && !visited[x][y] && map[x][y] > k) {
                    q.add(new Point(x, y));
                    visited[x][y] = true;
                }
            }
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}
