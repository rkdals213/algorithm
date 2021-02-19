package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_D9_탈주범검거 {
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] pipes = {{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 0, 1, 0}, {1, 0, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}};
    static int result = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= TC; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer temp = new StringTokenizer(br.readLine());
            N = Integer.parseInt(temp.nextToken());
            M = Integer.parseInt(temp.nextToken());
            R = Integer.parseInt(temp.nextToken());
            C = Integer.parseInt(temp.nextToken());
            L = Integer.parseInt(temp.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                temp = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(temp.nextToken()) - 1;
                }
            }
            result = 0;
            BFS(R, C);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void BFS(int i, int j) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j, 1));
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Point t = q.poll();
            result++;
            for (int k = 0; k < dir.length; k++) {
                int x = t.x + dir[k][0];
                int y = t.y + dir[k][1];
                if (isIn(x, y) && map[x][y] != -1 && !visited[x][y] && t.cnt < L) {
                    if (pipes[map[t.x][t.y]][k] == 1 && pipes[map[x][y]][(k + 2) % 4] == 1) {
                        visited[x][y] = true;
                        q.add(new Point(x, y, t.cnt + 1));
                    }
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            super();
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
