package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_17271_S1_리그오브레전설 {
    static int N, M;
    static long[] dp;
    static final int DIV = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer temp = new StringTokenizer(br.readLine());
        N = Integer.parseInt(temp.nextToken());
        M = Integer.parseInt(temp.nextToken());
        dp = new long[N + 1];
        if (N < M) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < M; i++) {
            dp[i] = 1;
        }
        dp[M] = 2;
        for (int i = M + 1; i < N + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - M]) % DIV;
        }
        System.out.println(dp[N]);
    }
}
