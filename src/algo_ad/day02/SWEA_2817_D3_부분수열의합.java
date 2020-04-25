package algo_ad.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_2817_D3_부분수열의합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());		
		StringBuilder sb = new StringBuilder();
		
		for (int a = 0; a < TC; a++) {
			sb.append("#").append(a+1).append(" ");
			temp = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(temp.nextToken());
			int T = Integer.parseInt(temp.nextToken());
			int [] list = new int [N];
			temp = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(temp.nextToken());
			}
			int count = 0;
			for (int i = 0; i < (1<<list.length); i++) {
				int sum = 0;
				for (int j = 0; j < list.length; j++) {
					if((i & (1<<j)) > 0) {
						sum+=list[j];
						if(sum > T) {
							break;
						}
					}
				}				
				if(sum == T) {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
		
	}

}
