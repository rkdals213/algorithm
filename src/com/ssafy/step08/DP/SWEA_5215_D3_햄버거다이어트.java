package com.ssafy.step08.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215_D3_햄버거다이어트 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=TC; i++) {
			sb.append("#").append(i).append(" ");
			StringTokenizer temp = new StringTokenizer(br.readLine());
			int souce = Integer.parseInt(temp.nextToken());
			int cal = Integer.parseInt(temp.nextToken());
			
			int [] score_array = new int [souce];
			int [] cal_array = new int [souce];
			
			for(int j=0; j<souce; j++) {		
				temp = new StringTokenizer(br.readLine());
				score_array[j] = Integer.parseInt(temp.nextToken());
				cal_array[j] = Integer.parseInt(temp.nextToken());			
			}			
			
			int [][] dp = new int [souce+1][cal+1];
			
			for(int a = 1; a<=souce; a++) {
				for(int b = 1; b<=cal; b++) {
					if(cal_array[a-1] > b) {
						dp[a][b] = dp[a-1][b];
					}
					else {
						dp[a][b] = Math.max(dp[a-1][b], dp[a-1][b-cal_array[a-1]] + score_array[a-1]);
					}
				}
			}
			sb.append(dp[souce][cal]).append("\n");
		}		
		System.out.println(sb);
	}
}
