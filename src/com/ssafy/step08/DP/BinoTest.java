package com.ssafy.step08.DP;

public class BinoTest {
    static int bino(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        } else {
            // nCr = n-1Cr-1 + n-1Cr
            return bino(n - 1, r - 1) + bino(n - 1, r);
        }
    }

    static int[][] memo;

    static int binomemo(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }
        if (memo[n][r] == 0) {
            memo[n][r] = binomemo(n - 1, r - 1) + binomemo(n - 1, r);
        }
        return memo[n][r];
    }

    static int binoDP(int n, int r) {
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][r];
    }

    public static void main(String[] args) {
        int n = 300;
        int r = 2;
        System.out.println("단순재귀 : " + bino(n, r));

        memo = new int[n + 1][n + 1];
        System.out.println("재귀메모 : " + binomemo(n, r));

        System.out.println("DP : " + binoDP(n, r));
    }
}
