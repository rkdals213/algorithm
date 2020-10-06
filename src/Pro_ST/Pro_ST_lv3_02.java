package Pro_ST;

import java.util.Arrays;

public class Pro_ST_lv3_02 {
    public static void main(String[] args) {
        int[][] puddles = {{1, 3}, {3, 1}};
        System.out.println(solution(4, 4, puddles));
    }

    static long solution(int m, int n, int[][] puddles) {
        long answer = 0;
        long[][] map = new long[m][n];
        map[0][0] = 1;

        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            map[x][y] = -1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < 0) continue;
                if (i == 0 && j > 0) map[i][j] = map[i][j - 1];
                else if (j == 0 && i > 0) map[i][j] = map[i - 1][j];
                else if (i > 0 && j > 0) {
                    if (map[i][j - 1] >= 0) map[i][j] += map[i][j - 1];
                    map[i][j] %= 1000000007;
                    if (map[i - 1][j] >= 0) map[i][j] += map[i - 1][j];
                    map[i][j] %= 1000000007;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        answer = map[m - 1][n - 1];
        return answer;
    }
}
