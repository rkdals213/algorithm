package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_2814_D3_최장경로 {
	static int N;
	static int M;
	static List<Integer> [] graph;
	static int max;
	static boolean [] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TC; i++) {
			sb.append("#").append(i+1).append(" ");
			StringTokenizer temp = new StringTokenizer(br.readLine());
			N = Integer.parseInt(temp.nextToken());
			M = Integer.parseInt(temp.nextToken());
			graph = new List[N+1];
			visited = new boolean [N+1];
			max = 1;
			for (int j = 0; j < N+1; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < M; j++) {
				temp = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(temp.nextToken());
				int b = Integer.parseInt(temp.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			for (int j = 1; j <= N; j++) {
				DFS(j,0);
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	static void DFS(int start, int depth) {
		max = Math.max(max, depth);
		
		for (int i = 0; i < graph[start].size(); i++) {
			int k = graph[start].get(i);
			if(!visited[k]) {
				visited[k] = true;
				DFS(k, depth+1);
				visited[k] = false;
			}
		}
	}
	static class Point {
		int x;
		int count;

		public Point(int x, int count) {
			super();
			this.x = x;
			this.count = count;
		}
	}
}
