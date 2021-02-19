package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_14950_G2_정복자 {
    static int N, M, t;
    static List<Point> list = new ArrayList<>();
    static int[] root;
    static int result = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        t = Integer.parseInt(temp.nextToken());
        visited = new boolean[N];
        root = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(temp.nextToken()) - 1;
            int e = Integer.parseInt(temp.nextToken()) - 1;
            int value = Integer.parseInt(temp.nextToken());

            list.add(new Point(s, e, value));
        }

        list.sort(new Comparator<Point>() {

            @Override
            public int compare(Point o1, Point o2) {
                Integer a1 = o1.value;
                Integer a2 = o2.value;

                return a1.compareTo(a2);
            }
        });

        int cnt = 0;
        for (Point point : list) {
            if (union(point.s, point.e)) {
                result += point.value + t * cnt;
                cnt++;
            }
        }

        System.out.println(result);

    }

    static int find(int k) {
        if (root[k] == -1) {
            return k;
        } else {
            return root[k] = find(root[k]);
        }
    }

    static boolean union(int a, int b) {
        int roota = find(a);
        int rootb = find(b);
        if (roota != rootb) {
            root[roota] = rootb;
            return true;
        }
        return false;
    }

    static class Point {
        int s, e, value;

        public Point(int s, int e, int value) {
            super();
            this.e = e;
            this.s = s;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Point [s=" + s + ", e=" + e + ", value=" + value + "]";
        }
    }
}
