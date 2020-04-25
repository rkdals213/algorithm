package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_16236_G5_아기상어 {
	static int[][] dirs = { { -1, 0 },{ 0, -1 },{ 0, 1 },{ 1, 0 } };
	static int[][] map;
	static boolean [][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static int result = 0;
	static PriorityQueue<Point> pqueue = new PriorityQueue<>(new Comparator<Point>() {
		
		@Override
		public int compare(Point o1, Point o2) {
			int time1 = o1.time;
			int time2 = o2.time;
			if(time1 != time2) {
				return time1-time2;
			}else {
				int x1 = o1.x;
				int x2 = o2.x;
				if(x1 != x2) {
					return x1-x2;
				}else {
					int y1 = o1.y;
					int y2 = o2.y;
					return y1-y2;
				}
			}			
		}
	});
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		map = new int [N][N];
		visited = new boolean [N][N];
		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
		findShark();
		BFS();

		System.out.println(result);
	}


	static void BFS() {
		int z = 0;
		int count = 0;
		int time = 0;
		while(!pqueue.isEmpty()) {
			Point temp = pqueue.poll();
			pqueue.clear();
			map[temp.x][temp.y] = 0;
			queue.add(temp);
			visited = new boolean [map.length][map.length];
			while(!queue.isEmpty()) {
				temp = queue.poll();
				z = temp.z;
				count = temp.count;
				time = temp.time;
				if(map[temp.x][temp.y] != 0 && map[temp.x][temp.y] < z) {
					pqueue.add(new Point(temp.x,temp.y,z,count+1,time));
					result = time;
				}
				for (int i = 0; i < dirs.length; i++) {
					int x = temp.x + dirs[i][0];
					int y = temp.y + dirs[i][1];
					if(isIn(x, y) && map[x][y] <= z && !visited[x][y]) {
						queue.add(new Point(x,y,z,count,time+1));	
						visited[x][y] = true;
					}
				}
			}			
		}	
	}

	static void findShark() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 9) {
					pqueue.add(new Point(i,j,2,0,0));
					map[i][j] = 0;
					return;
				}				
			}
		}
	}

	static class Point{
		int x;
		int y;
		int z;
		int count;
		int time;
		public Point(int x, int y, int z, int count, int time) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.count = count;
			this.time = time;
			if(count == z) {
				this.z++;
				this.count = 0;
			}
		}		
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < map.length && y < map[0].length;
	}

}
