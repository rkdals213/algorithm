package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_14868_P4_문명 {
	static int N;
	static int K;
	static int[][] map;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int [] root;
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> queue2 = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		K = Integer.parseInt(temp.nextToken());
		map = new int[N][N];
		root = new int [K+1];
		for (int i = 0; i < K; i++) {
			temp = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(temp.nextToken())-1;
			int y = Integer.parseInt(temp.nextToken())-1;
			map[x][y] = i+1;
			queue.add(new Point(x,y));
		}
		for (int j = 0; j < K+1; j++) {
			root[j] = j;
		}
		int year = 0;
		while(true) {
			while(!queue.isEmpty()) {
				Point t = queue.poll();
				queue2.add(t);
				for (int i = 0; i < dirs.length; i++) {
					int xx = t.x+dirs[i][0];
					int yy = t.y+dirs[i][1];
					if(isIn(xx,yy)) {
						if(map[xx][yy] != 0 && map[xx][yy] != map[t.x][t.y]) {
							if(union(map[xx][yy], map[t.x][t.y])) {
								K--;
							}
						}						
					}
				}
			}
			if(K == 1) {
				break;
			}
			while(!queue2.isEmpty()) {
				Point t = queue2.poll();
				for (int i = 0; i < dirs.length; i++) {
					int xx = t.x+dirs[i][0];
					int yy = t.y+dirs[i][1];
					if(isIn(xx,yy)) {
						if(map[xx][yy] == 0) {
							map[xx][yy] = map[t.x][t.y];
							queue.add(new Point(xx,yy));
						}else if(union(map[xx][yy], map[t.x][t.y])) {
							K--;
						}	
					}
				}
			}
			year++;
		}
		System.out.println(year);

	}

	static int find(int n) {
		if(root[n] == n) return n;
		return root[n] = find(root[n]);
	}

	static boolean union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);

		if(roota != rootb) {
			root[rootb] = roota;			
			return true;
		}
		return false;
	}


	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}