package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BAEK_1922_G4_네트워크연결 {
    static int V, E;
    static int[][] nodes;
    static int[] rank;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        rank = new int[V + 1];
        parent = new int[V + 1];
        nodes = new int[E][3];
        for (int i = 0; i < E; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            nodes[i][0] = Integer.parseInt(temp.nextToken());
            nodes[i][1] = Integer.parseInt(temp.nextToken());
            nodes[i][2] = Integer.parseInt(temp.nextToken());
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o[2]));

        int cnt = 0;
        int total = 0;

        initParent();

        for (int i = 0; i < E; i++) {
            int x = find(nodes[i][0]);
            int y = find(nodes[i][1]);
            if (x == y) continue;

            union(x, y);
            cnt++;
            total += nodes[i][2];
            if (cnt == V - 1) break;
        }

        System.out.println(total);
    }

    static public void initParent() {
        for (int i = 1; i < V + 1; i++) {
            parent[i] = i;
        }
    }

    static public int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (rank[px] > rank[py]) {
            parent[py] = px;
            rank[py] += rank[px];
        } else {
            parent[px] = py;
            rank[px] += rank[py];
        }
    }
}
