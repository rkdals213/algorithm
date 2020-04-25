package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BAEK_1600_G5_말이되고픈원숭이 {
	static boolean [][] map;
	static Queue<Point> queue = new LinkedList<>();
	private static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	private static int [][] horsedirs = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
	static int result = -1;	
	private static int N;
	private static int M;
	
	private static boolean [][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int horsedepth = Integer.parseInt(br.readLine());
		StringTokenizer temp = new StringTokenizer(br.readLine());
		M = Integer.parseInt(temp.nextToken());
		N = Integer.parseInt(temp.nextToken());
		
		map = new boolean [N][M];
		visited = new boolean [N][M][horsedepth+1];
		
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if(temp.nextToken().equals("1")) {
					map[i][j] = true;
				}				
			}
		}
		queue.add(new Point(0,0,0,0));
		map[0][0] = true;
		BFS(horsedepth);
		System.out.println(result);
	}
	
	public static void BFS(int horsedepth) {
		while(!queue.isEmpty()) {
			Point top = queue.poll();
			int count = top.count;			
			int dep = top.depth;
			if(top.x == N-1 && top.y == M-1) {
				result = count;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = top.x+dirs[i][0];
				int nc = top.y+dirs[i][1];
				if(isIn(nr,nc) && !visited[nr][nc][dep] && !map[nr][nc]) {
					queue.add(new Point(nr, nc, dep, count+1));	
					visited[nr][nc][dep] = true;	
				}
			}	
			if(dep == horsedepth) {					
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int nr = top.x+horsedirs[i][0];
				int nc = top.y+horsedirs[i][1];			
				
				if(isIn(nr,nc) && !visited[nr][nc][dep+1] && !map[nr][nc]) {	
					if(dep == horsedepth) {	
						continue;
					}					
					queue.add(new Point(nr, nc, dep+1, count+1));	
					visited[nr][nc][dep+1] = true;	
				}
			}			
		}
	}

	static class Point{
		int x;
		int y;
		int depth;
		int count;
		
		public Point(int x, int y, int depth, int count) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.count = count;
		}		
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}	
}

