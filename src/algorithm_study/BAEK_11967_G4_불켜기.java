package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_11967_G4_불켜기 {
    static int N, M;
    static int[][] dir4 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<Integer>[] gr;
    static int[][] visited;
    static int result = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        gr = new List[N * N];
        visited = new int[N][N];
        for (int i = 0; i < N * N; i++) {
            gr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(temp.nextToken()) - 1;
            int y = Integer.parseInt(temp.nextToken()) - 1;
            int xx = Integer.parseInt(temp.nextToken()) - 1;
            int yy = Integer.parseInt(temp.nextToken()) - 1;

            int from = x * N + y;
            int to = xx * N + yy;

            gr[from].add(to);
        }
        visited[0][0] = 1;
        for (int j = 0; j < gr[0].size(); j++) {
            int next = gr[0].get(j);
            if (visited[next / N][next % N] == 0) {
                visited[next / N][next % N] = 1;
                result++;
            }
        }
        BFS();
        System.out.println(result);

    }

    static void BFS() {
        while (true) {
            boolean f = false;
            Queue<Point> q = new LinkedList<>();
            boolean visit[][] = new boolean[N][N];
            q.add(new Point(0, 0));
            while (!q.isEmpty()) {
                Point p = q.poll();
                for (int i = 0; i < dir4.length; i++) {
                    int x = p.x + dir4[i][0];
                    int y = p.y + dir4[i][1];
                    if (isIn(x, y) && !visit[x][y] && visited[x][y] == 1) {
                        visit[x][y] = true;
                        int k = x * N + y;
                        for (int j = 0; j < gr[k].size(); j++) {
                            int next = gr[k].get(j);
                            if (visited[next / N][next % N] == 0) {
                                visited[next / N][next % N] = 1;
                                f = true;
                                result++;
                            }
                        }
                        q.add(new Point(x, y));
                    }
                }
            }
            if (!f) break;
        }
    }


    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
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
}