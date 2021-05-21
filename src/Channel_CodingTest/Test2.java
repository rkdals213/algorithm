package Channel_CodingTest;

import java.util.LinkedList;
import java.util.Queue;

public class Test2 {
    public static void main(String[] args) {
//        System.out.println(solution(1,1,1,1));
//        System.out.println(solution(5,5,3,3));
//        System.out.println(solution(5,5,0,1));
//        System.out.println(solution(5,5,1,0));
//        System.out.println(solution(300,300,300,0));
//        System.out.println(solution(300,300,0,300));
//        System.out.println(solution(300,300,300,300));
//        System.out.println(solution(300,300,0,0));
        System.out.println(solution(300,300,150,0));
    }

    static int[][] dirs = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int N, M;
    static boolean[][] visited;
    static Queue<Point> q = new LinkedList<>();

    static public int solution(int n, int m, int x, int y) {
        int answer = -1;
        N = m+1;
        M = n+1;
        visited = new boolean[N][M];
        visited[0][0] = true;
        q = new LinkedList<>();

        Point start = new Point(0, 0, 0, 0, 0);
        if (arrive(start, x, y)) return 0;
        q.add(start);

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (move1Check(p)){
                int nx = p.x + dirs[p.dir][0];
                int ny = p.y + dirs[p.dir][1];

                int ndir = p.dir + 1;
                if (ndir > 3) ndir = 0;

                visited[nx][ny] = true;
                Point np = new Point(nx, ny, ndir, p.count+1, ndir);
                if (arrive(np, x, y)) return np.count;
                q.add(np);
            }
            if (move2Check(p)){
                int ndir = p.dir + 1;
                if (ndir > 3) ndir = 0;

                int nx = p.x + dirs[ndir][0];
                int ny = p.y + dirs[ndir][1];

                visited[nx][ny] = true;
                Point np = new Point(nx, ny, ndir, p.count+1, ndir);
                if (arrive(np, x, y)) return np.count;
                q.add(np);
            }
            int ndir = p.dir + 1;
            if (ndir > 3) ndir = 0;
            if (p.dir != ndir) q.add(new Point(p.x, p.y, ndir, p.count+1, p.dir));
        }

        return answer;
    }

    static boolean move1Check(Point p) {
        int nx = p.x + dirs[p.dir][0];
        int ny = p.y + dirs[p.dir][1];

        return isIn(nx, ny);
    }

    static boolean move2Check(Point p) {
        int nx = p.x + dirs[(p.dir + 1)%4][0];
        int ny = p.y + dirs[(p.dir + 1)%4][1];

        return isIn(nx, ny);
    }

    static boolean arrive(Point p, int x, int y) {
        return p.x == x && p.y == y;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M && !visited[x][y];
    }

    static class Point {
        int x, y, dir, count, firstDir;

        public Point(int x, int y, int dir, int count, int firstDir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.count = count;
            this.firstDir = firstDir;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", count=" + count +
                    '}';
        }
    }
}
