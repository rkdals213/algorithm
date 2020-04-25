package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_9659_D4_다항식계산 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(temp.nextToken());
		StringBuilder sb = new StringBuilder();
		long key = 998244353;
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			temp = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(temp.nextToken());
			List<Point> list = new ArrayList<>();
			for (int j = 0; j < N-1; j++) {
				temp = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(temp.nextToken()),Integer.parseInt(temp.nextToken()),Integer.parseInt(temp.nextToken())));
			}
			temp = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(temp.nextToken());
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				long [] memo = new long [N+1];
				memo[0] = 1;
				memo[1] = Long.parseLong(temp.nextToken()) % key;
				for (int k = 0; k < list.size(); k++) {
					int t = list.get(k).t;
					int a = list.get(k).a;
					int b = list.get(k).b;
					if(t == 1) {
						memo[k+2] = (memo[a] + memo[b]) % key;
					}else if(t == 2) {
						memo[k+2] = (a * memo[b])%key;
					}else if(t == 3) {
						memo[k+2] = (memo[a] * memo[b])%key;
					}
				}
				sb.append(memo[N]).append(" ");
			}
			sb.append("\n");
			
			
		}
		System.out.println(sb);

	}
	
	static class Point {
		int t;
		int a;
		int b;
		public Point(int t, int a, int b) {
			super();
			this.t = t;
			this.a = a;
			this.b = b;
		}


	}

}
