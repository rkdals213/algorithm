package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_9376_P5_탈옥 {
	static int N,M;
	static char [][] map;
	static int count = 0;
	static PriorityQueue<Point> queue = new PriorityQueue<>();
	static List<Point> list;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int [][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			M = Integer.parseInt(temp.nextToken());
			list = new ArrayList<>();
			map = new char[N+2][M+2];
			visited = new int[N+2][M+2][3];
			for (int j = 0; j < N+2; j++) {
				for (int j2 = 0; j2 < M+2; j2++) {
					for (int k = 0; k < 3; k++) {
						visited[j][j2][k] = -1;
					}
				}
			}
			for (int j = 0; j < N+2; j++) {				
				for (int k = 0; k < M+2; k++) {
					map[j][k] = '.';
				}
			}
			for (int j = 1; j < N+1; j++) {
				String t = br.readLine();
				for (int k = 1; k < M+1; k++) {
					map[j][k] = t.charAt(k-1);
				}
			}
			
			findprisoner();
			for (int j = 0; j < list.size(); j++) {
				BFS(list.get(j).i,list.get(j).j,j+1);
			}
			BFS(0,0,0);
			int sum = Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				for (int k = 1; k < M+1; k++) {
					if(map[j][k]!='*') {
						if(map[j][k]=='#') {
							sum = Math.min(sum, visited[j][k][0]+visited[j][k][1]+visited[j][k][2]-2);
						}else {
							sum = Math.min(sum, visited[j][k][0]+visited[j][k][1]+visited[j][k][2]);
						}
						
					}					
				}
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);

	}
	
	static void findprisoner() {
		int num = 0;
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < M+2; j++) {
				if(map[i][j] == '$') {
					list.add(new Point(i,j,0));
					num++;
					if(num == 2) return;
				}
			}
		}
	}
	static void BFS(int a, int b, int c) {
		queue.add(new Point(a,b,0));
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int x = t.i + dirs[i][0];
				int y = t.j + dirs[i][1];
				if(isIn(x, y) && visited[x][y][c] == -1 && map[x][y] != '*') {
					if(map[x][y] == '#') {
						visited[x][y][c] = t.count+1;
						queue.add(new Point(x,y,t.count+1));
					}else {
						visited[x][y][c] = t.count;
						queue.add(new Point(x,y,t.count));
					}
				}
			}
		}
	}
	
	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < N+2 && j < M+2;
	}
	
	static class Point implements Comparable<Point>{
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
			return "Point [i=" + i + ", j=" + j + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Point o) {
			Integer a1 = this.count;
			Integer a2 = o.count;
			return a1.compareTo(a2);
		}
		
	}

}
