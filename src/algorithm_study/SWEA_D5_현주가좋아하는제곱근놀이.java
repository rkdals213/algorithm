package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SWEA_D5_현주가좋아하는제곱근놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			long N = Long.parseLong(br.readLine());
			int result = 0;
			sb.append("#").append(i+1).append(" ");
			while(N!=2) {
				long k = (long)Math.sqrt(N);
				if(k*k == N) {
					result++;
					N = k;
				}else {
					k++;
					result += (k*k) - N + 1;
					N = k;
				}
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);

	}

}
