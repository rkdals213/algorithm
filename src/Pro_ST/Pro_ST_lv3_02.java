package Pro_ST;

public class Pro_ST_lv3_02 {
    public static void main(String[] args) {
        int[][] puddles = {{2,1},{1,2}};
        System.out.println(solution(2,2, puddles));
    }

    static long solution(int m, int n, int[][] puddles) {
        long answer = 0;
        long[][] map = new long [n][m];
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][1]-1;
            int y = puddles[i][0]-1;
            map[x][y] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] < 0) continue;
                if(i == 0 || j == 0) map[i][j] = 1;
                else {
                    if(map[i][j-1] >= 0) map[i][j] += map[i][j-1];
                    map[i][j] %= 1000000007;
                    if(map[i-1][j] >= 0) map[i][j] += map[i-1][j];
                    map[i][j] %= 1000000007;
                }
            }
        }
        answer = map[n-1][m-1];
        return answer;
    }
}
