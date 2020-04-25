package algorithm_study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BAEK_1260_S1_DFS와BFS {
	static int N ;
	static int M ;
	static List<Integer>[] graph;
	private static Queue<Integer> queue = new LinkedList<>();
	private static List<Integer> path;
	private static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void BFS(int start) {
		boolean [] visited = new boolean [N+1];
		path = new ArrayList<>();
		queue.add(start);
		while(!queue.isEmpty()) {
			int temp = queue.poll();			
			if(!visited[temp]) {
				path.add(temp);
				visited[temp] = true;
				for (int i = 0; i < graph[temp].size(); i++) {
					if(!visited[graph[temp].get(i)]) {
						queue.add(graph[temp].get(i));
					}
				}				
			}
		}
		for (int i = 0; i < path.size(); i++) {
			sb.append(path.get(i)).append(" ");
		}
		sb.append("\n");
	}
	public static void DFS(int start) {
		boolean [] visited = new boolean [N+1];
		path = new ArrayList<>();
		stack.push(start);
		while(!stack.isEmpty()) {
			int temp = stack.pop();			
			if(!visited[temp]) {
				path.add(temp);
				visited[temp] = true;
				for (int i = graph[temp].size()-1; i >= 0 ; i--) {
					if(!visited[graph[temp].get(i)]) {
						stack.push(graph[temp].get(i));
					}
				}				
			}
		}
		for (int i = 0; i < path.size(); i++) {
			sb.append(path.get(i)).append(" ");
		}
		sb.append("\n");
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		int start = s.nextInt();		
		
		graph = new List[N+1];
		
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();			
		}
		for (int i = 1; i < M+1; i++) {
			int begin = s.nextInt();
			int end = s.nextInt();
			graph[begin].add(end);
			graph[end].add(begin);
		}
		
		for (int i = 1; i < N+1; i++) {
			graph[i].sort(null);
		}
		
		DFS(start);
		BFS(start);
		
		System.out.println(sb);
	}

}
