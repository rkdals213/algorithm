package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class BAEK_7576_S1_토마토 {
	private static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	private static int [][] box;
	private static boolean [][] visited;

	public static int bfs() {
		Queue<Point> queue = new LinkedList<>();		 
		int max = 0;
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				if(box[i][j] == 1) {
					queue.add(new Point(i,j,0));
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point top = queue.poll();
			box[top.i][top.j] = 1;
			for (int i = 0; i < dirs.length; i++) {
				int nr = top.i+dirs[i][0];
				int nc = top.j+dirs[i][1];
				int dep = top.depth;
				if(isIn(nr,nc) && box[nr][nc] == 0) {
					if(!visited[nr][nc]) {
						queue.add(new Point(nr, nc, ++dep));
						visited[nr][nc] = true;
						if(dep > max) {
							max = dep;
						}
					}					
				}
			}			
		}
		return max;
	}
	
	public static boolean findZero() {
		for (int i = 0; i < box.length; i++) {
			if(IntStream.of(box[i]).anyMatch(x -> x==0)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(s.readLine()); 
		int M = Integer.parseInt(temp.nextToken()); // 상자의 가로칸수
		int N = Integer.parseInt(temp.nextToken()); // 상자의 세로칸수
		
		box = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < box.length; i++) {
			StringTokenizer a = new StringTokenizer(s.readLine());
			for (int j = 0; j < box[i].length; j++) {
				box[i][j] = Integer.parseInt(a.nextToken());
			}			
		}
		
		int max = bfs();

		if(findZero()) {
			System.out.println(max);
		}else {
			System.out.println(-1);
		}		
	}

	public static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<box.length && y<box[0].length;
	}

	static class Point{
		int i, j, depth;

		public Point(int i, int j, int depth) {
			super();
			this.i = i;
			this.j = j;
			this.depth = depth;
		}
	}
}
