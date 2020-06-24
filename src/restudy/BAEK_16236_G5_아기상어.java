package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BAEK_16236_G5_아기상어 {
	static int N;
	static int [][] map;
	static PriorityQueue<Point> q = new PriorityQueue<>();
	static int [][] dir4 = {{-1,0},{0,-1},{0,1},{1,0}};
	static boolean [][] visited;
	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		visited = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
				if(map[i][j] == 9) {
					q.add(new Point(i,j,2,0,0));
					map[i][j] = 0;
					visited[i][j] = true;
				}
			}
		}

		BFS();

		System.out.println(result);

	}

	static void BFS() {
		while(!q.isEmpty()) {
			Point t = q.poll();
			
			if(map[t.x][t.y] != 0 && map[t.x][t.y] < t.size) {
				result = t.count;
				map[t.x][t.y] = 0;
				visited = new boolean [N][N];
				visited[t.x][t.y] = true;
				q.clear();
				q.add(new Point(t.x, t.y, t.size, t.eatcount+1, t.count));
				t = q.poll();
			}
			
			for (int i = 0; i < 4; i++) {
				int x = t.x+dir4[i][0];
				int y = t.y+dir4[i][1];
				if(isIn(x,y) && !visited[x][y]) {
					if(map[x][y] == 0 || map[x][y] <= t.size){
						q.add(new Point(x,y,t.size,t.eatcount,t.count+1));
						visited[x][y] = true;
					}
				}
			}
		}
	}

	static boolean isIn(int x, int y) {
		return x>=0 && y>=0 && x<N && y<N;
	}

	static class Point implements Comparable<Point>{
		int x, y, size, eatcount, count;

		public Point(int x, int y, int size, int eatcount, int count) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.eatcount = eatcount;
			this.count = count;
			if(this.eatcount == this.size) {
				this.size++;
				this.eatcount = 0;
			}
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", size=" + size + ", eatcount=" + eatcount + ", count=" + count
					+ "]";
		}

		@Override
		public int compareTo(Point o) {
			if(this.count == o.count) {
				if(this.x == o.x) {
					return Integer.compare(this.y, o.y);
				}else {
					return Integer.compare(this.x, o.x);
				}
			}else {
				return Integer.compare(this.count, o.count);
			}
		}
	}
}
