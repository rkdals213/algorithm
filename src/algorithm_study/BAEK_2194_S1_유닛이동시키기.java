package algorithm_study;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEK_2194_S1_유닛이동시키기 {
	static boolean [][] map;
	static boolean [][] visited;
	private static int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int A;
	private static int B;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		A = s.nextInt();
		B = s.nextInt();
		int K = s.nextInt();
		map = new boolean[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			map[s.nextInt()-1][s.nextInt()-1] = true;
		}
		Point start = new Point(s.nextInt()-1, s.nextInt()-1,0);
		Point end = new Point(s.nextInt()-1, s.nextInt()-1,0);
		
		BFS(start, end);
	}
	
	static void BFS(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		visited[start.i][start.j] = true;
		while(!queue.isEmpty()) {
			Point temp = queue.poll();			
			for (int i = 0; i < dirs.length; i++) {
				int x = temp.i+dirs[i][0];
				int y = temp.j+dirs[i][1];
				
				if(x == end.i && y == end.j) {
					System.out.println(temp.count+1);
					return;
				}
				if(isIn(x,y) && !map[x][y] && isPossible(x, y)) {
					if(!visited[x][y]) {
						visited[x][y] = true;
						queue.add(new Point(x,y,temp.count+1));
					}					
					
				}
			}					
		}
		System.out.println(-1);
	}
	private static boolean isPossible(int i, int j) {
		if(i+A-1 < map.length && j+B-1 < map[0].length) {
			for (int j2 = i; j2 <= i+A-1; j2++) {
				for (int k = j; k <= j+B-1; k++) {
					if(map[j2][k]) return false;
				}
			}
		}else {
			return false;
		}		
		return true;
	}
	
	static class Point{
		int i;
		int j;
		int count;
		
		public Point(int i, int j, int count) {
			super();
			this.i = i;
			this.j = j;
			this.count = count;
		}		
	}
	
	private static boolean isIn(int i, int j) {
		return i>=0 && j>=0 && i<map.length && j<map[0].length;
	}

}
