package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2583_S1_영역구하기 {
	static int N;
	static int M;
	static boolean [][] map;
	static int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	static int count = 0;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		M = Integer.parseInt(temp.nextToken());
		N = Integer.parseInt(temp.nextToken());
		
		int num = Integer.parseInt(temp.nextToken());
		map = new boolean [N][M];
		for (int i = 0; i < num; i++) {
			temp = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(temp.nextToken());
			int sy = Integer.parseInt(temp.nextToken());
			int ex = Integer.parseInt(temp.nextToken());
			int ey = Integer.parseInt(temp.nextToken());
			for (int j = sx; j < ex; j++) {
				for (int k = sy; k < ey; k++) {
					map[j][k] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!map[i][j]) {
					BFS(i,j);
					count++;
				}
			}
		}
		System.out.println(count);
		list.sort(null);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
	
	static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		map[x][y] = true;
		int sum = 1;
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int xx = t.x + dirs[i][0];
				int yy = t.y + dirs[i][1];
				if(isIn(xx,yy) && !map[xx][yy]) {
					queue.add(new Point(xx,yy));
					map[xx][yy] = true;
					sum++;
				}
			}
		}
		list.add(sum);
	}
	
	static boolean isIn(int x, int y) {	
		return x>=0 && y>=0 && x<N && y<M;		
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
