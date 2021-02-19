package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_14502_G5_연구소 {
    static int N, M;
    static int[][] map;
    static List<Integer> virus = new ArrayList<>();
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int max = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        map = new int[N][M];
        max = N * M;
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(temp.nextToken());
                map[i][j] = v;
                if (v == 1) max--;
                if (v == 2) {
                    virus.add(i * M + j);
                    max--;
                }
            }
        }

        makeWall(0, new int[3], 0);
        System.out.println(result);


    }

    static void makeWall(int cur, int[] result, int start) {
        if (cur == 3) {
            spread(result);
//			System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = start; i < N * M; i++) {
            if (map[i / M][i % M] == 0) {
                result[cur] = i;
                makeWall(cur + 1, result, i + 1);
            }
        }
    }

    static void spread(int[] list) {
        int result_temp = max;
        int[][] map2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            map2[i] = map[i].clone();
        }
        for (int i = 0; i < 3; i++) {
            map2[list[i] / M][list[i] % M] = 1;
            result_temp--;
        }
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            q.add(new Point(virus.get(i) / M, virus.get(i) % M));
        }
        while (!q.isEmpty()) {
            Point t = q.poll();
            if (result_temp < result) return;
            for (int i = 0; i < 4; i++) {
                int x = t.x + dir[i][0];
                int y = t.y + dir[i][1];
                if (isIn(x, y) && map2[x][y] == 0) {
                    q.add(new Point(x, y));
                    map2[x][y] = 2;
                    result_temp--;
                }
            }
        }
        result = Math.max(result, result_temp);

    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

}
