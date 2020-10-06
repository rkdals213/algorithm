package algorithm_study;

import java.util.Arrays;

// 아직 덜품
public class Pro_LV3_자물쇠와열쇠 {
    public static void main(String[] args) {
//        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
//        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] key = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
//        int[][] lock = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
//        int[][] key = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
//        int[][] lock = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        int[][] key = {{0, 0, 0}, {0, 0, 0}, {1, 1, 1}};
        int[][] lock = {{1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 0, 1, 1}, {1, 1, 1, 1, 1}};
        System.out.println(solution(key, lock));
    }


    static int M, N;

    static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        N = lock.length;
        M = key.length + (N - 1) * 2;

        int[][] keyTemp = new int[M][M];

        boolean cc = false;

        c:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] == 0) {
                    cc = true;
                    break c;
                }
            }
        }

        if (!cc) return true;

        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                keyTemp[i + N - 1][j + N - 1] = key[i][j];
            }
        }

        for (int k = 0; k < 4; k++) {
            boolean f = false;
            outer:
            for (int i = 0; i < M - N + 1; i++) {
                for (int j = 0; j < M - N + 1; j++) {
                    if (check(keyTemp, lock, i, j)) {
                        f = true;
                        break outer;
                    }
                }
            }

            if (f) return true;

            keyTemp = rotate(keyTemp);
        }

        return answer;
    }

    static boolean check(int[][] key, int[][] lock, int xx, int yy) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i][j] + key[i + xx][j + yy] == 0 || lock[i][j] + key[i + xx][j + yy] == 2) {
                    return false;
                }
            }
        }

        return true;
    }

    static int[][] rotate(int[][] key) {
        int[][] temp = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = key[M - 1 - j][i];
            }
        }
        return temp;
    }

}
