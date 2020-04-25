package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2589_G5_보물섬 {
	static int N;
	static int M;
	private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int [][] map;
	static boolean [][] visited;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String temp1 = br.readLine();
			for (int j = 0; j < M; j++) {
				char k = temp1.charAt(j);
				if(k=='L') {
					map[i][j] = 1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {				
				if(map[i][j] == 1) {
					visited = new boolean[N][M];
					Queue<Point> queue = new LinkedList<>();
					queue.add(new Point(i,j,0));
					visited[i][j] = true;
					while(!queue.isEmpty()) {
						Point t = queue.poll();
						int x = t.i;
						int y = t.j;
						int count = t.count;
						if(count > max) {
							max = count;
						}
						for (int k = 0; k < dirs.length; k++) {
							int xx = x+dirs[k][0];
							int yy = y+dirs[k][1];
							if(isIn(xx,yy) && map[xx][yy] == 1) {
								if(!visited[xx][yy]) {
									queue.add(new Point(xx,yy,count+1));
									visited[xx][yy] = true;
								}
							}
						}					
					}
				}
				
			}
		}		
		System.out.println(max);
		

	}
	
	static class Point {
		int i;
		int j;
		int count;

		public Point(int i, int j, int count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}
	}
	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < map.length && j < map[0].length;
	}

}
