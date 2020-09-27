package Pro_ST;

import java.util.*;

public class Pro_ST_lv3_01 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {2, 6}, {1, 9}};
        System.out.println(solution(jobs));
    }

    static int solution(int[][] jobs) {
        int answer = 0;

        PriorityQueue<Point> q1 = new PriorityQueue<>();
        for (int i = 0; i < jobs.length; i++) {
            q1.add(new Point(jobs[i][0], jobs[i][1]));
        }

        while (!q1.isEmpty()){
//            System.out.println(q.poll().toString());
            PriorityQueue<Point2> temp = new PriorityQueue<>();
            while (!q1.isEmpty() && q1.peek().x <= answer){
                Point t = q1.poll();
                temp.add(new Point2(t.x, t.y));
            }

            if(temp.isEmpty()) {
                Point t = q1.poll();
                answer += t.y + answer - t.x;
            }else{
                Point2 t = temp.poll();
                answer += t.y + answer - t.x;
                while(!temp.isEmpty()){
                    Point2 t2 = temp.poll();
                    q1.add(new Point(t2.x, t2.y));
                }
            }
        }


        System.out.println(answer);
        return answer / jobs.length;
    }

    static class Point implements Comparable<Point> {
        int x, y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.x, o.x);
        }
    }

    static class Point2 implements Comparable<Point2> {
        int x, y;

        @Override
        public String toString() {
            return "Point2{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public Point2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point2 o) {
            return Integer.compare(this.y, o.y);
        }
    }
}
