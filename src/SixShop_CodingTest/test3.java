package SixShop_CodingTest;

import java.util.Arrays;

public class test3 {

    public static void main(String[] args) {
//        int n = 1_000_000_000;
//        int n = 100_000_000;
        int n = 8;
        System.out.println(solution(n));
    }

    static public int solution(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < n + 1; i++) {
            if (i % 5 == 0) dp[i] = i / 5;
        }

        for (int i = 3; i < n + 1; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                if (i % 3 == 0) dp[i] = Integer.min(dp[i - 3] == Integer.MAX_VALUE ? dp[i - 3] : dp[i - 3] + 1, i / 3);
                else dp[i] = dp[i - 3] == Integer.MAX_VALUE ? dp[i - 3] : dp[i - 3] + 1;
            } else {
                if (i % 3 == 0) dp[i] = Integer.min(dp[i], i / 3);
            }
        }

        if (dp[n] == Integer.MAX_VALUE) return -1;
        return dp[n];
    }
}
