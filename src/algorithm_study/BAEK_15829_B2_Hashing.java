package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEK_15829_B2_Hashing {
	static final long mod  = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String src = br.readLine();
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int a = src.charAt(i) - 'a' + 1;
			sum += (pow(31, i) % mod * a) % mod;
			sum = sum % mod;
		}
		
		System.out.println(sum);
		
	}
	
	static long pow(int k, int a) {
		if(a == 0) return 1;
		return ((31%mod) * (pow(k, a-1)%mod))%mod;
	}

}
