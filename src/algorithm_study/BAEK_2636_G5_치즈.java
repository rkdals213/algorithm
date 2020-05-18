package algorithm_study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BAEK_2636_G5_치즈 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;    
    static int cheese;
    static int time, cheeseCnt;
    static int [][] dir ={{-1,0},{0,1},{1,0},{0,-1}};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cheese = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }
        while (true) {
            visited= new boolean[N][M];
            BFS();
            time++;
            boolean flag = true;
            cheeseCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0) {
                        flag = false;
                        cheeseCnt++;
                    }
                }
            }
            if(flag) break;

            cheese = cheeseCnt;
        }
        System.out.println(time);
        System.out.println(cheese);

    }

    public static void BFS() {
    	Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        while (!q.isEmpty()) {
            Point top = q.poll();

            for(int i =0; i<dir.length;i++){
                int x = top.x + dir[i][0];
                int y = top.y + dir[i][1];
                if (x >= 0 && x < N && y >= 0 && y < M && !visited[x][y]) {
                    if (map[x][y] == 0) {
                        q.offer(new Point(x, y));
                        visited[x][y] = true;
                    } else {
                        map[x][y] = 0;
                        visited[x][y] = true;
                    }
                }

            }
        }
    }
}