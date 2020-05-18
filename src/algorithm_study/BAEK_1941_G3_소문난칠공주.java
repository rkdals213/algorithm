package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BAEK_1941_G3_소문난칠공주 {
	static final int N = 5;
	static char [][] map;
	static boolean [][] visited;
	static int [][] dir4 = {{1,0},{0,1},{-1,0},{0,-1}};
	static int res = 0;
	public static void main(String[] args) throws IOException {
		map = new char [N][N];
		visited = new boolean [N][N];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			map[i] = temp.toCharArray();
		}
		combi(0, new int [7], 0, 0);
		System.out.println(res);
	}
	
	static void combi(int r, int [] result, int cnt, int start) {
		if(r == 7) {		
			if(check(result)) {
				res++;
			}
		}else {
			for (int i = start; i < 25; i++) {
				if(map[i/5][i%5] == 'Y' && cnt == 3) continue;
				if(!visited[i/5][i%5]) {
					result[r] = i;
					visited[i/5][i%5] = true;					
					if(map[i/5][i%5] == 'Y') combi(r+1, result, cnt+1, i);
					else combi(r+1, result, cnt, i);
					visited[i/5][i%5] = false;
				}				
			}
		}
	}
	

	static boolean check(int[] result) {
		boolean [][] v = new boolean [N][N];
		for (int i = 1; i < 7; i++) {
			v[result[i]/5][result[i]%5] = true;
		}
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(result[0]/5, result[0]%5));
		int cnt = 0;
		while(!q.isEmpty()) {
			Point t = q.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int x = t.x + dir4[i][0];
				int y = t.y + dir4[i][1];
				if(isIn(x, y) && v[x][y]) {
					v[x][y] = false;
					q.add(new Point(x,y));
				}
			}
		}
		return cnt==7;
	}

	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}
	
	static class Point{
		int x,y;

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
