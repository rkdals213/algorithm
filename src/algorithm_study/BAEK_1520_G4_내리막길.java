package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1520_G4_내리막길 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }

    static int DFS(int x, int y) {
        if (dp[x][y] != -1) return dp[x][y];

        if (x == N - 1 && y == M - 1) {
            return 1;
        }
        dp[x][y] = 0;
        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (isIn(nx, ny) && map[nx][ny] < map[x][y]) {
                dp[x][y] += DFS(nx, ny);
            }
        }
        return dp[x][y];
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
