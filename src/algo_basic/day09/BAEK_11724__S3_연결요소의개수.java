package algo_basic.day09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


public class BAEK_11724__S3_연결요소의개수 {
	
	private static boolean [] visited;
	private static List<Integer>[] graph;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		graph = new List[N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = s.nextInt();
			int b = s.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		
		int count = 0;
		for (int i = 1; i < graph.length; i++) {
			if(!visited[i]) {	
				count++;
				BFS(i);			
			}
		}		
		System.out.println(count);
	}
	public static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>(); 
		queue.add(start);
		
		while(!queue.isEmpty()) {
			Integer temp = queue.poll();
			if(visited[temp]) {
				continue;
			}
			visited[temp] = true;
			
			List<Integer> childs = graph[temp]; 
			for (int i = 0; i < childs.size(); i++) {
				Integer child = childs.get(i); 
				if(!visited[child]) {
					queue.add(child);						
				}
			}	
		}
	}
	
	
}
