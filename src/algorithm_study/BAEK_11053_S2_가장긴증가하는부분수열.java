package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEK_11053_S2_가장긴증가하는부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int [] list = new int [N];
		int [] DP = new int [N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(temp.nextToken());
		}
		for (int i = 0; i < N; i++) {
			DP[i] = 1;
			for (int j = 0; j < i; j++) {
				if(list[i] > list[j] && DP[i] < DP[j]+1) {
					DP[i] = DP[j]+1;
				}
			}
			result = Math.max(result, DP[i]);
		}
		
		System.out.println(result);
		

	}

}
