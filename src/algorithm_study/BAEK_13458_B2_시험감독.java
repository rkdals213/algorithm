package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_13458_B2_시험감독 {
	static int N;
	static long [] A;
	static long B;
	static long C;
	static long total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new long [N];
		StringTokenizer temp = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(temp.nextToken());
		}
		temp = new StringTokenizer(br.readLine());
		B = Integer.parseInt(temp.nextToken());
		C = Integer.parseInt(temp.nextToken());
		total += N;
		for (int i = 0; i < N; i++) {
			A[i] -= B;	
			if(A[i] < 0) continue;
			if(A[i]%C != 0) {
				total += (A[i]/C) + 1;
			}else {
				total += (A[i]/C);
			}
		}
		
		System.out.println(total);
		
	}
}
