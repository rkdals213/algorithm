package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_11726_S3_2xn타일링 {
	static int [] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		memo = new int [N+1];
		if(N==1) System.out.println(1);
		else{
			memo[0] = 1;
			memo[1] = 1;
			memo[2] = 2;
			
			DP(N);
			System.out.println(memo[N]);
		}
	
	}
	
	static int DP(int n) {
		if(n<=2) return memo[n];
		else if(memo[n]>0) return memo[n];
		else {			
			return memo[n] = (DP(n-1) + DP(n-2))%10007;			
		}
	}

}
