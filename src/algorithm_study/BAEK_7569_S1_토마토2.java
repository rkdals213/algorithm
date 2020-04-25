package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


public class BAEK_7569_S1_토마토2 {
	private static int [][] dirs = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};
	private static int [][][] box;
	private static boolean [][][] visited;

	public static int bfs() {
		Queue<Point> queue = new LinkedList<>();		 
		int max = 0;
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				for (int k = 0; k < box[i][j].length; k++) {
					if(box[i][j][k] == 1) {
						queue.add(new Point(j,k,i,0));
						visited[i][j][k] = true;
					}
				}				
			}
		}
		
		while(!queue.isEmpty()) {
			Point top = queue.poll();
			box[top.k][top.i][top.j] = 1;
			for (int i = 0; i < dirs.length; i++) {
				int nx = top.i+dirs[i][0];
				int ny = top.j+dirs[i][1];
				int nz = top.k+dirs[i][2];
				int dep = top.depth;
				if(isIn(nx,ny,nz) && box[nz][nx][ny] == 0) {
					if(!visited[nz][nx][ny]) {
						queue.add(new Point(nx, ny, nz, ++dep));
						visited[nz][nx][ny] = true;
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
			for (int j = 0; j < box[i].length; j++) {
				if(IntStream.of(box[i][j]).anyMatch(x -> x==0)) {
					return false;
				}
			}
			
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(s.readLine()); 
		int M = Integer.parseInt(temp.nextToken()); // 상자의 가로칸수
		int N = Integer.parseInt(temp.nextToken()); // 상자의 세로칸수
		int Z = Integer.parseInt(temp.nextToken()); // 상자의 세로칸수
		
		box = new int[Z][N][M];
		visited = new boolean[Z][N][M];
		for (int i = 0; i < Z; i++) {			
			for (int j = 0; j < N; j++) {
				StringTokenizer a = new StringTokenizer(s.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(a.nextToken());
				}
				
			}			
		}
		
		int max = bfs();

		if(findZero()) {
			System.out.println(max);
		}else {
			System.out.println(-1);
		}		
	}

	public static boolean isIn(int x, int y, int z) {
		return x>=0 && y>=0 && z >= 0 && z<box.length && x<box[0].length && y<box[0][0].length;
	}

	static class Point{
		int i, j, k, depth;

		public Point(int i, int j, int k, int depth) {
			super();
			this.i = i;
			this.j = j;
			this.k = k;
			this.depth = depth;
		}
	}
}
