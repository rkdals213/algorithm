package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_19236_G3_청소년상어 {

    static int[][] dir = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] fish = new int[17][3];
        int[][] map = new int[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(temp.nextToken());
                map[i][j] = num;
                fish[num][0] = Integer.parseInt(temp.nextToken()) - 1;
                fish[num][1] = i;
                fish[num][2] = j;
            }
        }
        Shark shark = new Shark(0, 0, fish[map[0][0]][0]);
        result += map[0][0];
        fish[map[0][0]][0] = 9999;
        map[0][0] = -1;

        dfs(result, map, shark, fish);

        System.out.println(result);
    }

    static void dfs(int count, int[][] nextMap, Shark shark, int[][] fish) {
        for (int i = 1; i < 17; i++) {
            if (fish[i][0] == 9999) continue;
            while (!isIn(fish[i][1] + dir[fish[i][0]][0], fish[i][2] + dir[fish[i][0]][1]) || isShark(fish[i][1] + dir[fish[i][0]][0], fish[i][2] + dir[fish[i][0]][1], shark)) {
                fish[i][0]++;
                if (fish[i][0] >= 8) fish[i][0] = 0;
            }

            int thisX = fish[i][1];
            int thisY = fish[i][2];

            int targetX = fish[i][1] + dir[fish[i][0]][0];
            int targetY = fish[i][2] + dir[fish[i][0]][1];

            fish[i][1] = targetX;
            fish[i][2] = targetY;

            int targetNum = nextMap[targetX][targetY];
            if (targetNum != -1) {
                fish[targetNum][1] = thisX;
                fish[targetNum][2] = thisY;
            }
            nextMap[targetX][targetY] = i;
            nextMap[thisX][thisY] = targetNum;
        }

        for (int i = 1; i < 4; i++) {
            if (!isIn(shark.x + dir[shark.dir][0] * i, shark.y + dir[shark.dir][1] * i)) {
               result = Integer.max(result, count);
               return;
            }

            int sharkX = shark.x + dir[shark.dir][0] * i;
            int sharkY = shark.y + dir[shark.dir][1] * i;

            if(nextMap[sharkX][sharkY] != -1) {
                int[][] nextMapClone = new int[4][4];
                for (int j = 0; j < 4; j++) {
                    nextMapClone[j] = nextMap[j].clone();
                }
                int[][] fishClone = new int[17][3];
                for (int j = 1; j < 17; j++) {
                    fishClone[j] = fish[j].clone();
                }
                Shark sharkClone = new Shark(sharkX, sharkY, fish[nextMap[sharkX][sharkY]][0]);
                fishClone[nextMapClone[sharkX][sharkY]][0] = 9999;
                nextMapClone[sharkX][sharkY] = -1;
                dfs(count + nextMap[sharkX][sharkY], nextMapClone, sharkClone, fishClone);
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 4;
    }

    static boolean isShark(int x, int y, Shark shark) {
        return x == shark.x && y == shark.y;
    }

    static class Shark {
        int x;
        int y;
        int dir;

        public Shark(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
