package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_10942_G2_팰린드롬 {
	static int N, M;
	static int [] line;
	static int [][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer temp = new StringTokenizer(br.readLine());
		line = new int [N];
		dp = new int [N][N];
		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(temp.nextToken());
		}
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp.length; j++) {
				dp[i][j] = check(i, j);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(temp.nextToken())-1;
			int e = Integer.parseInt(temp.nextToken())-1;
			
			if(dp[s][e] == 2) sb.append(1);
			else sb.append(0);
			
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	
	static int check(int i, int j) {
		if(i==j) return 2;
		
		if(dp[i][j] != 0) return dp[i][j];
		
		if(i+1 == j) {
			if(line[i] == line[j]) return 2;
			else return 1;
		}
		
		if(line[i] != line[j]) return 1;
		else return dp[i][j] = check(i+1, j-1);
		
	}

}
