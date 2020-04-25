package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BAEK_13460_G3_구슬탈출2{
	static int N;
	static int M;
	static int result = -1;
	static char [][] map;
	static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // 하 우 상 좌
	static boolean rf = false;
	static boolean bf = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new char [N][M];
		
		for (int i = 0; i < N; i++) {
			String temp2 = br.readLine();
			map[i] = temp2.toCharArray();
		}
		
		Point balls = findTwo();
		
		BFS(balls);
		
		System.out.println(result);
		
	}
	
	static void BFS(Point balls) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(balls);
		while(!queue.isEmpty()) {
			Point t = queue.poll();		
			if(t.count > 10) {
				break;
			}
			for (int i = t.dir+1; i < t.dir+5; i++) {
				if(map[t.rx+dirs[i%4][0]][t.ry+dirs[i%4][1]] != '#' || map[t.bx+dirs[i%4][0]][t.by+dirs[i%4][1]] != '#') {
					Point aftermove = move(t, i%4);
					if(rf && !bf) {
						result = t.count;
						return;
					}else if(rf && bf) {
						result = -1;
						rf = false;
						bf = false;
						continue;
					}else if(!rf && bf) {
						result = -1;
						rf = false;
						bf = false;
						continue;
					}
					queue.add(aftermove);
				}				
			}			
		}
	}
	 
	static Point move(Point t, int i) {
		int rx = t.rx;
		int ry = t.ry;
		int bx = t.bx;
		int by = t.by;
		int count = t.count;
		if(r_first(t, i)) {
			
			while(map[rx+dirs[i][0]][ry+dirs[i][1]] != '#') {
				rx += dirs[i][0];
				ry += dirs[i][1];				
				if(map[rx][ry] == 'O') {
					rx = 0;
					ry = 0;
					rf = true;
					break;
				}
			}
			
			
			while(map[bx+dirs[i][0]][by+dirs[i][1]] != '#' && (bx+dirs[i][0] != rx || by+dirs[i][1] != ry)) {
				bx += dirs[i][0];
				by += dirs[i][1];
				if(map[bx][by] == 'O') {
					bx = 0;
					by = 0;
					bf = true;
					break;
				}
			}
			
		}else {
			
			while(map[bx+dirs[i][0]][by+dirs[i][1]] != '#') {
				bx += dirs[i][0];
				by += dirs[i][1];
				if(map[bx][by] == 'O') {
					bx = 0;
					by = 0;
					bf = true;
					break;
				}
			}
			
			
			while(map[rx+dirs[i][0]][ry+dirs[i][1]] != '#' && (rx+dirs[i][0] != bx || ry+dirs[i][1] != by)) {
				rx += dirs[i][0];
				ry += dirs[i][1];
				if(map[rx][ry] == 'O') {
					rx = 0;
					ry = 0;
					rf = true;
					break;
				}
			}
			
		}
		return new Point(rx,ry,bx,by,count+1,i);
		
	}
	
	static boolean r_first(Point t, int i) {
		if(i == 0) {
			if(t.rx > t.bx)return true;
			else return false;
		}else if(i == 1) {
			if(t.ry > t.by)return true;
			else return false;
		}else if(i == 2) {
			if(t.rx < t.bx)return true;
			else return false;
		}else {
			if(t.ry < t.by)return true;
			else return false;
		} 
	}
	
	
	static Point findTwo() {
		int rx = 0;
		int ry = 0;
		int bx = 0; 
		int by = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}
			}
		}
		return new Point(rx, ry, bx, by, 1, -1);
	}
	
	
	static class Point {
		int rx;
		int ry;
		int bx;
		int by;
		int count;
		int dir;
		
		public Point(int rx, int ry, int bx, int by, int count, int dir) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.count = count;
			this.dir = dir;
		}
		
		
	}
}
