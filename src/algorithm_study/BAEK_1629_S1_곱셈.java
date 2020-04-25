package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1629_S1_곱셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		long A = Integer.parseInt(temp.nextToken());
		long B  = Integer.parseInt(temp.nextToken());
		long C  = Integer.parseInt(temp.nextToken());
		System.out.println(power(A%C,B,C));
		power(A%C, B ,C);
	}
	
	static long power(long a, long b, long c) {
		if(b == 1) {
			return a;
		}
		if(b%2 == 0) {
			long k = (power(a, b/2, c) % c);
			return (k * k) % c;
		}else{
			long k = (power(a, b/2, c) % c);
			return (a * ((k * k) % c)) % c;
		}
	}
}
