package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17135_G4_캐슬디펜스 {
	static ArrayList<int []> soldier = new ArrayList<int []>();
	static int [][] map;
	static int [][] map1;
	static int [][] dirs = {{0,-1},{-1,0},{0,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		int range = Integer.parseInt(temp.nextToken());
		map = new int [N+1][M];
		map1 = new int [N+1][M];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
			map1[i] = map[i].clone();
		}
		int max = Integer.MIN_VALUE;
		makeBatch(3, new int[M], 0, 0);
		
		for (int k = 0; k < soldier.size(); k++) {
			for (int i = 0; i < map1[0].length; i++) {
				map1[map1.length-1][i] = 2;
			}
			for (int i = 0; i < map.length; i++) {
				map[i] = map1[i].clone();
			}
			int sum = 0;
			outer: while(true) {				
				for (int i = 0; i < map[0].length; i++) {
					if(map[map.length-1][i] == 1) {
						map[map.length-1][i] = 0;
					}
				}
				int f = 0;
				for (int i = 0; i < map.length-1; i++) {
					for (int j = 0; j < map[0].length; j++) {
						f += map[i][j];
					}
				}
				if(f == 0) break outer;
				
				sum += BFS(soldier.get(k), range);	
				move();
			}		
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
		
	}
	
	static void move() {
		for (int i = map.length-2; i > 0; i--) {
			map[i] = map[i-1].clone();
		}
		map[0] = new int[map[0].length];
	}
	
	static int BFS(int [] soldier, int range) {
		Queue<Point> queue = new LinkedList<>();
		int sum = 0;
		int [][] mapcopy = new int [map.length][map[0].length]; 
		for (int l = 0; l < 3; l++) {
			queue.add(new Point(map.length-1, soldier[l], 1));
			
			while(!queue.isEmpty()) {
				Point temp = queue.poll();
				int count = temp.count;
				for (int i = 0; i < dirs.length; i++) {
					int xx = temp.x+dirs[i][0];
					int yy = temp.y+dirs[i][1];
					if(isIn(xx,yy) && map[xx][yy] == 1) {
						mapcopy[xx][yy] = 1;
						queue.clear();
						break;
					}else if(isIn(xx,yy) && map[xx][yy] == 0) {
						if(count < range) {
							queue.add(new Point(xx,yy,count+1));
						}					
					}
				}
			}			
		}
		for (int i = 0; i < mapcopy.length; i++) {
			for (int j = 0; j < mapcopy[0].length; j++) {
				if(mapcopy[i][j] == 1) {
					map[i][j] = 0;
					sum++;
				}
			}
		}
	
		return sum;
	}
	
	static void makeBatch(int M, int [] result, int current, int start) {
		if(M == current) {
			soldier.add(result.clone());
			return;
		}else {
			for (int i = start; i < result.length; i++) {
				result[current] = i;
				makeBatch(M, result, current+1, i+1);
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && y<map[0].length;
	}
	
	static class Point {
		int x;
		int y;
		int count;
		public Point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}		
	}

}
