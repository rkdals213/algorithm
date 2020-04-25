package algo_ad.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1247_D5_최적경로 {
	static StringBuilder sb = new StringBuilder();
	static int homex ;	
	static int homey;	
	static int comx ;	
	static int comy ;	
	static int [][] clients;
	static int MIN = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());
		
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			temp = new StringTokenizer(br.readLine());
			homex = Integer.parseInt(temp.nextToken());	
			homey = Integer.parseInt(temp.nextToken());	
			comx = Integer.parseInt(temp.nextToken());	
			comy = Integer.parseInt(temp.nextToken());	
			clients = new int [N][2];
			for (int j = 0; j < N; j++) {
				clients[j][0] = Integer.parseInt(temp.nextToken());	
				clients[j][1] = Integer.parseInt(temp.nextToken());	
			}
			MIN = Integer.MAX_VALUE;
			perm(0, new boolean[N], N, new int [N]);
			sb.append(MIN).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void perm(int r, boolean [] visited, int depth, int [] result) {
		if(r==depth) {
			int sum = 0;

			sum += Math.abs(comx-clients[result[0]][0]) + Math.abs(comy-clients[result[0]][1]);	
			
			for (int j2 = 1; j2 < result.length; j2++) {
				sum += Math.abs(clients[result[j2-1]][0]-clients[result[j2]][0]) + 
						Math.abs(clients[result[j2-1]][1]-clients[result[j2]][1]);	
				if(sum > MIN) {
					break;
				}
			}
			
			sum += Math.abs(homex-clients[result[N-1]][0]) + 
					Math.abs(homey-clients[result[N-1]][1]);
			
			if(sum < MIN) {
				MIN = sum;
			}				
		}else {
			for (int i = 0; i < result.length; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[r] = i;
					perm(r+1, visited, depth, result);
					visited[i] = false;
				}
			}
		}
	}
}
