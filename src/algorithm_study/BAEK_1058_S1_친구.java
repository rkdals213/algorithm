package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BAEK_1058_S1_친구 {
    static int N;
    static char[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            result = Integer.max(result, BFS(i));
        }

        System.out.println(result);
    }

    static int BFS(int i) {
        int result = 0;
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N];
        visited[i] = true;
        q.add(new Point(i, 0));
        while(!q.isEmpty()) {
            Point t = q.poll();
            for (int j = 0; j < map[t.n].length; j++) {
                if (map[t.n][j] == 'Y' && !visited[j] &&t.c <= 1) {
                    visited[j] = true;
                    q.add(new Point(j, t.c + 1));
                    result++;
                }
            }
        }

        return result;
    }
    
    static class Point {
        int n, c;

        public Point(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }
}
