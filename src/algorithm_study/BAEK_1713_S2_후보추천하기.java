package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_1713_S2_후보추천하기 {
    static int N, M;
    static Point[] students;
    static PriorityQueue<Point> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        students = new Point[100];
        for (int i = 0; i < 100; i++) {
            students[i] = new Point(i + 1, 0, 0);
        }
        StringTokenizer temp = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(temp.nextToken()) - 1;

            students[n].c++;
            if (!q.remove(students[n])) students[n].t = i + 1;
            q.add(students[n]);
            if (q.size() > N) {
                if (q.peek().n == students[n].n) {
                    q.poll();
                    q.poll().c = 0;
                    q.add(students[n]);
                } else q.poll().c = 0;
            }
        }

        int[] result = new int[q.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = q.poll().n;
        }
        Arrays.sort(result);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    static class Point implements Comparable<Point> {
        int n, c, t;

        public Point(int n, int c, int t) {
            this.n = n;
            this.c = c;
            this.t = t;
        }

        @Override
        public int compareTo(Point o) {
            if (this.c == o.c) return Integer.compare(this.t, o.t);
            return Integer.compare(this.c, o.c);
        }
    }
}
