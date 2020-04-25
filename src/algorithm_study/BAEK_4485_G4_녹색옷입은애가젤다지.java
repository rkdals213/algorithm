package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_4485_G4_녹색옷입은애가젤다지 {
	static int N;
	static int [][] cave;
	static int [][] D;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while(true) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			if(N==0) break;
			cave = new int [N][N];
			D = new int [N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(D[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < N; i++) {
				temp = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cave[i][j] = Integer.parseInt(temp.nextToken());
				}
			}
			D[0][0] = cave[0][0];
			PriorityQueue<Point> pq = new PriorityQueue<>();

			pq.add(new Point(0,0,cave[0][0]));		
			while(!pq.isEmpty()) {
				Point s = pq.poll();
				for (int i = 0; i < dirs.length; i++) {
					int x = s.i + dirs[i][0];
					int y = s.j + dirs[i][1];
					if(isIn(x, y)) {
						if(D[x][y] > s.v + cave[x][y]) {
							D[x][y] = D[s.i][s.j] + cave[x][y];
							pq.add(new Point(x,y,D[x][y]));								
						}
					}
				}
			}
			
			sb.append("Problem " + cnt + ": " + D[N-1][N-1] + "\n");
			cnt++;			
		}
		System.out.println(sb);
	}

	static class Point implements Comparable<Point>{
		int i;
		int j;
		int v;
		public Point(int i, int j, int v) {
			super();
			this.i = i;
			this.j = j;
			this.v = v;
		}
		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + ", v=" + v + "]";
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.v, o.v);
		}
	}

	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N;
	}

}
