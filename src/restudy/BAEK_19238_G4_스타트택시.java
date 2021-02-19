package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_19238_G4_스타트택시 {
    static int N, M;
    static int[][] map;
    static int fuel;
    static PriorityQueue<Taxi> q = new PriorityQueue<>();
    static Map<Integer, Integer> goals = new HashMap<>();
    static int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        fuel = Integer.parseInt(temp.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp.nextToken());
            }
        }

        temp = new StringTokenizer(br.readLine());
        int startx = Integer.parseInt(temp.nextToken()) - 1;
        int starty = Integer.parseInt(temp.nextToken()) - 1;
        q.add(new Taxi(startx, starty, fuel, 0, 0));

        for (int i = 2; i <= M + 1; i++) {
            temp = new StringTokenizer(br.readLine());
            int cusx = Integer.parseInt(temp.nextToken()) - 1;
            int cusy = Integer.parseInt(temp.nextToken()) - 1;
            int tox = Integer.parseInt(temp.nextToken()) - 1;
            int toy = Integer.parseInt(temp.nextToken()) - 1;
            map[cusx][cusy] = i;
            goals.put(i, tox * N + toy);
        }

        BFS();
    }

    static void BFS() {
        boolean[][] visited = new boolean[N][N];
        int result = 0;
        while (!q.isEmpty()) {
            Taxi t = q.poll();

            if (t.ride == 0 && map[t.x][t.y] != 0) {
                visited = new boolean[N][N];
                visited[t.x][t.y] = true;

                q.clear();
                q.add(new Taxi(t.x, t.y, t.f, map[t.x][t.y], t.move));
                map[t.x][t.y] = 0;
                continue;
            } else if (t.ride != 0 && goals.containsKey(t.ride) && goals.get(t.ride) == t.x * N + t.y) {
                visited = new boolean[N][N];
                visited[t.x][t.y] = true;
                q.clear();
                q.add(new Taxi(t.x, t.y, t.f + (t.move) * 2, 0, 0));
                result = t.f + (t.move) * 2;
                goals.remove(t.ride);
                continue;
            }
            if (t.f == 0) continue;
            for (int i = 0; i < 4; i++) {
                int x = t.x + dirs[i][0];
                int y = t.y + dirs[i][1];
                if (isIn(x, y) && map[x][y] != 1 && !visited[x][y]) {
                    visited[x][y] = true;
                    if (t.ride == 0) q.add(new Taxi(x, y, t.f - 1, t.ride, t.move));
                    else q.add(new Taxi(x, y, t.f - 1, t.ride, t.move + 1));
                }
            }
        }
        if (goals.isEmpty()) System.out.println(result);
        else System.out.println(-1);
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Taxi implements Comparable<Taxi> {
        int x, y, f, ride, move;

        public Taxi(int x, int y, int f, int ride, int move) {
            this.x = x;
            this.y = y;
            this.f = f;
            this.ride = ride;
            this.move = move;
        }

        @Override
        public int compareTo(Taxi o) {
            if (this.f == o.f) {
                if (this.x == o.x) return Integer.compare(this.y, o.y);
                return Integer.compare(this.x, o.x);
            }
            return Integer.compare(o.f, this.f);
        }
    }
}
