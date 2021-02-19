package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 *  시작점 N 도착점 K
 *  걸을때 +-1 1초, 순간이동 2*X 0초
 */
public class BAEK_13549_G5_숨바꼭질3 {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());
        Arrays.fill(visited, Integer.MAX_VALUE);
        if (N > K) {
            System.out.println(N - K);
        } else {
            BFS();
        }

    }

    static void BFS() {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(N, 1));
        visited[N] = 1;
        if (N == K) {
            System.out.println(0);
            return;
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x > 2 * K) continue;
            if (p.x == K) {
                System.out.println(p.count - 1);
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    int x = p.x * 2;
                    if (isIn(x) && visited[x] > p.count) {
                        q.add(new Point(x, p.count));
                        visited[x] = p.count;
                    }
                } else if (i == 1) {
                    int x = p.x - 1;
                    if (isIn(x) && visited[x] > p.count + 1) {
                        q.add(new Point(x, p.count + 1));
                        visited[x] = p.count + 1;
                    }
                } else {
                    int x = p.x + 1;
                    if (isIn(x) && visited[x] > p.count + 1) {
                        q.add(new Point(x, p.count + 1));
                        visited[x] = p.count + 1;
                    }
                }
            }
        }


    }

    static boolean isIn(int x) {
        return x >= 0 && x < visited.length;
    }

    static class Point implements Comparable<Point> {
        int x;
        int count;

        public Point(int x, int count) {
            super();
            this.x = x;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point [x=" + x + ", count=" + count + "]";
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.count, o.count);
        }
    }
}
