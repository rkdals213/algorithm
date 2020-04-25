package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_1697_S1_숨바꼭질 {
	static int N;
	static int M;
	static int [] visited = new int [100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		M = Integer.parseInt(temp.nextToken());
		for (int i = 0; i < visited.length; i++) {
			visited[i] = Integer.MAX_VALUE;
		}
		BFS();
	}

	static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N,0));
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int x = temp.x;
			int y = temp.y;
			if(x == M) {
				System.out.println(y);
				return;
			}
			if(x+1 < visited.length && visited[x+1] > y+1) {
				queue.add(new Point(x+1, y+1));
				visited[x+1] = y+1;
			}
			if(x-1 >= 0 && visited[x-1] > y+1) {
				queue.add(new Point(x-1, y+1));
				visited[x-1] = y+1;
			}
			if(x*2 < visited.length && visited[x*2] > y+1) {
				queue.add(new Point(x*2, y+1));
				visited[x*2] = y+1;
			}
			
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
