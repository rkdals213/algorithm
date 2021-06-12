package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BAEK_G4_1647_도시분할계획 {
    static int N;
    static int M;
    static int[][] edges;
    static int[] parent;
    static int[] rank;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        edges = new int[M][3];
        parent = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(temp.nextToken());
            edges[i][1] = Integer.parseInt(temp.nextToken());
            edges[i][2] = Integer.parseInt(temp.nextToken());
        }

        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < M; i++) {
            System.out.println(Arrays.toString(edges[i]));
        };

        for (int i = 0; i < N; i++) {
            makeSet(i);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);

            if (x == y) continue;

            union(x, y);
            result += edges[i][2];
            cnt++;
            if (cnt == N - 2) break;
        }

        System.out.println(result);
    }

    static void makeSet(int x) {
        parent[x] = x;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }
}
