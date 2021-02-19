package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_19238_G4_스타트택시 {
    static int N, M, K;
    static int[][] map;
    static int[][] dir4 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static PriorityQueue<Point> q = new PriorityQueue<>();
    static int ride = 0;
    static int result = 0;
    static Map<Integer, Integer> to = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
            }
        }

        temp = new StringTokenizer(br.readLine());
        q.add(new Point(Integer.parseInt(temp.nextToken()) - 1, Integer.parseInt(temp.nextToken()) - 1, K, 0));

        for (int i = 2; i <= M + 1; i++) {
            temp = new StringTokenizer(br.readLine());
            map[Integer.parseInt(temp.nextToken()) - 1][Integer.parseInt(temp.nextToken()) - 1] = i;
            int a = (Integer.parseInt(temp.nextToken()) - 1) * N + Integer.parseInt(temp.nextToken()) - 1;
            to.put(i, a);
        }

        BFS();

        if (to.isEmpty()) System.out.println(result);
        else System.out.println(-1);

    }

    static void BFS() {
        boolean[][] visited = new boolean[N][N];
        while (!q.isEmpty()) {
            Point t = q.poll();

            if (ride == 0 && map[t.x][t.y] > 1) {
                ride = map[t.x][t.y];
                map[t.x][t.y] = 0;
                q.clear();
                visited = new boolean[N][N];
                visited[t.x][t.y] = true;
            } else if (ride != 0 && to.get(ride) == t.x * N + t.y) {
                to.remove(ride);
                ride = 0;
                t.k += t.move * 2;
                t.move = 0;
                q.clear();
                q.add(t);
                visited = new boolean[N][N];
                visited[t.x][t.y] = true;
                result = t.k;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = t.x + dir4[i][0];
                int y = t.y + dir4[i][1];
                if (isIn(x, y) && !visited[x][y] && t.k > 0 && map[x][y] != 1) {
                    visited[x][y] = true;
                    if (ride != 0) q.add(new Point(x, y, t.k - 1, t.move + 1));
                    else q.add(new Point(x, y, t.k - 1, t.move));
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Point implements Comparable<Point> {
        int x, y, k, move;

        @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + ", k=" + k + ", move=" + move + "]";
        }

        public Point(int x, int y, int k, int move) {
            super();
            this.x = x;
            this.y = y;
            this.k = k;
            this.move = move;
        }

        @Override
        public int compareTo(Point o) {
            if (this.k == o.k) {
                if (this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                } else {
                    return Integer.compare(this.x, o.x);
                }
            } else {
                return (-1) * Integer.compare(this.k, o.k);
            }
        }
    }
}
