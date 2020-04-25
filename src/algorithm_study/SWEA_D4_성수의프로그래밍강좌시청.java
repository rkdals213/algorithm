package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_성수의프로그래밍강좌시청 {
	static int N,K;
	static double max;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());
		
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			max = 0;
			temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			K = Integer.parseInt(temp.nextToken());
			int [] input = new int [N];
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				input[j] = Integer.parseInt(temp.nextToken());
			}
			Arrays.sort(input);
//			System.out.println(Arrays.toString(input));
			double result = 0;
			for (int j = N-K; j < input.length; j++) {
				result = (result+input[j])/2.0;
			}
			
			sb.append(result).append("\n");
			
		}
		System.out.println(sb);

	}
	
	
}
