package algo_basic.day09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_2667_S1_단지번호붙이기 {
	private static int [][] map;
	private static int [][] visited;
	private static int [][] dirs = {{1,0},{-1,0},{0,-1},{0,1}}; 
	
	public static void main(String[] args)  {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		map = new int[N][N];
		visited = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = s.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j)-'0';
			}
		}		
		
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {	
					count++;
					BFS(new Point(i,j,count));					
				}
			}
		}
		
		int [] result = new int [count+1];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(visited[i][j] != 0) {
					result[visited[i][j]]++;
				}
			}
		}
		
		System.out.println(count);
		Arrays.sort(result);
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
			
		}		
	}
	
	private static void BFS(Point p) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(p);
		
		while(!queue.isEmpty()) {
			Point top = queue.poll();
			visited[top.i][top.j] = top.count;
			for (int i = 0; i < dirs.length; i++) {
				int x = top.i + dirs[i][0];
				int y = top.j + dirs[i][1];
				if(isIn(x,y) && map[x][y] == 1) {
					if(visited[x][y] == 0) {
						queue.add(new Point(x,y,top.count));
						visited[x][y] = top.count;
					}
				}
			}
		}
	}
	
	private static boolean isIn(int i, int j) {
		return i>=0 && j>=0 && i<map.length && j<map[0].length;
	}
	
	static class Point{
		int i;
		int j;
		int count;
		public Point(int i, int j, int count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}		
	}
}
