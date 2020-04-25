package algorithm_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEK_2606_S2_바이러스 {
	static List<Integer> [] list;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer temp = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(temp.nextToken());
		temp = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(temp.nextToken());
		list = new List[N+1];
		visited = new boolean[N+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			temp = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(temp.nextToken());
			int k1 = Integer.parseInt(temp.nextToken());
			list[k].add(k1);
			list[k1].add(k);
		}

		BFS();
		int count = 0;
		for (int i = 1; i < visited.length; i++) {
			if(visited[i]) {
				count++;
			}
		}
		System.out.println(count-1);
	}
	
	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 0; i < list[k].size(); i++) {
				if(!visited[list[k].get(i)]) {
					queue.add(list[k].get(i));
					visited[list[k].get(i)] = true;
				}
			}
		}
	}
}
