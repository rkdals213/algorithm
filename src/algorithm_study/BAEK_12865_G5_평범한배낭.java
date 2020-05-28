package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_12865_G5_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int K = Integer.parseInt(temp.nextToken());
		int [][] dp = new int [N+5][K+5];
		
		for (int i = 1; i <= N; i++) {
			temp = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(temp.nextToken());
			int V = Integer.parseInt(temp.nextToken());
			for (int j = 0; j < W; j++) {
				dp[i][j] = dp[i-1][j];
			}
			for (int j = W; j < K+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V);
			}
		}
		
		System.out.println(dp[N][K]);

	}

}
