package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1005_G3_ACMCraft {
	static int [] times;
	static int [] dp;
	static int [] fanIn;
	static int N, K, L;
	static List<Integer> [] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		outer : 
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			K = Integer.parseInt(temp.nextToken());
			
			times = new int [N];
			dp = new int [N];
			fanIn = new int [N];
			temp = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				times[i] = Integer.parseInt(temp.nextToken());
			}
			
			list = new List [N];
			for (int i = 0; i < N; i++) {
				list[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < K; i++) {
				temp = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(temp.nextToken()) - 1;
				int b = Integer.parseInt(temp.nextToken()) - 1;
				list[a].add(b);
				fanIn[b]++;
			}			
			L = Integer.parseInt(br.readLine()) - 1;
			
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				if(fanIn[i] == 0) {
					if(i == L) {
						sb.append(times[i]).append("\n");
						continue outer;
					}
					q.add(i);
					dp[i] = times[i];
				}
			}
			
			outer2 :
			while(!q.isEmpty()) {
				int x = q.poll();
				for (int next : list[x]) {
					fanIn[next]--;
					dp[next] = Math.max(dp[next], dp[x] + times[next]);
					if(fanIn[next] == 0) {
						if(next == L) {
							sb.append(dp[L]).append("\n");
							break outer2;
						}
						q.add(next);
					}
				}
			}			
		}
		System.out.println(sb);
	}
}
