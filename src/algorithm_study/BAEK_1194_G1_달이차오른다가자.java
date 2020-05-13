package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1194_G1_달이차오른다가자 {
	static int N,M;
	static char [][] map;
	static boolean [][][] visited;
	static int [][] dir4 = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		map = new char [N][M];
		visited = new boolean [N][M][(1<<6)];
		Point start = null;
		for (int i = 0; i < N; i++) {
			String t = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = t.charAt(j);
				if(map[i][j] == '0') start = new Point(i,j,0,0);
			}
		}
		System.out.println(BFS(start));
	}

	static int BFS(Point s) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(s);
		while(!queue.isEmpty()) {
			Point t = queue.poll();
			for (int i = 0; i < dir4.length; i++) {
				int x = t.x + dir4[i][0];
				int y = t.y + dir4[i][1];
				if(!isIn(x, y) || map[x][y] =='#' || visited[x][y][t.key]) continue;
				
				if(map[x][y] == '1') return t.count+1;
				
				if(map[x][y] >= 'A' && map[x][y] <= 'F') {
					if(openDoor(t.key, map[x][y])) {
						queue.add(new Point(x, y, t.count+1, t.key));
						visited[x][y][t.key] = true;
					}
					continue;
				}
				int nk = t.key;
				if(map[x][y] >= 'a' && map[x][y] <= 'f') {
					nk = getKey(t.key, map[x][y]);					
				}
				queue.add(new Point(x, y, t.count+1, nk));
				visited[x][y][nk] = true;
			}
		}
		return -1;
	}

	static int getKey(int now, int key) {
		int add_value = (1 << (key - 'a'));
		return add_value | now;
	}
	static boolean openDoor(int now, char door)	{
	    int add_value = (1 << (door - 'A'));
	    return (add_value & now) > 0;
	}

	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<M;
	}

	static class Point{
		int x, y, count, key;

		public Point(int x, int y, int count, int key) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.key = key;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", count=" + count + ", key=" + key + "]";
		}
	}

}
