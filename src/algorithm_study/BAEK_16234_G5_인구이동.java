package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BAEK_16234_G5_인구이동 {
	static int N;
	static int low;
	static int high;
	static int [][] map;
	static int [][] mapcopy;
	static boolean [][] visited;
	static int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	static int count = -1;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		low = Integer.parseInt(temp.nextToken());
		high = Integer.parseInt(temp.nextToken());
		map = new int [N][N];
		mapcopy = new int [N][N];
	
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		while(!flag) {
			count++;
			visited = new boolean [N][N];
			flag = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						BFS(i,j);
					}
				}
			}			
		}
	
		System.out.println(count);

	}
	
	static void BFS(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		List<Point> list = new ArrayList<>();
		queue.add(new Point(x,y));
		visited[x][y] = true;
		int sum = 0;
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			list.add(t);
			sum += map[t.x][t.y];
			for (int i = 0; i < dirs.length; i++) {
				int xx = t.x + dirs[i][0];
				int yy = t.y + dirs[i][1];
				if(isIn(xx,yy) && !visited[xx][yy]) {
					if(Math.abs(map[t.x][t.y] - map[xx][yy]) <= high
							&& Math.abs(map[t.x][t.y] - map[xx][yy]) >= low) {
						queue.add(new Point(xx,yy));					
						visited[xx][yy] = true;
					}
				}					
			}
		}
		makeLevel(list, sum);
	}
	
	static void makeLevel(List<Point> list, int sum) {		
		if(list.size() > 1) {
			flag = false;
			int avr = sum / list.size();
			for (int i = 0; i < list.size(); i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				map[x][y] = avr;
			}
		}	
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
	
	static boolean isIn(int x, int y) {	
		return x>=0 && y>=0 && x<N && y<N;		
	}
}
