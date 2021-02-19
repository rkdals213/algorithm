package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_11726_S3_2xn타일링2 {
    static int[] memo;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N + 1];
        if (N == 1) System.out.println(1);
        else if (N == 2) System.out.println(3);
        else {
            memo[0] = 1;
            memo[1] = 1;
            memo[2] = 3;
            memo[3] = 5;

            DP(N);
            System.out.println(memo[N]);
        }

    }

    static int DP(int n) {
        if (n <= 3) return memo[n];
        else if (memo[n] > 0) return memo[n];
        else {
            return memo[n] = (DP(n - 2) * 2 + DP(n - 1)) % 10007;

        }
    }

}
