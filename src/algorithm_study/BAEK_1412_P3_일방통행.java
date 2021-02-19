package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BAEK_1412_P3_일방통행 {
    static int N;
    static boolean[][] map;
    static boolean result = true;
    static List<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            list.add(new Point());
            for (int j = 0; j < N; j++) {
                if (temp.charAt(j) == 'Y') {
                    map[i][j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != map[j][i] && map[i][j]) {
                    list.get(j).count++;
                    list.get(i).edge.add(j);
                }
                if (i == j && map[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (list.get(i).count == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int i = 0; i < list.get(k).edge.size(); i++) {
                int next = list.get(k).edge.get(i);
                list.get(next).count--;
                if (list.get(next).count == 0) {
                    queue.add(next);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (list.get(i).count > 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    static class Point {
        int count = 0;
        List<Integer> edge = new ArrayList<>();
    }
}
