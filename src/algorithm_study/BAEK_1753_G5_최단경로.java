package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_1753_G5_최단경로 {
	static int N,M;
	static List<Point> [] list;
	static PriorityQueue<Point> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		list = new List [N+1];

		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();

		}
		int start = Integer.parseInt(br.readLine())-1;
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int s =  Integer.parseInt(temp.nextToken())-1;
			int e =  Integer.parseInt(temp.nextToken())-1;
			int v =  Integer.parseInt(temp.nextToken());

			list[s].add(new Point(e, v));
		}

		int [][] dp = new int [2][N];

		for (int i = 0; i < N; i++) {
			dp[0][i] = Integer.MAX_VALUE;
			dp[1][i] = -1;
		}
		dp[0][start] = 0;
		dp[1][start] = start;
		queue.add(new Point(start, 0));
		while(!queue.isEmpty()) {
			Point tmp = queue.poll();
			int k = tmp.target;
			for (int j = 0; j < list[k].size(); j++) {
				int v = list[k].get(j).value;
				int t = list[k].get(j).target;
				if(dp[0][t] > dp[0][k] + v) {
					dp[0][t] = dp[0][k] + v;
					dp[1][t] = k;
					queue.add(new Point(t, dp[0][t]));
				}				
			}
		}

		for (int i = 0; i < N; i++) {
			if(dp[1][i] != -1) {
				System.out.println(dp[0][i]);
			}else {
				System.out.println("INF");
			}
		}

	}	


	static class Point implements Comparable<Point> {
		int target;		
		int value;
		public Point(int target, int value) {
			super();
			this.target = target;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Point [target=" + target + ", value=" + value + "]";
		}
		@Override
		public int compareTo(Point o) {
			Integer a = this.value;
			Integer b = o.value;
			return a.compareTo(b);
		}
	}
}