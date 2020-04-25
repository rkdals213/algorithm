package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_Professional조합 {
	static final long key = 1234567891;
	static long [] fact = new long [1000001];
	static long [] pow = new long [1000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long TC = Long.parseLong(temp.nextToken());
		fact[0] = 1;
		pow[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = (fact[i-1] * i) % key;
			pow[i] = power(fact[i], key-2);
		}
		for (long i = 0; i < TC; i++) {
			sb.append("#" + (i+1) + " ");
			temp = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(temp.nextToken());
			int K = Integer.parseInt(temp.nextToken());
			long result = (((fact[N] * pow[K])%key) * pow[N-K])%key;
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
	
	static long power(long N, long k) {
		long result = 1;
		while(k > 0) {
			if(k%2 == 1) {
				result *= N;
				result %= key;
			}
			N *= N;
			N %= key;
			k /= 2;
		}
		return result;
		
	}
	
}
