package algo_basic.day06;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Maze {
	private static int [][] map = {
			{0,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,1,1,0,1,1,1,1},
			{1,1,1,0,1,1,1,1},
			{1,0,0,0,0,0,0,1},
			{1,0,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0}};
	private static int R=8, C=8;
	private static int [][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	private static boolean [][] visited = new boolean [R][C];
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void dfs() {
		// 탐색 시작점
		Point start = new Point(0,0);
		StringBuilder sb = new StringBuilder();
		Stack<Point> stack = new Stack<>();
		stack.push(start);
		outer: while(!stack.isEmpty()) {
			Point top = stack.pop();
			if(visited[top.r][top.c]) {
				continue;
			} 
			visited[top.r][top.c] = true;
			// 가능한 자식 탐색
			for (int i = 0; i < dirs.length; i++) {
				int nr = top.r+dirs[i][0];
				int nc = top.c+dirs[i][1];
				// 새로운 지점은 탐색 가능한가?
				if(isIn(nr,nc) && map[nr][nc] ==0 && !visited[nr][nc]) {
					sb.append("[r=" + nr + ", c=" + nc + "]").append(" ");
					if(nr==7 && nc ==7) {
						System.out.println("골인!!!!");
						break outer;
					}
					stack.push(new Point(nr, nc));	
					
				}
			}			
		}
		System.out.println(sb);
	}
	
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=00 && x<map.length && y<map.length;
	}
	
	public static void main(String[] args) {
		// 입력 확인
		for (int [] row : map) {
			System.out.println(Arrays.toString(row));
		}		
		dfs();
	}
}
