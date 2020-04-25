package algorithm_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;


public class SWEA_1861_D4_정사각형방 {
	static int map [][];
	static int dirs [][] = {{1,0},{0,1},{-1,0},{0,-1}};
	static ArrayList<Integer> list;
	static boolean [][] visited;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int TC = s.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			int minstart = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			sb.append("#").append(i+1).append(" ");
			int N = s.nextInt();
			map = new int [N][N];
			visited = new boolean[N][N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					map[j][j2] = s.nextInt();
				}
			}
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					if(!visited[j][j2]) {
						list = new ArrayList<>();
						DFS(j, j2);
						if(list.size() > max) {
							max = list.size();	
							int temp = Collections.min(list);							
							minstart = temp;
													
						}else if(list.size() == max) {							
							int temp = Collections.min(list);
							if(temp < minstart) {
								minstart = temp;
							}
						}
					}					
				}
			}
			sb.append(minstart).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void DFS(int i, int j) {
		Stack<Point> stack = new Stack<>();
		stack.add(new Point(i,j,map[i][j]));		
		visited[i][j] = true;
		while(!stack.isEmpty()) {
			Point temp = stack.pop();
			list.add(temp.v);
			for (int k = 0; k < dirs.length; k++) {
				int x = temp.i + dirs[k][0];
				int y = temp.j + dirs[k][1];
				if(isIn(x,y) && !visited[x][y]) {		
					if(map[temp.i][temp.j]-map[x][y] == 1 || map[temp.i][temp.j]-map[x][y] == -1) {
						stack.add(new Point(x, y, map[x][y]));
						visited[x][y] = true;		
					}												
				}
			}
		}		
	}
	public static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<map.length && y<map[0].length;
	}
	static class Point{
		int i, j, v;

		public Point(int i, int j, int v) {
			super();
			this.i = i;
			this.j = j;
			this.v = v;
		}
	}
}
