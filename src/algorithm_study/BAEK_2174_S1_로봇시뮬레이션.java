package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BAEK_2174_S1_로봇시뮬레이션 {
	static int A;
	static int B;
	static boolean[][] map;
	static List<Point> [] list;
	static List<actions> [] action;
	static int[][] dirs = {{1,0},{0,-1},{-1,0},{0,1}}; // 북서남동
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		B = Integer.parseInt(temp.nextToken());
		A = Integer.parseInt(temp.nextToken());
		map = new boolean[A][B];
		temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());		
		int M = Integer.parseInt(temp.nextToken());
		StringBuilder sb = new StringBuilder();
		list = new List[N];
		action = new List[M];
		
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
			temp = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(temp.nextToken())-1;		
			int x = Integer.parseInt(temp.nextToken())-1;
			map[x][y] = true;
			String d = temp.nextToken();
			if(d.equals("N")) {
				list[i].add(new Point(x,y,0));
			}else if(d.equals("W")) {
				list[i].add(new Point(x,y,1));
			}else if(d.equals("S")) {
				list[i].add(new Point(x,y,2));
			}else if(d.equals("E")) {
				list[i].add(new Point(x,y,3));
			}			
		}
		
		
		
		for (int i = 0; i < M; i++) {
			action[i] = new ArrayList<>();
			temp = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(temp.nextToken())-1;
			String dd = temp.nextToken();
			int count = Integer.parseInt(temp.nextToken());
			action[i].add(new actions(k, dd, count));
		}
		
		outer : for (int i = 0; i < M; i++) {
			int k = action[i].get(0).k;
			String dd = action[i].get(0).dd;
			int count = action[i].get(0).count;
			
			for (int j = 0; j < count; j++) {
				int x = list[k].get(0).x;
				int y = list[k].get(0).y;
				map[x][y] = false;
				if(dd.endsWith("L")) {
					list[k].get(0).dir += 1;
					if(list[k].get(0).dir > 3) {
						list[k].get(0).dir = 0;
					}
					continue;
				}else if(dd.endsWith("R")) {
					list[k].get(0).dir -= 1;
					if(list[k].get(0).dir < 0) {
						list[k].get(0).dir = 3;
					}
					continue;
				}	
				int dir = list[k].get(0).dir;
				x += dirs[dir][0];
				y += dirs[dir][1];
				if(!isIn(x, y)) {
					sb.append("Robot " + (k+1) + " crashes into the wall");
					flag = true;
					break outer;
				}else if(map[x][y]) {
					int num = findrobot(x, y);
					sb.append("Robot " + (k+1) + " crashes into robot " + num);
					flag = true;
					break outer;
				}
				map[x][y] = true;
				list[k].get(0).x = x;
				list[k].get(0).y = y;
			}
			
			
		}
		if(flag) {
			System.out.println(sb);
		}else {
			System.out.println("OK");
		}		
	}
	
	static int findrobot(int x, int y) {
		for (int i = 0; i < list.length; i++) {
			if (list[i].get(0).x == x && list[i].get(0).y == y) {
				return i+1;
			}
		}
		return 1;
	}
	
	static class Point {
		int x;
		int y;
		int dir;

		public Point(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	
	static class actions {
		int k;
		String dd;
		int count;
		
		public actions(int k, String dd, int count) {
			super();
			this.k = k;
			this.dd = dd;
			this.count = count;
		}
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < A && y < B;
	}
}
