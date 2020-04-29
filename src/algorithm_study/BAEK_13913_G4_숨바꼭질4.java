package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_13913_G4_숨바꼭질4 {
	static int N,K;
	static int visited[] = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		N = Integer.parseInt(temp.nextToken());
		K = Integer.parseInt(temp.nextToken());
		Arrays.fill(visited, Integer.MAX_VALUE);
		if(N>=K) {
			System.out.println(N-K);
			for (int i = N; i >= K; i--) {
				System.out.print(i + " ");
			}
		}else {
			BFS();
		}
	}
	
	static void BFS(){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(N, 0, ""));
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 3; i++) {
				int next = 0;
				if(i==0) {
					next = p.x+1;
				}else if(i==1) {
					next = p.x-1;
				}else {
					next = p.x*2;
				}
				if(next == K) {
					System.out.println(p.count+1);
					System.out.println(p.path +" "+Integer.toString(next));
					return;
				}
				
				if(isIn(next) && p.count+1 < visited[next]) {
					queue.add(new Point(next, p.count+1, p.path.toString()));
					visited[next] = p.count+1;
				}
			}
		}
	}
	
	static boolean isIn(int x) {
		return x>=0 && x<= 100000;
	}
	
	static class Point{
		int x, count;
		StringBuilder path = new StringBuilder();

		public Point(int x, int count, String before) {
			super();
			this.x = x;
			this.count = count;
			this.path.append(before).append(" ").append(x);
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", count=" + count + ", path=" + path + "]";
		}
	}	
}
