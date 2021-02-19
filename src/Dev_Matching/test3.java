package Dev_Matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test3 {
    public static void main(String[] args) {
        int[][] groups1 = {{1, 5}, {2, 7}, {4, 8}, {3, 6}}; //4
        int[][] groups2 = {{6, 7}, {1, 4}, {2, 4}};  //3
        int[][] groups3 = {{1, 50}, {1, 100}, {51, 100}}; //1

//        System.out.println(solution(10, groups1));
//        System.out.println(solution(7, groups2));
        System.out.println(solution(100, groups3));
    }

    static int answer = Integer.MAX_VALUE;
    static int[][] input;

    static int solution(int n, int[][] groups) {

        input = new int[groups.length][2];
        for (int i = 0; i < groups.length; i++) {
            input[i] = groups[i].clone();
        }

        DFS(0, new int[groups.length], new boolean[groups.length]);


        return answer;
    }

    static void DFS(int cur, int[] result, boolean[] visited) {
        if (cur == result.length) {
            System.out.println(Arrays.toString(result));
            check(result);
            return;
        }

        for (int i = 0; i < result.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[cur] = i;
                DFS(cur + 1, result, visited);
                visited[i] = false;
            }

        }
    }

    static void check(int[] result) {
        List<Point> list = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < result.length; i++) {
            boolean f = false;
            Point t = new Point(input[result[i]][0], input[result[i]][1]);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(t)) {
                    if (list.get(j).x <= t.x && list.get(j).y >= t.y) {
                        f = true;
                        break;
                    }

                    list.get(j).x = Math.max(t.x, list.get(j).x);
                    list.get(j).y = Math.max(t.y, list.get(j).y);
                    f = true;
                    cnt++;
                    break;
                }
            }
            if (!f) {
                list.add(t);
                cnt++;
            }
        }

        System.out.println(list.toString());

        answer = Math.min(cnt, answer);

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            return (point.x >= x && point.x <= y) || (point.y >= x && point.y <= y);
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
