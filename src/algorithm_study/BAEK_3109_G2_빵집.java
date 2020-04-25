package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;



public class BAEK_3109_G2_빵집 {
	static boolean [][] map;
	private static int [][] dirs = {{1,1},{0,1},{-1,1}};
	static boolean [][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		int M = Integer.parseInt(temp.nextToken());
		visited = new boolean [N][M];
		map = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String temp1 = br.readLine();
			for (int j = 0; j < M; j++) {
				if(temp1.charAt(j) == 'x') {
					map[i][j] = true;
				}
				
			}
		}		
		DFS(N, M);
		int result = 0;
		for (int i = 0; i < N; i++) {
			if(visited[i][M-1]) {
				result++;
			}
		}
		System.out.println(result);
	}
	
	static void DFS(int N, int M) {
		Stack<Point> stack = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			stack.push(new Point(i,0));			
			visited[i][0] = true;
			while(!stack.isEmpty()) {
				Point temp = stack.pop();				
				visited[temp.i][temp.j] = true;
				if(temp.j == M-1) {
					stack.clear();
					break;
				}
				for (int j = 0; j < dirs.length; j++) {
					int x = temp.i+dirs[j][0];
					int y = temp.j+dirs[j][1];
					if(isIn(x,y) && !visited[x][y] && !map[x][y]) {						
						stack.push(new Point(x,y));
					}
				}					
			}
		}		
	}
	
	static class Point{
		int i;
		int j;
		
		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}		
	}
	
	private static boolean isIn(int i, int j) {
		return i>=0 && j>=0 && i<map.length && j<map[0].length;
	}

}
