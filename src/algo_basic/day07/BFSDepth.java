package algo_basic.day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDepth {
	private static String src = "1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7";
	private static int v = 7;
	private static boolean [] visited; // 방문 여부에 대한 저장
	
	private static List<Integer>[] graph = new List[v+1];
	private static Queue<Point> queue = new LinkedList<>(); // 
	private static List<Integer> path;	
	
	
	static class Point{
		Integer depth;
		Integer value;
		
		public Point(Integer depth, Integer value) {
			super();
			this.depth = depth;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Point [depth=" + depth + ", value=" + value + "]";
		}
		
	}
	
	public static void makeGraph() { // 리스트 단방향 그래프		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		String [] splited = src.split(" ");
		
		for (int i = 0; i < splited.length; i+=2) {
			int a = Integer.parseInt(splited[i]);
			int b = Integer.parseInt(splited[i+1]);
			graph[a].add(b);
		}
		for (List<Integer> list : graph) {
			System.out.println(list);
		}
	}
	
	public static void BFS(int start) {
		visited = new boolean[v+1];
		queue = new LinkedList<>();
		path = new ArrayList<>();
		
		queue.add(new Point(start, 0));
		
		while(!queue.isEmpty()) {
			Point temp = queue.poll();
			int dep = temp.depth;
			int val = temp.value;
			if(visited[val]) {
				continue;
			}
			visited[val] = true;
			path.add(val);
			
			List<Integer> childs = graph[val]; 
			for (int i = 0; i < childs.size(); i++) {
				Integer child = childs.get(i); // 다음에 가볼 집.. 언제나 방문?
				if(!visited[child]) {
					queue.add(new Point(dep+1, child));						
				}
			}	
		}
		System.out.println("탐색 종료 : 경로는 : " + path);
	}	
	
	public static void main(String[] args) {
		makeGraph();
		BFS(1);
	}
}
