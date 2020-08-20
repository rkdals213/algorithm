package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_14891_S1_톱니바퀴 {
    static int[][] map = new int[4][8];
    static int N;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(temp.nextToken()) - 1;
            int dir = Integer.parseInt(temp.nextToken());

            visited = new boolean [4];

            if(dir < 0) turnLeft(line);
            else turnRight(line);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += map[i][0] * Math.pow(2, i);
        }
        System.out.println(result);
    }

    static void turnLeft(int line){
        if(visited[line]) return;
        visited[line] = true;
        if(line < 3 && map[line][2] != map[line+1][6]) turnRight(line+1);
        if(line > 0 && map[line][6] != map[line-1][2]) turnRight(line-1);
        int temp = map[line][0];
        for (int i = 0; i < 7; i++) {
            map[line][i] = map[line][i+1];
        }
        map[line][7] = temp;

    }

    static void turnRight(int line){
        if(visited[line]) return;
        visited[line] = true;
        if(line < 3 && map[line][2] != map[line+1][6]) turnLeft(line+1);
        if(line > 0 && map[line][6] != map[line-1][2]) turnLeft(line-1);
        int temp = map[line][7];
        for (int i = 7; i > 0; i--) {
            map[line][i] = map[line][i-1];
        }
        map[line][0] = temp;
    }
}
