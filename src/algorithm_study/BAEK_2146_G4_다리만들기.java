package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2146_G4_다리만들기 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
            }
        }

        int cnt = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    BFS(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    BFS2(i, j, map[i][j]);
                }
            }
        }
        System.out.println(result);

    }

    static void BFS2(int x, int y, int cnt) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited2 = new boolean[N][N];
        queue.add(new Point(x, y, 0));
        while (!queue.isEmpty()) {
            Point t = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int xx = t.i + dirs[i][0];
                int yy = t.j + dirs[i][1];
                if (isIn(xx, yy) && !visited2[xx][yy]) {
                    if (map[xx][yy] != 0 && map[xx][yy] != cnt) {
                        result = Math.min(result, t.count);
                        return;
                    }
                    queue.add(new Point(xx, yy, t.count + 1));
                    visited2[xx][yy] = true;
                }
            }
        }
    }

    static void BFS(int x, int y, int cnt) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y, 0));
        map[x][y] = cnt;
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point t = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int xx = t.i + dirs[i][0];
                int yy = t.j + dirs[i][1];
                if (isIn(xx, yy) && map[xx][yy] != 0 && !visited[xx][yy]) {
                    queue.add(new Point(xx, yy, 0));
                    visited[xx][yy] = true;
                    map[xx][yy] = cnt;
                }
            }
        }
    }

    private static boolean isIn(int i, int j) {
        return i >= 0 && j >= 0 && i < N && j < N;
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
