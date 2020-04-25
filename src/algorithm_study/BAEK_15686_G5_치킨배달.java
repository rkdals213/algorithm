package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BAEK_15686_G5_치킨배달 {
	private static int [][] map;
	private static boolean [][] visited;
	private static int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
	private static int min = Integer.MAX_VALUE;
	private static int N, M;
	static Queue<Point> queue = new LinkedList<>();
	static Point [] forComb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());

		map = new int [N][N];		


		for (int i = 0; i < N; i++) {
			temp = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(temp.nextToken());
			}
		}
	
		int n = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 2) {
					n++;
				}
			}
		}
		
		forComb = new Point [n];
		int idx = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 2) {
					forComb[idx] = new Point(i,j,0);
					idx++;
				}
			}
		}
		makeCombination(M, new Point [n], 0, 0);
		System.out.println(min);
		
	}	

	private static int BFS() {		
		int sum = 0;		
		while(!queue.isEmpty()) {
			Point top = queue.poll();
			for (int i = 0; i < dirs.length; i++) {
				int x = top.i + dirs[i][0];
				int y = top.j + dirs[i][1];

				if((isIn(x,y) && map[x][y] != 1)) {
					if(!visited[x][y]) {
						visited[x][y] = true;
						queue.add(new Point(x,y,top.count+1));
					}
				}else if(isIn(x,y) && map[x][y] == 1) {
					if(!visited[x][y]) {
						visited[x][y] = true;
						//System.out.print(top.count + " ");
						queue.add(new Point(x,y,top.count+1));
						sum += top.count;
					}
				}
			}
		}
		if(sum < min) {
			min = sum;
		}
		return sum;
	}	

	public static void makeCombination(int r, Point [] temp, int current, int start) {
		if(current == r) {
			visited = new boolean [map.length][map[0].length];
			for (int i = 0; i < r; i++) {
				queue.add(new Point(temp[i].i, temp[i].j, 1));				
				visited[temp[i].i][temp[i].j] = true;		
				//System.out.println(temp[i]);
			}
			BFS();
			//System.out.println(BFS());
		}else {
			for (int i = start; i < forComb.length; i++) {
				temp[current] = forComb[i];
				makeCombination(r, temp, current+1, i+1);
			}
		}
	}

	private static boolean isIn(int i, int j) {
		return i>=0 && j>=0 && i<map.length && j<map[0].length;
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

		@Override
		public String toString() {
			return "Point [i=" + i + ", j=" + j + "]";
		}		
	}
}
