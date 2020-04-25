package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class JA_1113_119구급대 {
	static int [][] map;
	static int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	static Stack<Point> stack = new Stack<>();
	static int [][] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		
		temp = new StringTokenizer(br.readLine());
		int endpointx = Integer.parseInt(temp.nextToken());
		int endpointy = Integer.parseInt(temp.nextToken());
		
		map = new int [N][M];
		visited = new int [N][M];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = 1000;
			}
			
		}
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		
		DFS(endpointx, endpointy);
		System.out.println(visited[endpointx][endpointy]);		
	}
	
	public static void DFS(int endpointx, int endpointy) {
		for (int i = 0; i < dirs.length; i++) {
			if(isIn(dirs[i][0],dirs[i][1]) && map[dirs[i][0]][dirs[i][1]] == 1) {
				stack.push(new Point(dirs[i][0],dirs[i][1],0,i));
			}
		}
		while(!stack.isEmpty()) {
			Point temp = stack.pop();	
			int count = temp.count;
			if(visited[temp.x][temp.y] >= count) {
				visited[temp.x][temp.y] = count;					
				if(temp.x == endpointx && temp.y == endpointy) {
					min = count;
				}				
				if(count > min) {
					continue;
				}

				int k = 0;
				int dir = temp.dir;
				
				while(true) {					
					int i = temp.x + dirs[k%4][0];
					int j = temp.y + dirs[k%4][1];					
					if(isIn(i,j) && map[i][j] == 1) {
						if(dir != k) {
							stack.push(new Point(i,j,count+1,k));					
						}else {
							stack.push(new Point(i,j,count,k));
						}
					}
					k++;
					if(k == 4) break;
				}
			}			
		}		
	}

	static class Point {
		int x;
		int y;
		int dir;
		int count;
		public Point(int x, int y, int count, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;		
			
		}
		
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<map.length && y<map[0].length;
	}
	
	

}
