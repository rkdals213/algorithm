package algorithm_study;

public class Pro_LV3_NQueen {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    static int[][] dirs = {{0, -1}, {-1, 0}, {-1, 1}, {-1, -1}};
    static int N;
    static int result = 0;

    static int solution(int n) {
        int answer = 0;
        N = n;
        boolean[][] map = new boolean[n][n];

        go(0, map);

        return result;
    }

    static void go(int x, boolean[][] map) {
        if (x >= N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (check(x, i, map)) {
                map[x][i] = true;
                go(x + 1, map);
                map[x][i] = false;
            }
        }
    }

    static boolean check(int r, int c, boolean[][] map) {
        for (int i = 0; i < 4; i++) {
            int x = r;
            int y = c;
            while (isIn(x, y)) {
                if (!map[x][y]) {
                    x += dirs[i][0];
                    y += dirs[i][1];
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }


}
