package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BAEK_3190_G5_뱀 {
    static int N, K, L;
    static List<Point> apples = new ArrayList<>();
    static int [][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    static int dir = 1;
    static Deque<Point> snake = new LinkedList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(temp.nextToken())-1;
            int y = Integer.parseInt(temp.nextToken())-1;
            apples.add(new Point(x,y));
        }

        snake.add(new Point(0,0));

        L = Integer.parseInt(br.readLine());
        int totalTime = 0;
        for (int i = 0; i < L; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(temp.nextToken());
            char d = temp.nextToken().charAt(0);
            while(totalTime < time) {
                Point t = snake.peekFirst();
                int x = t.x + dirs[dir][0];
                int y = t.y + dirs[dir][1];
                if(isIn(x,y) && !snake.contains(new Point(x,y))){
                    if(apples.contains(new Point(x,y))){
                        snake.addFirst(new Point(x,y));
                        apples.remove(new Point(x,y));
                    }else{
                        snake.addFirst(new Point(x,y));
                        snake.pollLast();
                    }
                    result++;
                }else{
                    System.out.println(result+1);
                    return;
                }
                totalTime++;
            }
            if(d == 'D') dir = (dir+1)%4;
            else {
                if(dir == 0) dir = 3;
                else dir--;
            }
        }
        while(true){
            Point t = snake.peekFirst();
            int x = t.x + dirs[dir][0];
            int y = t.y + dirs[dir][1];
            if(isIn(x,y) && !snake.contains(new Point(x,y))){
                if(apples.contains(new Point(x,y))){
                    snake.addFirst(new Point(x,y));
                    apples.remove(new Point(x,y));
                }else{
                    snake.addFirst(new Point(x,y));
                    snake.pollLast();
                }
                result++;
            }else{
                System.out.println(result+1);
                return;
            }
        }

    }

    static boolean isIn(int x, int y){
        return  x>=0 && y>=0 && x<N && y<N;
    }

    static class Point{
        int x, y;
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

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
