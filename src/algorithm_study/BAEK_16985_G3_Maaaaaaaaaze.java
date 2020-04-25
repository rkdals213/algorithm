package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_16985_G3_Maaaaaaaaaze {
	static int result = Integer.MAX_VALUE;
	static int [][][] map = new int[5][5][5]; // z,x,y
	static int [][][] permap = new int [5][5][5];
	static int [][][] rotatemap = new int [5][5][5];
	static boolean [][][] visited = new boolean [5][5][5];
	static int[][] dirs = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, -1, 0 }, { 0, 0, -1 }, {1, 0, 0}, {-1, 0, 0}};
	// x,y,z
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				temp = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					map[i][j][k] = Integer.parseInt(temp.nextToken());
				}
			}
		}
		makerotate(0, new int [5]);
		
		if(result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}

	}
	static void makerotate(int cur, int [] result) { // 블록을 회선시키는 순열
		if(cur == 5) {
			for (int a = 0; a < 5; a++) {
				if(result[a] == 0) { // 0도 회전
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							rotatemap[a][i][j] = map[a][i][j];
						}
					}
				}else if(result[a] == 1) { // 우측 90도
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							rotatemap[a][i][j] = map[a][4-j][i];
						}
					}
				}else if(result[a] == 2) { // 우측 270도
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							rotatemap[a][i][j] = map[a][j][4-i];
						}
					}
				}
				else if(result[a] == 3) { // 우측 180도
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							rotatemap[a][i][j] = map[a][4-i][4-j];
						}
					}
				}
			}
			makePer(0, new int [5], new boolean [5]);
		}else {
			for (int i = 0; i < 4; i++) {
				result[cur] = i;
				makerotate(cur+1, result);

			}
		}
	}
	
	static void makePer(int cur, int [] result, boolean [] visited) { // 블록 쌓는 순서 순열
		if(cur == 5) {
			for (int a = 0; a < 5; a++) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						permap[a][i][j] = rotatemap[result[a]][i][j];
					}
				}
			}
			BFS(0,0);
		}else {
			for (int i = 0; i < 5; i++) {
				if(!visited[i]) {
					visited[i] = true;
					result[cur] = i;
					makePer(cur+1, result, visited);
					visited[i] = false;
				}
			}
		}
	}

	static void BFS(int q, int w) {
		Queue<Point> queue = new LinkedList<>();
		if(permap[0][q][w] != 1) {
			return;
		}
		queue.add(new Point(q,w,0,0));
		visited = new boolean [5][5][5];
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			if(t.count > result) {
				return;
			}
			
			for (int i = 0; i < dirs.length; i++) {
				int x = t.x + dirs[i][0];
				int y = t.y + dirs[i][1];
				int z = t.z + dirs[i][2];
				if(t.x == 4 && t.y == 4 && t.z == 4) {
					result = Math.min(result, t.count);				
					return;
				}
				if(isIn(z,x,y) && permap[z][x][y] != 0 && !visited[z][x][y]) {
					queue.add(new Point(x,y,z,t.count+1));
					visited[z][x][y] = true;
				}
			}
		}
	}

	static boolean isIn(int x, int y, int z) {
		return x >= 0 && y >= 0 && z>=0 && x < 5 && y < 5 && z<5;
	}
	static class Point {
		int x;
		int y;
		int z;
		int count;

		public Point(int x, int y, int z, int count) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.count = count;
		}
	}
}
