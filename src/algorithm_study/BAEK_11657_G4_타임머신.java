package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_11657_G4_타임머신 {
	static int N,M;
	static List<Point> [] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		list = new List [N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();

		}
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int s =  Integer.parseInt(temp.nextToken())-1;
			int e =  Integer.parseInt(temp.nextToken())-1;
			int v =  Integer.parseInt(temp.nextToken());
			boolean flag = true;
			for (int j = 0; j < list[s].size(); j++) {
				if(list[s].get(j).target == e) {
					list[s].get(j).value = Math.min(list[s].get(j).value, v);
					flag = false;
					break;
				}
			}
			if(flag) {
				list[s].add(new Point(e, v));
			}

		}

		int [] dp = new int [N];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}


		outer:for (int j = 0; j <= N; j++) {	
			if(j==N) {
				System.out.println(-1);
				return;
			}	
			int flag = 0;
			for (int i = 0; i < N; i++) {
				for (int k = 0; k < list[i].size(); k++) {					
					int s = i;
					int e = list[i].get(k).target;
					int v = list[i].get(k).value;

					if(dp[s] != Integer.MAX_VALUE) {
						if(dp[s] + v < dp[e]) {
							dp[e] = dp[s] + v;
							flag++;
						}
					}
				}
			}

			if(flag==0) {
				for (int l = 1; l < N; l++) {
					if(dp[l] == Integer.MAX_VALUE) {
						System.out.println(-1);
					}else {
						System.out.println(dp[l]);
					}
				}
				break outer;
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
