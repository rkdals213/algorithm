package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BAEK_6497_G4_전력난 {
    static int V, E;
    static int[][] map;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        V = Integer.parseInt(temp.nextToken());
        E = Integer.parseInt(temp.nextToken());
        map = new int[E][3];
        parent = new int[V+1];
        int total = 0;
        for (int i = 0; i < E; i++) {
            temp = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(temp.nextToken());
            map[i][1] = Integer.parseInt(temp.nextToken());
            map[i][2] = Integer.parseInt(temp.nextToken());
            total += map[i][2];
        }

        Arrays.sort(map, Comparator.comparingInt(o -> o[2]));
        initParent();
        int cnt = 0;

        int sum = 0;
        for (int i = 0; i < E; i++) {
            if (cnt == V - 1) break;
            int a = find(map[i][0]);
            int b = find(map[i][1]);

            if (a != b) {
                union(a, b);
                sum += map[i][2];
                cnt++;
            }
        }

        System.out.println(total - sum);

    }

    static private void initParent() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        parent[px] = parent[py];
    }
}
