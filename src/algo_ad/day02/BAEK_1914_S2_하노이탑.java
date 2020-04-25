package algo_ad.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEK_1914_S2_하노이탑 {
	private static int N, CNT;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());

		solve(N,1,2,3);
		sb.insert(0, CNT+"\n");
		System.out.println(sb);
	}
	public static void solve(int n, int x, int y, int z) {
		if(n==0) {
			return;
		}else {
			// 마지막꺼 위의 원판들을 치워놓음
			solve(n-1,x,z,y);
			// 마지막 원판의 이동
			sb.append(x).append(" ").append(z).append("\n");
			CNT++;
			// 나머지 원판들을 다시 z로 이동
			solve(n-1,y,x,z);
		}
	}
	
	private static int src = 3;
}
