package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2644_S2_촌수계산 {

	static List<Integer> [] list;
	static boolean [] visited;
	static int start;
	static int end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		
		list = new List[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		temp = new StringTokenizer(br.readLine());
		start = Integer.parseInt(temp.nextToken());
		end = Integer.parseInt(temp.nextToken());
		temp = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(temp.nextToken());
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(temp.nextToken());
			int k1 = Integer.parseInt(temp.nextToken());
			list[k].add(k1);
			list[k1].add(k);
		}

		BFS();
	}
	
	static void BFS() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(start, 0));
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int k = temp.x;
			int v = temp.y;
			if(k == end) {
				System.out.println(v);
				return;
			}
			for (int i = 0; i < list[k].size(); i++) {
				if(!visited[list[k].get(i)]) {
					queue.add(new Point(list[k].get(i), v+1));
					visited[list[k].get(i)] = true;
				}
			}
		}
		System.out.println(-1);
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