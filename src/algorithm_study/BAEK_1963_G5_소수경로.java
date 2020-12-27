package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_1963_G5_소수경로 {
    static boolean[] visited;
    static boolean[] primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        primes = new boolean[10000];

        initPrimes();

        for (int i = 0; i < N; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(temp.nextToken());
            int to = Integer.parseInt(temp.nextToken());

            visited = new boolean[10000];

            int result = BFS(from, to);
            if (result == -1) sb.append("Impossible");
            else sb.append(result);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int BFS(int from, int to) {
        if (from == to) return 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(from, 0));
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 1; i < 10000; i *= 10) {
                for (int j = 1; j <= 9; j++) {
                    int next = now.num + (i * j);
                    if (next / (i * 10) > now.num / (i * 10)) next -= (i * 10);

                    if (next == to) {
                        return now.count + 1;
                    }
                    if (next >= 1000 && next < 10000 && !visited[next]) {
                        visited[next] = true;
                        if (primes[next]) q.add(new Point(next, now.count + 1));
                    }
                }
            }
        }

        return -1;
    }

    public static void initPrimes() {
        for (int i = 1000; i < 10000; i++) {
            primes[i] = true;
            for (int j = 2; j < i/2; j++) {
                if(i % j == 0) {
                    primes[i] = false;
                    break;
                }
            }
        }
    }

    public static class Point {
        int num;
        int count;

        public Point(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
