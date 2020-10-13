package Dev_Matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test1 {
    public static void main(String[] args) {
        int[][] groups1 = {{1, 5}, {2, 7}, {4, 8}, {3, 6}};
        int[][] groups2 = {{6, 7}, {1, 4}, {2, 4}};
        int[][] groups3 = {{1, 50}, {1, 100}, {51, 100}};

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

// 문제 삭제

        return answer;
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
