package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2206_G4_벽부수고이동하기 {
	static int N,M;
	static char [][] map;
	private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static boolean [][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new char [N][M];
		String t;
		visited = new boolean [N][M][2];
		for (int i = 0; i < N; i++) {
			t = br.readLine();
			map[i] = t.toCharArray();
		}
		
		System.out.println(BFS());

	}
	
	static int BFS() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0,0,0));
		visited[0][0][0] = true;
		visited[0][0][1] = true;
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			if(t.i == N-1 && t.j == M-1) {
				return t.count+1;
			}
			for (int i = 0; i < dirs.length; i++) {
				int x = t.i+dirs[i][0];
				int y = t.j+dirs[i][1];
				if(isIn(x, y)) {					
					if(t.broke == 0) {
						if(!visited[x][y][0] && map[x][y] == '0') {
							queue.add(new Point(x,y,t.count+1,t.broke));
							visited[x][y][0] = true;
						}else if(!visited[x][y][1] && map[x][y] == '1') {
							queue.add(new Point(x,y,t.count+1,t.broke+1));
							visited[x][y][1] = true;
						}
					}else if(t.broke == 1){
						if(!visited[x][y][1] && map[x][y] == '0') {
							queue.add(new Point(x,y,t.count+1,t.broke));
							visited[x][y][1] = true;
						}
					}
				}
			}
		}
		return -1;
	}
	
	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < M;
	}
	
	static class Point {
		int i;
		int j;
		int count;
		int broke;

		public Point(int i, int j, int count, int broke) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
			this.broke = broke;
		}
	}
}
