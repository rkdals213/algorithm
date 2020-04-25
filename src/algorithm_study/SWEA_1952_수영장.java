package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			temp = new StringTokenizer(br.readLine());
			int [] cost = new int [4];
			for (int j = 0; j < 4; j++) {
				cost[j] = Integer.parseInt(temp.nextToken());
			}
			temp = new StringTokenizer(br.readLine());
			int [] day = new int [12];
			for (int j = 0; j < 12; j++) {
				day[j] = Integer.parseInt(temp.nextToken());
			}
			
			int [][] DP = new int [4][13];
			for (int j = 1; j < 3; j++) {
				for (int k = 1; k < 13; k++) {
					if(j == 1) {
						DP[j][k] = DP[j][k-1] + day[k-1]*cost[0];
					}else if(j == 2) {
						int t = Math.min(DP[j][k-1] + cost[1], DP[j][k-1] + day[k-1]*cost[0]);
						DP[j][k] = Math.min(DP[j-1][k], t);
						DP[j+1][k] = Math.min(DP[j-1][k], t);
					}
				}
			}
			for (int k = 3; k < 13; k++) {
				int t = Math.min(DP[3][k-1] + cost[1], DP[3][k-1] + day[k-1]*cost[0]);
				t = Math.min(t, DP[3][k-3] + cost[2]);
				DP[3][k] = Math.min(DP[2][k], t);
			}
			if(DP[3][12] < cost[3]) {
				sb.append(DP[3][12]).append("\n");
			}else {
				sb.append(cost[3]).append("\n");
			}
			
		}
		System.out.println(sb);
	}
}
