package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_17070_G5_파이프옮기기{
	static int N;
	static int [][] map;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		DFS(new Point(0,1,0));

		System.out.println(count);
		
	}
	
	static void DFS(Point p) {
		if(p.i == N-1 && p.j == N-1) {
			count++;
			return;
		}else {
			int x = p.i;
			int y = p.j;
			int dir = p.d;
			if(dir == 0) {
				if(isIn(x+1,y+1) && map[x+1][y+1] != 1 && map[x+1][y] != 1 && map[x][y+1] != 1) {
					DFS(new Point(x+1,y+1,1));
				}
				if(isIn(x,y+1) && map[x][y+1] != 1) {
					DFS(new Point(x,y+1,0));
				}
			}else if(dir == 1) {
				if(isIn(x+1,y+1) && map[x+1][y+1] != 1 && map[x+1][y] != 1 && map[x][y+1] != 1) {
					DFS(new Point(x+1,y+1,1));
				}
				if(isIn(x,y+1) && map[x][y+1] != 1) {
					DFS(new Point(x,y+1,0));
				}
				if(isIn(x+1,y) && map[x+1][y] != 1) {
					DFS(new Point(x+1,y,2));
				}				
			}else if(dir == 2) {
				if(isIn(x+1,y+1) && map[x+1][y+1] != 1 && map[x+1][y] != 1 && map[x][y+1] != 1) {
					DFS(new Point(x+1,y+1,1));
				}
				if(isIn(x+1,y) && map[x+1][y] != 1) {
					DFS(new Point(x+1,y,2));
				}
			}
		}
	}
	
	private static boolean isIn(int i, int j) {
		return i >= 0 && j >= 0 && i < map.length && j < map[0].length;
	}
	
	static class Point {
		int i;
		int j;
		int d;

		public Point(int i, int j, int d) {
			super();
			this.i = i;
			this.j = j;
			this.d = d;
		}

	}
	

}
