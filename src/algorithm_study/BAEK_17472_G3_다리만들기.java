package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BAEK_17472_G3_다리만들기 {
	static int N;
	static int M;
	static int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int [][] map;
	static boolean [][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static List<bridge> blist = new ArrayList<>();
	static int c = 1;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new int [N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		makePartition();
		findIsland();
		comb(c-2, new bridge [c-2], 0, 0);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	private static void comb(int r, bridge [] result, int cur, int start) {
		if(r == cur) {
			if(checktrue(result)) {
				int leng = 0;
				for (int i = 0; i < result.length; i++) {
					leng += result[i].length-1;
				}
				if(leng < min) {
					min = leng;
				}
			}			
		}else {
			for (int i = start; i < blist.size(); i++) {
				result[cur] = blist.get(i);
				comb(r, result, cur+1, i+1);
			}
		}
	}

	private static boolean checktrue(bridge [] r) {
		List<Integer>[] graph = new List[c];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < r.length; i++) {
			int a = r[i].s;
			int b = r[i].e;
			graph[a].add(b);
			graph[b].add(a);
		}
		boolean [] v = new boolean[c];
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < graph.length; i++) {
			if(!graph[i].isEmpty()) {
				stack.push(graph[i].get(0));
				break;
			}
		}
		while(!stack.isEmpty()) {
			Integer top = stack.pop();
			if(v[top]) {
				continue;
			} 		
			v[top] = true;
			List<Integer> childs = graph[top]; 
			for (int i = childs.size()-1; i >= 0; i--) {
				Integer child = childs.get(i); 
				if(!v[child]) {
					stack.push(child);						
				}
			}						
		}
		for (int i = 1; i < v.length; i++) {
			if(!v[i]) {
				return false;
			}
		}
		return true;
	}

	private static void makePartition() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					Queue<Point> t = new LinkedList<>();
					t.add(new Point(i,j));
					while(!t.isEmpty()) {
						Point tt = t.poll();
						int tx = tt.x;
						int ty = tt.y;
						map[tx][ty] = c;
						for (int k = 0; k < dirs.length; k++) {
							int ttx = tx + dirs[k][0];
							int tty = ty + dirs[k][1];
							if(isIn(ttx,tty) && map[ttx][tty] == 1 && !visited[ttx][tty]) {
								t.add(new Point(ttx,tty));								
								visited[ttx][tty] = true;
							}
						}
					}
					c++;
				}
			}
		}
	}

	private static void makeB() {
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			for (int i = 0; i < dirs.length; i++) {
				int xx = x+dirs[i][0];
				int yy = y+dirs[i][1];
				while(isIn(xx,yy) && map[xx][yy] == 0) {
					xx += dirs[i][0];
					yy += dirs[i][1];
					if(isIn(xx,yy) && map[xx][yy] != 0) {
						int k = Math.abs(x-xx) + Math.abs(y-yy);
						if(k < 3) continue;
						int a = map[x][y];
						int b = map[xx][yy];
						boolean f = false;
						for (int j = 0; j < blist.size(); j++) {
							int aa = blist.get(j).s;
							int bb = blist.get(j).e;
							int l = blist.get(j).length;
							if(a == bb && b == aa) {								
								blist.get(j).length = Math.min(l, k);
								f = true;
							}else if(a == aa && b == bb) {								
								blist.get(j).length = Math.min(l, k);
								f = true;
							}
						}
						if(!f) {
							blist.add(new bridge(a, b, k));
							break;
						}						
					}
				}
			}
		}
	}

	private static void findIsland() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					queue.add(new Point(i ,j));
				}
			}
		}
		makeB();
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
	}

	static class bridge {
		int s;		
		int e;
		int length;
		public bridge(int s, int e, int length) {
			super();
			this.s = s;
			this.e = e;
			this.length = length;
		}
		@Override
		public String toString() {
			return "bridge [s=" + s + ", e=" + e + ", length=" + length + "]";
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}
