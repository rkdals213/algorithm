package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BAEK_3190_S1_뱀 {
	static int N;
	static int [][] map;
	static int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
	static Deque<Point> deque = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		map = new int [N][N];
		int sx = 0;
		int sy = 0;
		temp = new StringTokenizer(br.readLine());
		int apple = Integer.parseInt(temp.nextToken());
		for (int i = 0; i < apple; i++) {
			temp = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(temp.nextToken())-1;
			int y = Integer.parseInt(temp.nextToken())-1;
			map[x][y] = 2;
		}
		temp = new StringTokenizer(br.readLine());
		int nowd = 0;
		int result = 0;
		int t = 0;
		int turn = Integer.parseInt(temp.nextToken());
		deque.add(new Point(0,0));
		map[0][0] = 1;
		for (int i = 0; i < turn; i++) {
			temp = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(temp.nextToken());
			String d = temp.nextToken();
			for (int j = 0; j < time-t; j++) {
				sx += dirs[nowd][0];
				sy += dirs[nowd][1];
				result++;
				if(!isIn(sx, sy)) {
					System.out.println(result);
					return;
				}else if(isIn(sx, sy) && map[sx][sy] == 2) {
					deque.add(new Point(sx,sy));
					map[sx][sy] = 1;
				}else if(isIn(sx, sy) && map[sx][sy] == 0) {
					deque.add(new Point(sx,sy));
					map[sx][sy] = 1;
					Point last = deque.poll();
					map[last.x][last.y] = 0;
				}else if(isIn(sx, sy) && map[sx][sy] == 1) {
					System.out.println(result);
					return;
				}
			}
			if(d.equals("L")) {
				nowd--;
				if(nowd < 0) {
					nowd = 3;
				}
			}
			else if(d.equals("D")) {
				nowd++;
				if(nowd > 3) {
					nowd = 0;
				}
			}
			t = result;			
		}
		while (true) {
			sx += dirs[nowd][0];
			sy += dirs[nowd][1];
			result++;
			if(!isIn(sx, sy)) {
				break;
			}else if(isIn(sx, sy) && map[sx][sy] == 2) {
				deque.add(new Point(sx,sy));
				map[sx][sy] = 1;
			}else if(isIn(sx, sy) && map[sx][sy] == 0) {
				deque.add(new Point(sx,sy));
				map[sx][sy] = 1;
				Point last = deque.poll();
				map[last.x][last.y] = 0;
			}else if(isIn(sx, sy) && map[sx][sy] == 1) {
				break;
			}
		}
		System.out.println(result);
	}
	static boolean isIn(int x, int y) {	
		return x>=0 && y>=0 && x<N && y<N;		
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}		
	}
}
