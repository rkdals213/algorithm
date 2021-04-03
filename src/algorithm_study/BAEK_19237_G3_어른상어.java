package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_19237_G3_어른상어 {
    static int N, M, K;
    static int[][][] map;
    static int[][] shark;
    static int[][][] sharkDirNext;
    static int[][] dirs = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());
        map = new int[N][N][2];
        shark = new int[M + 1][3];
        sharkDirNext = new int[M + 1][5][4];

        for (int i = 0; i < N; i++) {
            temp = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j][0] = Integer.parseInt(temp.nextToken());
                if (map[i][j][0] != 0) {
                    shark[map[i][j][0]][1] = i;
                    shark[map[i][j][0]][2] = j;
                }
            }
        }

        temp = new StringTokenizer(br.readLine());
        for (int i = 1; i < M + 1; i++) {
            shark[i][0] = Integer.parseInt(temp.nextToken());
        }

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < 5; j++) {
                temp = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    sharkDirNext[i][j][k] = Integer.parseInt(temp.nextToken());
                }
            }
        }

        makeSmell();
        for (int i = 1; i <= 1000; i++) {
            sharkMove();
            cleanSmell();
            makeSmell();
            removeShark();

            if (finish()) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }

    static void sharkMove() {
        for (int i = 1; i < M + 1; i++) {
            int dirNow = shark[i][0];
            int x = shark[i][1];
            int y = shark[i][2];
            if (x == 9999) continue;
            boolean f = false;
            for (int j = 0; j < 4; j++) {
                int dir = sharkDirNext[i][dirNow][j];
                if (!isIn(x + dirs[dir][0], y + dirs[dir][1]) || map[x + dirs[dir][0]][y + dirs[dir][1]][1] != 0) {

                } else {
                    if (map[x + dirs[dir][0]][y + dirs[dir][1]][0] == 0) {
                        map[x + dirs[dir][0]][y + dirs[dir][1]][0] = i;
                        shark[i][1] = x + dirs[dir][0];
                        shark[i][2] = y + dirs[dir][1];
                    } else {
                        shark[i][1] = 9999;
                        shark[i][2] = 9999;
                    }
                    shark[i][0] = dir;
                    f = true;
                    break;
                }
            }

            if (!f) {
                for (int j = 0; j < 4; j++) {
                    int dir = sharkDirNext[i][dirNow][j];
                    if (isIn(x + dirs[dir][0], y + dirs[dir][1]) && map[x + dirs[dir][0]][y + dirs[dir][1]][0] == i) {
                        map[x + dirs[dir][0]][y + dirs[dir][1]][0] = i;
                        shark[i][1] = x + dirs[dir][0];
                        shark[i][2] = y + dirs[dir][1];
                        shark[i][0] = dir;
                        break;
                    }
                }
            }
        }
    }

    static void cleanSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j][1] != 0) {
                    map[i][j][1]--;
                }
            }
        }
    }

    static void makeSmell() {
        for (int i = 1; i < M + 1; i++) {
            if (shark[i][1] == 9999) continue;
            map[shark[i][1]][shark[i][2]][1] = K;
        }
    }

    static void removeShark() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j][0] != 0) {
                    if (map[i][j][1] == 0) map[i][j][0] = 0;
                }
            }
        }
    }

    static boolean finish() {
        for (int i = 2; i < M + 1; i++) {
            if (shark[i][1] != 9999) return false;
        }
        return true;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
