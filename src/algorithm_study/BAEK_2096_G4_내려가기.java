package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_2096_G4_내려가기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());

		int [][] maxDP = new int [N][3];
		int [][] minDP = new int [N][3];

		temp = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(temp.nextToken());
		int b = Integer.parseInt(temp.nextToken());
		int c = Integer.parseInt(temp.nextToken());

		maxDP[0][0] = minDP[0][0] = a;		
		maxDP[0][1] = minDP[0][1] = b;		
		maxDP[0][2] = minDP[0][2] = c;		

		for (int i = 1; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			a = Integer.parseInt(temp.nextToken());
			b = Integer.parseInt(temp.nextToken());
			c = Integer.parseInt(temp.nextToken());
			
			maxDP[i][0] = Math.max(maxDP[i-1][0], maxDP[i-1][1]) + a;
			maxDP[i][1] = Math.max(maxDP[i-1][0], maxDP[i-1][1]);
			maxDP[i][1] = Math.max(maxDP[i][1], maxDP[i-1][2]) + b;
			maxDP[i][2] = Math.max(maxDP[i-1][1], maxDP[i-1][2]) + c;

			minDP[i][0] = Math.min(minDP[i-1][0], minDP[i-1][1]) + a;
			minDP[i][1] = Math.min(minDP[i-1][0], minDP[i-1][1]);
			minDP[i][1] = Math.min(minDP[i][1], minDP[i-1][2]) + b;
			minDP[i][2] = Math.min(minDP[i-1][1], minDP[i-1][2]) + c;
		}
		
		int maxresult = Math.max(maxDP[N-1][0], maxDP[N-1][1]);
		maxresult = Math.max(maxresult, maxDP[N-1][2]);
		
		int minresult = Math.min(minDP[N-1][0], minDP[N-1][1]);
		minresult = Math.min(minresult, minDP[N-1][2]);
		
		System.out.println(maxresult + " " + minresult);

	}

}
