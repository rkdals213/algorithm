package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_14502_G5_연구소 {
	private static int [][] map;
	private static int [][] mapcopy;
	private static boolean [][] visited;
	private static int max = Integer.MIN_VALUE;
	private static int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	
	
	
	private static void dfs(int depth) {
		if(depth == 3) {		
			
			for (int i = 0; i < map.length; i++) {
				mapcopy[i] = Arrays.copyOf(map[i],map[i].length);
			}	
			
			coronaVirus();			
			
		}else {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if(map[i][j] == 0) {
						map[i][j] = 1;
						dfs(depth+1);
						map[i][j] = 0;
					}
				}
			}
		}
	}
	
	private static void coronaVirus() {
		Queue<Point> queue = new LinkedList<>();
		visited = new boolean [map.length][map[0].length];

		for (int i = 0; i < mapcopy.length; i++) {
			for (int j = 0; j < mapcopy[i].length; j++) {
				if(mapcopy[i][j] == 2) {
					queue.add(new Point(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point top = queue.poll();
			mapcopy[top.i][top.j] = 2;
			for (int i = 0; i < dirs.length; i++) {
				int x = top.i + dirs[i][0];
				int y = top.j + dirs[i][1];
				if(isIn(x,y) && mapcopy[x][y] == 0) {
					if(!visited[x][y]) {
						queue.add(new Point(x,y));
						visited[x][y] = true;
					}
				}
			}
		}		
		findSafty();
	}
	
	private static void findSafty() {		
		int count = 0;
		for (int i = 0; i < mapcopy.length; i++) {
			for (int j = 0; j < mapcopy[i].length; j++) {
				if(mapcopy[i][j] == 0) {
					count ++; 
				}
			} 
		}
		if(count > max) max = count;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		
		map = new int [N][M];		
		mapcopy = new int [N][M];
		
		
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}		
	
		dfs(0);		
		coronaVirus();
		System.out.println(max);
		
	}
	
	static class Point{
		int i;
		int j;
		
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}		
	}
	
	private static boolean isIn(int i, int j) {
		return i>=0 && j>=0 && i<map.length && j<map[0].length;
	}

}
