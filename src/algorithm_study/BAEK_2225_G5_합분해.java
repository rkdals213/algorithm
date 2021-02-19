package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_2225_G5_합분해 {
    static int N, K;
    static long mod = 1000000000;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        K = Integer.parseInt(temp.nextToken());
        dp = new long[K][N + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < K; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }

        System.out.println(dp[K - 1][N]);
    }

}
