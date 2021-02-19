package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_16235_G4_나무재태크 {
    static int N, M, K;
    static int[][] map1, map2;
    static PriorityQueue<Tree> q = new PriorityQueue<>();
    static Queue<Tree> deadTree = new LinkedList<>();
    static Deque<Tree> temp = new ArrayDeque<>();
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());

        map1 = new int[N][N];
        map2 = new int[N][N];
        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map1[i][j] = 5;
                map2[i][j] = Integer.parseInt(temp.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            temp = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(temp.nextToken()) - 1;
            int y = Integer.parseInt(temp.nextToken()) - 1;
            int z = Integer.parseInt(temp.nextToken());
            Tree t = new Tree(x, y, z);
            q.add(t);
        }

        year();
        System.out.println(q.size());
    }

    static void year() {
        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }
    }

    static void spring() {
        int l = q.size();
        for (int i = 0; i < l; i++) {
            Tree t = q.poll();
            if (map1[t.x][t.y] >= t.z) {
                map1[t.x][t.y] -= t.z;
                temp.add(new Tree(t.x, t.y, t.z + 1));
            } else {
                deadTree.add(t);
            }
        }
    }

    static void summer() {
        int l = deadTree.size();
        for (int i = 0; i < l; i++) {
            Tree t = deadTree.poll();
            map1[t.x][t.y] += t.z / 2;
        }
    }

    static void fall() {
        int l = temp.size();
        for (int i = 0; i < l; i++) {
            Tree t = temp.poll();
            if (t.z % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int x = t.x + dirs[j][0];
                    int y = t.y + dirs[j][1];
                    if (isIn(x, y)) q.add(new Tree(x, y, 1));
                }
            }
            q.add(t);
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map1[i][j] += map2[i][j];
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Tree implements Comparable<Tree> {
        int x, y, z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.z, o.z);
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    '}';
        }
    }
}
