package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_17142_G4_연구소3 {
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N;
	static int M;
	static int [][] map;
	static boolean [][] mapcopy;
	static List<Point> list = new ArrayList<>();
	static Queue<Point> queue = new LinkedList<>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int [N][N];
		mapcopy = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		findVirus();
		virusComb(0, new Point [M], 0);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	private static void BFS() {
		int check = 0;
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			int count = temp.count;
			if(count >= check) {
				check = count;
			}
			for (int i = 0; i < dirs.length; i++) {
				int xx = x+dirs[i][0];
				int yy = y+dirs[i][1];
				if(isIn(xx,yy) && map[xx][yy] == 0 && !mapcopy[xx][yy]) {
					queue.add(new Point(xx,yy,count+1));
					mapcopy[xx][yy] = true;
				}else if(isIn(xx,yy) && map[xx][yy] == 2 && !mapcopy[xx][yy]) {
					boolean flag = false;
					outer1 : for (int j = 0; j < N; j++) {
						for (int j2 = 0; j2 < N; j2++) {
							if(map[j][j2] == 0 && !mapcopy[j][j2]) {
								flag = true;
								break outer1;
							}
						}
					}
					if(flag) {
						queue.add(new Point(xx,yy,count+1));
						mapcopy[xx][yy] = true;
					}else {
						queue.add(new Point(xx,yy,count));
						mapcopy[xx][yy] = true;
					}
				}
			}
		}
		outer: for (int i = 0; i < mapcopy.length; i++) {
			for (int j = 0; j < mapcopy.length; j++) {
				if(!mapcopy[i][j]) {
					check = Integer.MAX_VALUE;
					break outer;
				}
			}
		}
		if(check < min) {
			min = check;
		}		
	}

	private static void virusComb(int count, Point [] p, int start) {
		if(count == M) {
			mapcopy = new boolean[N][N];
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == 1) {
						mapcopy[i][j] = true;
					}
				}				
			}
			for (int i = 0; i < p.length; i++) {
				mapcopy[p[i].x][p[i].y] = true;
				queue.add(p[i]);				
			}	
			BFS();
		}else {
			for (int i = start; i < list.size(); i++) {
				p[count] = list.get(i);
				virusComb(count+1, p, i+1);
			}
		}
	}

	private static void findVirus() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					list.add(new Point(i,j,0));
				}
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
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
