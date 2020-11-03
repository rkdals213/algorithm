package algorithm_study;

import java.util.*;

public class Pro_LV3_가장먼노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {2, 4}, {5, 2}, {1, 2}};
        System.out.println(solution(n, edge));
    }

    static int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;

        list = new List[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int start = edge[i][0];
            int end = edge[i][1];
            list[start].add(end);
            list[end].add(start);
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Point t = q.poll();
            List<Integer> nowList = list[t.now];
            for (int i = 0; i < nowList.size(); i++) {
                int next = nowList.get(i);
                if (!visited[next]) {
                    q.add(new Point(next, t.dis + 1));
                    visited[next] = true;
                }
            }
            if (t.dis + 1 == max) answer++;
            else if (t.dis + 1 > max) {
                max = t.dis + 1;
                answer = 1;
            }
        }


        return answer;
    }

    static List<Integer>[] list;

    static boolean visited[];

    static class Point {
        int now;
        int dis;

        public Point(int now, int dis) {
            this.now = now;
            this.dis = dis;
        }

        public String toString() {
            return this.now + ", " + this.dis;
        }
    }
}
